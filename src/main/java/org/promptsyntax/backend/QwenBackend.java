package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;

public class QwenBackend implements Backend {
    @Override
    public String name() {
        return "qwen";
    }

    @Override
    public String lower(PromptIR ir) {
        StringBuilder sb = new StringBuilder();

        sb.append("Generate ").append(ir.target()).append(" code.\n");
        sb.append("Strictly return code only.\n\n");

        for (IREntity entity : ir.entities()) {
            sb.append("Class/entity: ").append(entity.name()).append("\n");
            sb.append("Field specification:\n");
            for (IRField field : entity.fields()) {
                sb.append("- ").append(field.type()).append(" ").append(field.name()).append("\n");
            }
            sb.append("\n");
        }

        appendList(sb, "Constraints to satisfy", ir.constraints());
        appendList(sb, "Implementation requirements", ir.verify());
        appendList(sb, "Verification goals", ir.verify());

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
}