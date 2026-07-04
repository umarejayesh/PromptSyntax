package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IRMethod;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.IREnum;
import org.promptsyntax.ir.IRMethod;

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
        appendEnums(sb, ir);
        
        for (IREntity entity : ir.entities()) {
            sb.append("Class/entity: ").append(entity.name()).append("\n");
            sb.append("Field specification:\n");
            for (IRField field : entity.fields()) {
                sb.append("- ").append(field.type()).append(" ").append(field.name()).append("\n");
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

	appendList(sb, "Constraints to satisfy", ir.constraints());
	appendList(sb, "Implementation requirements", ir.generate());
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