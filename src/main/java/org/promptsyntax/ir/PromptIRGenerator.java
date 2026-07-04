package org.promptsyntax.ir;

import org.promptsyntax.ast.EntityNode;
import org.promptsyntax.ast.FieldNode;
import org.promptsyntax.ast.ProgramNode;

import java.util.List;
import java.util.Map;

public final class PromptIRGenerator {

    public PromptIR generate(ProgramNode program) {
        List<IREntity> entities = program.entities().stream()
                .map(this::entityToIR)
                .toList();

        return new PromptIR(
                "2.0",
                "PromptSyntax",
                program.target(),
                program.packageName(),
                List.copyOf(program.imports()),
                entities,
                List.of(),
                List.of(),
                List.of(),
                List.copyOf(program.constraints()),
                List.copyOf(program.generationDirectives()),
                List.copyOf(program.verificationDirectives()),
                Map.of(),
                Map.of("version", "2.0", "ir", "PromptIR")
        );
    }

    private IREntity entityToIR(EntityNode entity) {
        return new IREntity(entity.name(), entity.fields().stream().map(this::fieldToIR).toList());
    }

    private IRField fieldToIR(FieldNode field) {
        return new IRField(field.name(), field.typeName());
    }
}