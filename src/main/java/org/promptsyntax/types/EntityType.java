package org.promptsyntax.types;

public record EntityType(String entityName) implements Type {

    @Override
    public String displayName() {
        return entityName;
    }
}