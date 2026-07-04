package org.promptsyntax.ir;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

public final class PromptIROptimizer {

    public PromptIR optimize(PromptIR ir) {
        List<IREntity> entities = new ArrayList<>(ir.entities());
        entities.sort(Comparator.comparing(IREntity::name));

        List<IREntity> normalizedEntities = entities.stream()
                .map(e -> new IREntity(
                        e.name(),
                        e.fields().stream().sorted(Comparator.comparing(IRField::name)).toList()
                ))
                .toList();

        return new PromptIR(
                ir.irVersion(),
                ir.sourceLanguage(),
                ir.target(),
                ir.packageName(),
                unique(ir.imports()),
                normalizedEntities,
                unique(ir.enums()),
                unique(ir.interfaces()),
                unique(ir.relations()),
                unique(ir.constraints()),
                unique(ir.generate()),
                unique(ir.verify()),
                ir.backendHints(),
                ir.metadata()
        );
    }

    private List<String> unique(List<String> input) {
        return new ArrayList<>(new LinkedHashSet<>(input));
    }
}