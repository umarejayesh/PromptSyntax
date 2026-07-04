package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IRRelation;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.IREnum;

public class GeminiBackend implements Backend {
    @Override
    public String name() {
        return "gemini";
    }

    @Override
    public String lower(PromptIR ir) {
        StringBuilder sb = new StringBuilder();

        sb.append("Task: Generate ").append(ir.target()).append(" source code.\n");
        sb.append("Output format: source code only.\n\n");
        appendEnums(sb, ir);
        for (IREntity entity : ir.entities()) {
            sb.append("Entity ").append(entity.name()).append(" must be implemented with these fields:\n");
            for (IRField field : entity.fields()) {
                sb.append("* ").append(field.type()).append(" ").append(field.name()).append("\n");
            }
            sb.append("\n");
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

        appendList(sb, "Rules", ir.constraints());
        appendList(sb, "Required features", ir.generate());
        appendList(sb, "The generated code must satisfy", ir.verify());
    

        return sb.toString();
    }

    private void appendList(StringBuilder sb, String title, java.util.List<String> items) {
        if (items == null || items.isEmpty()) return;
        sb.append(title).append(":\n");
        for (String item : items) {
            sb.append("* ").append(item).append("\n");
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