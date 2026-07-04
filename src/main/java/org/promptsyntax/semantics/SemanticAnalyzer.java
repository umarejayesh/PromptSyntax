package org.promptsyntax.semantics;

import org.promptsyntax.ast.EntityNode;
import org.promptsyntax.ast.EnumNode;
import org.promptsyntax.ast.FieldNode;
import org.promptsyntax.ast.ProgramNode;
import org.promptsyntax.types.Type;
import org.promptsyntax.types.TypeRegistry;

import java.util.HashSet;
import java.util.Set;

public final class SemanticAnalyzer {

    private static final Set<String> SUPPORTED_TARGETS =
            Set.of("Java17", "Python3", "C++17", "Rust", "Go");

    private static final Set<String> CONSTRAINT_VOCABULARY =
            Set.of("immutable", "documented", "serializable", "clean_code", "low_complexity");

    private static final Set<String> GENERATION_VOCABULARY =
            Set.of("class", "constructor", "getters", "setters", "builder", "tests",
                    "documentation", "equals", "hashcode", "tostring");

    private static final Set<String> VERIFICATION_VOCABULARY =
            Set.of("compile", "run_tests", "lint");

    public void analyze(ProgramNode program) {
        if (!SUPPORTED_TARGETS.contains(program.target())) {
            throw new SemanticException("Unsupported target: " + program.target());
        }

        if (program.entities().isEmpty()) {
            throw new SemanticException("At least one entity declaration is required.");
        }

        TypeRegistry registry = new TypeRegistry();
        Set<String> typeNames = new HashSet<>();

        for (EnumNode enumNode : program.enums()) {
            if (!typeNames.add(enumNode.name())) {
                throw new SemanticException("Duplicate enum declaration: " + enumNode.name());
            }

            if (enumNode.values().isEmpty()) {
                throw new SemanticException("Enum must contain at least one value: " + enumNode.name());
            }

            Set<String> enumValues = new HashSet<>();
            for (String value : enumNode.values()) {
                if (!enumValues.add(value)) {
                    throw new SemanticException("Duplicate enum value in " + enumNode.name() + ": " + value);
                }
            }

            registry.registerEnum(enumNode.name());
        }

        for (EntityNode entity : program.entities()) {
            if (!typeNames.add(entity.name())) {
                throw new SemanticException("Duplicate entity declaration: " + entity.name());
            }
            registry.registerEntity(entity.name());
        }

        Set<String> entityNames = new HashSet<>();

        for (EntityNode entity : program.entities()) {
            entityNames.add(entity.name());
        }

        for (EntityNode entity : program.entities()) {
            if (entity.parent().isPresent()) {
                String parent = entity.parent().get();

                if (!entityNames.contains(parent)) {
                    throw new SemanticException(
                            "Unknown parent entity for " + entity.name() + ": " + parent
                    );
                }

                if (entity.name().equals(parent)) {
                    throw new SemanticException(
                            "Entity cannot extend itself: " + entity.name()
                    );
                }
            }
        }

        

        for (EntityNode entity : program.entities()) {
            if (entity.fields().isEmpty()) {
                throw new SemanticException("Entity must contain at least one field: " + entity.name());
            }

            Set<String> fieldNames = new HashSet<>();

            for (FieldNode field : entity.fields()) {
                if (!fieldNames.add(field.name())) {
                    throw new SemanticException(
                            "Duplicate field declaration in entity " + entity.name() + ": " + field.name()
                    );
                }
                Set<String> methodNames = new HashSet<>();

                for (var method : entity.methods()) {
                    if (!methodNames.add(method.name())) {
                        throw new SemanticException(
                                "Duplicate method declaration in entity " + entity.name() + ": " + method.name()
                        );
                    }

                    if (resolveType(method.returnType(), registry) == null) {
                        throw new SemanticException(
                                "Unknown return type '" + method.returnType()
                                        + "' for method " + entity.name() + "." + method.name()
                        );
                    }

                    Set<String> parameterNames = new HashSet<>();

                    for (var parameter : method.parameters()) {
                        if (!parameterNames.add(parameter.name())) {
                            throw new SemanticException(
                                    "Duplicate parameter in method "
                                            + entity.name() + "." + method.name() + ": " + parameter.name()
                            );
                        }

                        if (resolveType(parameter.typeName(), registry) == null) {
                            throw new SemanticException(
                                    "Unknown parameter type '" + parameter.typeName()
                                            + "' for parameter " + entity.name() + "."
                                            + method.name() + "." + parameter.name()
                            );
                        }
                    }
                }

		Type resolvedType = resolveType(field.typeName(), registry);
		if (resolvedType == null) {
                    throw new SemanticException(
                            "Unknown type '" + field.typeName() + "' for field "
                                    + entity.name() + "." + field.name()
                    );
                }
            }
        }

        for (String c : program.constraints()) {
            if (!CONSTRAINT_VOCABULARY.contains(c)) {
                throw new SemanticException("Unknown constraint directive: " + c);
            }
        }

        if (program.generationDirectives().isEmpty()) {
            throw new SemanticException("Generate block must contain at least one directive.");
        }

        for (String g : program.generationDirectives()) {
            if (!GENERATION_VOCABULARY.contains(g)) {
                throw new SemanticException("Unknown generation directive: " + g);
            }
        }

        for (String v : program.verificationDirectives()) {
            if (!VERIFICATION_VOCABULARY.contains(v)) {
                throw new SemanticException("Unknown verification directive: " + v);
            }
        }

        Set<String> gen = new HashSet<>(program.generationDirectives());
        Set<String> ver = new HashSet<>(program.verificationDirectives());
        Set<String> cons = new HashSet<>(program.constraints());

        if (gen.contains("builder") && !gen.contains("constructor")) {
            throw new SemanticException("Directive builder requires constructor.");
        }

        if (ver.contains("run_tests") && !gen.contains("tests")) {
            throw new SemanticException("Verification run_tests requires generation directive tests.");
        }

        if (cons.contains("immutable") && gen.contains("setters")) {
            throw new SemanticException("Constraint immutable conflicts with setters.");
        }
    }
    private Type resolveType(String typeName, TypeRegistry registry) {
        if (registry.resolve(typeName) != null) {
            return registry.resolve(typeName);
        }

        if (typeName.startsWith("List<") && typeName.endsWith(">")) {
            String inner = typeName.substring(5, typeName.length() - 1);
            return resolveType(inner, registry) == null ? null : registry.resolve("List");
        }

        if (typeName.startsWith("Set<") && typeName.endsWith(">")) {
            String inner = typeName.substring(4, typeName.length() - 1);
            return resolveType(inner, registry) == null ? null : registry.resolve("Set");
        }

        if (typeName.startsWith("Map<") && typeName.endsWith(">")) {
            String inner = typeName.substring(4, typeName.length() - 1);
            int comma = inner.indexOf(',');
            if (comma < 0) return null;

            String keyType = inner.substring(0, comma);
            String valueType = inner.substring(comma + 1);

            return resolveType(keyType, registry) != null && resolveType(valueType, registry) != null
                    ? registry.resolve("Map")
                    : null;
        }

        return null;
    }
}