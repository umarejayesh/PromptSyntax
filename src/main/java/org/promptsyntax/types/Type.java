package org.promptsyntax.types;

public sealed interface Type
        permits BuiltinType, EntityType {

    String displayName();
}