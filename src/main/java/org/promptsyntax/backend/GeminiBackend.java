package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;

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

        for (IREntity entity : ir.entities()) {
            sb.append("Entity ").append(entity.name()).append(" must be implemented with these fields:\n");
            for (IRField field : entity.fields()) {
                sb.append("* ").append(field.type()).append(" ").append(field.name()).append("\n");
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
}