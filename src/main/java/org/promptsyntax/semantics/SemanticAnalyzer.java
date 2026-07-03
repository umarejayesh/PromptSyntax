package org.promptsyntax.semantics;

import org.promptsyntax.ast.EntityNode;
import org.promptsyntax.ast.FieldNode;
import org.promptsyntax.ast.ProgramNode;

import java.util.HashSet;
import java.util.Set;

public final class SemanticAnalyzer {

    private static final Set<String> SUPPORTED_TARGETS =
            Set.of("Java17", "Python3", "C++17", "Rust", "Go");

    private static final Set<String> PRIMITIVE_TYPES =
            Set.of("int", "long", "float", "double", "boolean", "char", "String");

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

        Set<String> entityNames = new HashSet<>();
        Set<String> declaredTypes = new HashSet<>();

        for (EntityNode entity : program.entities()) {
            if (!entityNames.add(entity.name())) {
                throw new SemanticException("Duplicate entity declaration: " + entity.name());
            }
            declaredTypes.add(entity.name());
        }

        for (EntityNode entity : program.entities()) {
            if (entity.fields().isEmpty()) {
                throw new SemanticException("Entity must contain at least one field: " + entity.name());
            }

            Set<String> fieldNames = new HashSet<>();
            for (FieldNode field : entity.fields()) {
                if (!fieldNames.add(field.name())) {
                    throw new SemanticException("Duplicate field declaration in entity " + entity.name() + ": " + field.name());
                }

                if (!PRIMITIVE_TYPES.contains(field.typeName()) && !declaredTypes.contains(field.typeName())) {
                    throw new SemanticException("Unknown type for field " + entity.name() + "." + field.name() + ": " + field.typeName());
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
}
