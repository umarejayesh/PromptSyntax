package org.promptsyntax.ir;

public record IRRelation(
        String sourceEntity,
        String fieldName,
        String targetEntity
) {}