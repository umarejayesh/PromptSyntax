package org.promptsyntax.backend;

import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IRMethod;
import org.promptsyntax.ir.IRContract;
import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.IREnum;
import org.promptsyntax.ir.IRInterface;
import org.promptsyntax.ir.IRContract;

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
        appendInterfaces(sb, ir);
        for (IREntity entity : ir.entities()) {
            sb.append("Implement: ").append(entity.name()).append("\n");
            if (!entity.interfaces().isEmpty()) {
                sb.append("Implements:\n");
                for (String iface : entity.interfaces()) {
                    sb.append("- ").append(iface).append("\n");
                }
                sb.append("\n");
            }
            sb.append("Members:\n");
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

                    if (!method.contracts().isEmpty()) {
                        sb.append("  Contracts:\n");
                        for (IRContract contract : method.contracts()) {
                            sb.append("  - ")
                                    .append(contract.kind())
                                    .append(" ")
                                    .append(contract.expression())
                                    .append("\n");
                        }
                    }
                }
                sb.append("\n");
            }
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

private void appendInterfaces(StringBuilder sb, PromptIR ir) {
    if (ir.interfaces().isEmpty()) return;

    sb.append("Interfaces:\n");
    for (IRInterface iface : ir.interfaces()) {
        sb.append("- ").append(iface.name()).append("\n");
        sb.append("  Fields:\n");
        for (IRField field : iface.fields()) {
            sb.append("  - ")
                    .append(field.type())
                    .append(" ")
                    .append(field.name())
                    .append("\n");
        }
    }
    sb.append("\n");
}
}