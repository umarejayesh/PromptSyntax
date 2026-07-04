package org.promptsyntax.ir;

import org.promptsyntax.ast.EntityNode;
import org.promptsyntax.ast.FieldNode;
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

        List<IREntity> entities = program.entities().stream()
                .map(this::entityToIR)
                .toList();

        List<IRRelation> relations = new ArrayList<>();
        for (EntityNode entity : program.entities()) {
            for (FieldNode field : entity.fields()) {
                if (entityNames.contains(field.typeName())) {
                    relations.add(new IRRelation(
                            entity.name(),
                            field.name(),
                            field.typeName()
                    ));
                }
            }
        }

        return new PromptIR(
                "2.1",
                "PromptSyntax",
                program.target(),
                program.packageName(),
                List.copyOf(program.imports()),
                entities,
                List.of(),
                List.of(),
                List.copyOf(relations),
                List.copyOf(program.constraints()),
                List.copyOf(program.generationDirectives()),
                List.copyOf(program.verificationDirectives()),
                Map.of(),
                Map.of("version", "2.1", "ir", "PromptIR", "relations", String.valueOf(relations.size()))
        );
    }

    private IREntity entityToIR(EntityNode entity) {
        return new IREntity(entity.name(), entity.fields().stream().map(this::fieldToIR).toList());
    }

    private IRField fieldToIR(FieldNode field) {
        return new IRField(field.name(), field.typeName());
    }
}