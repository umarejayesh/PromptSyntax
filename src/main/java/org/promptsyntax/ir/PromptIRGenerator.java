package org.promptsyntax.ir;

import org.promptsyntax.ast.EntityNode;
import org.promptsyntax.ast.FieldNode;
import org.promptsyntax.ast.MethodNode;
import org.promptsyntax.ast.ParameterNode;
import org.promptsyntax.ast.ProgramNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class PromptIRGenerator {

    public PromptIR generate(ProgramNode program) {
        Set<String> entityNames = program.entities().stream()
                .map(EntityNode::name)
                .collect(Collectors.toSet());

        List<IREnum> enums = program.enums().stream()
                .map(e -> new IREnum(e.name(), List.copyOf(e.values())))
                .toList();

        List<IRInterface> interfaces = program.interfaces().stream()
                .map(i -> new IRInterface(
                        i.name(),
                        i.fields().stream().map(this::fieldToIR).toList()
                ))
                .toList();

        List<IREntity> entities = program.entities().stream()
                .map(this::entityToIR)
                .toList();

        List<IRRelation> relations = new ArrayList<>();
        for (EntityNode entity : program.entities()) {
            for (FieldNode field : entity.fields()) {
                if (entityNames.contains(field.typeName())) {
                    relations.add(new IRRelation(entity.name(), field.name(), field.typeName()));
                }
            }
        }

        return new PromptIR(
                "2.3",
                "PromptSyntax",
                program.target(),
                program.moduleName(),
                program.packageName(),
                List.copyOf(program.imports()),
                enums,
                interfaces,
                entities,
                List.copyOf(relations),
                List.copyOf(program.constraints()),
                List.copyOf(program.generationDirectives()),
                List.copyOf(program.verificationDirectives()),
                Map.of(),
                Map.of(
                        "version", "2.3",
                        "ir", "PromptIR",
                        "enums", String.valueOf(enums.size()),
                        "interfaces", String.valueOf(interfaces.size()),
                        "relations", String.valueOf(relations.size())
                )
        );
    }

    private IREntity entityToIR(EntityNode entity) {
        return new IREntity(
                entity.name(),
                entity.parent(),
                List.copyOf(entity.interfaces()),
                entity.fields().stream()
                        .map(this::fieldToIR)
                        .toList(),
                entity.methods().stream()
                        .map(this::methodToIR)
                        .toList()
        );
    }

    private IRField fieldToIR(FieldNode field) {
        return new IRField(field.name(), field.typeName());
    }

    private IRMethod methodToIR(MethodNode method) {
        return new IRMethod(
                method.name(),
                method.parameters().stream()
                        .map(this::parameterToIR)
                        .toList(),
                method.returnType(),
                method.contracts().stream()
                        .map(c -> new IRContract(c.kind(), c.expression()))
                        .toList()
        );
        }

    private IRParameter parameterToIR(ParameterNode parameter) {
        return new IRParameter(
                parameter.name(),
                parameter.typeName()
        );
    }
}