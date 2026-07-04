package org.promptsyntax.backend;

import org.promptsyntax.ir.IREntity;
import org.promptsyntax.ir.IRField;
import org.promptsyntax.ir.IRRelation;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.IRRelation;
import org.promptsyntax.ir.IREnum;

public final class GptBackend implements Backend {

    @Override
    public String name() {
        return "gpt";
    }

    @Override
    public String lower(PromptIR ir) {
        StringBuilder sb = new StringBuilder();

        sb.append("Generate ").append(displayTarget(ir.target())).append(" code.\n\n");
        sb.append("Return only generated source code without explanation.\n\n");

        ir.packageName().ifPresent(pkg -> sb.append("Use package: ").append(pkg).append("\n\n"));

        if (!ir.imports().isEmpty()) {
            sb.append("Imports:\n");
            for (String imp : ir.imports()) sb.append("- ").append(imp).append("\n");
            sb.append("\n");
        }

        for (IREntity entity : ir.entities()) {
            sb.append("Create an implementation for entity ").append(entity.name()).append(".\n\n");
            sb.append("Fields:\n");
            for (IRField field : entity.fields()) {
                sb.append("- ").append(field.type()).append(" ").append(field.name()).append("\n");
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

        if (!ir.constraints().isEmpty()) {
            sb.append("Constraints:\n");
            for (String c : ir.constraints()) sb.append("- Satisfy ").append(c).append(".\n");
            sb.append("\n");
        }

        if (!ir.generate().isEmpty()) {
            sb.append("Requirements:\n");
            for (String g : ir.generate()) sb.append("- Include ").append(g).append(".\n");
            sb.append("\n");
        }

        if (!ir.verify().isEmpty()) {
            sb.append("Validation expectations:\n");
            for (String v : ir.verify()) sb.append("- The output should pass ").append(v).append(".\n");
            sb.append("\n");
        }

        return sb.toString();
    }

    private String displayTarget(String target) {
        return switch (target) {
            case "Java17" -> "Java 17";
            case "Python3" -> "Python 3";
            case "C++17" -> "C++17";
            default -> target;
        };
    }
}
