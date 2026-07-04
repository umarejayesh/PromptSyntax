package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.IREnum;

public class DeepSeekBackend implements Backend {
    @Override
    public String name() {
        return "deepseek";
    }

    @Override
    public String lower(PromptIR ir) {
        StringBuilder sb = new StringBuilder();

        sb.append("You are generating compilable ").append(ir.target()).append(" code.\n");
        sb.append("Only output the final source code.\n\n");
        appendEnums(sb, ir);
        for (IREntity entity : ir.entities()) {
            sb.append("Implement: ").append(entity.name()).append("\n");
            sb.append("Members:\n");
            for (IRField field : entity.fields()) {
                sb.append("- ").append(field.type()).append(" ").append(field.name()).append("\n");
            }
            sb.append("\n");
        }

	    appendList(sb, "Semantic constraints", ir.constraints());
	    appendList(sb, "Required code elements", ir.generate());
	    appendList(sb, "Validation criteria", ir.verify());


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