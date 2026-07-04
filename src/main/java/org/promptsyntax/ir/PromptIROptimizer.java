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

        List<IREnum> enums = new ArrayList<>(ir.enums());
        enums.sort(Comparator.comparing(IREnum::name));

        List<IREnum> normalizedEnums = enums.stream()
                .map(e -> new IREnum(e.name(), unique(e.values())))
                .toList();

        List<IRRelation> relations = new ArrayList<>(ir.relations());
        relations.sort(
                Comparator.comparing(IRRelation::sourceEntity)
                        .thenComparing(IRRelation::fieldName)
                        .thenComparing(IRRelation::targetEntity)
        );

        return new PromptIR(
                ir.irVersion(),
                ir.sourceLanguage(),
                ir.target(),
                ir.packageName(),
                unique(ir.imports()),
                normalizedEnums,
                normalizedEntities,
                unique(ir.interfaces()),
                List.copyOf(relations),
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