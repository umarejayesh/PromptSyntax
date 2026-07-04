package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IRMethod;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.IRRelation;
import org.promptsyntax.ir.IREnum;
import org.promptsyntax.ir.IRMethod;

public class ClaudeBackend implements Backend {
    @Override
    public String name() {
        return "claude";
    }

    @Override
    public String lower(PromptIR ir) {
        StringBuilder sb = new StringBuilder();

        sb.append("You are an expert software engineer.\n\n");
        sb.append("Write clear, production-quality ").append(ir.target()).append(" code.\n");
        sb.append("Return only source code. Do not include explanation.\n\n");
        appendEnums(sb, ir);
        for (IREntity entity : ir.entities()) {
            sb.append("Implement entity: ").append(entity.name()).append("\n\n");
            sb.append("Fields:\n");
            for (IRField field : entity.fields()) {
                sb.append("- ").append(field.name()).append(": ").append(field.type()).append("\n");
            }
            sb.append("\n");
            if (!entity.methods().isEmpty()) {
                sb.append("Methods:\n");
                for (IRMethod method : entity.methods()) {
                    sb.append("- ")
                    .append(method.name())
                    .append("(");

                    sb.append(method.parameters().stream()
                    .map(p -> p.type() + " " + p.name())
                    .collect(java.util.stream.Collectors.joining(", ")));

                    sb.append(") : ")
                    .append(method.returnType())
                    .append("\n");
                }
                sb.append("\n");
            }
        }
        if (!ir.relations().isEmpty()) {
            sb.append("Relationships:\n");
            for (IRRelation r : ir.relations()) {
                sb.append("- ")
                        .append(r.sourceEntity())
                        .append(".")
                        .append(r.fieldName())
                        .append(" -> ")
                        .append(r.targetEntity())
                        .append("\n");
            }
            sb.append("\n");
        }
        appendList(sb, "Constraints", ir.constraints());
        appendList(sb, "Generation requirements", ir.generate());
        appendList(sb, "Validation expectations", ir.verify());

        return sb.toString();
    }

    private void appendList(StringBuilder sb, String title, java.util.List<String> items) {
        if (items == null || items.isEmpty()) return;
        sb.append(title).append(":\n");
        for (String item : items) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("\n");
    }
    private void appendEnums(StringBuilder sb, PromptIR ir) {
        if (ir.enums().isEmpty()) return;

        sb.append("Enumerations:\n");
        for (IREnum e : ir.enums()) {
            sb.append("- ")
                    .append(e.name())
                    .append(" values: ")
                    .append(String.join(", ", e.values()))
                    .append("\n");
        }
        sb.append("\n");
    }
}