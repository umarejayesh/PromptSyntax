package org.promptsyntax.types;

import java.util.HashMap;
import java.util.Map;

public final class TypeRegistry {
    private final Map<String, Type> types = new HashMap<>();

    public TypeRegistry() {
        for (BuiltinType type : BuiltinType.values()) {
            types.put(type.displayName(), type);
        }
    }

    public void registerEntity(String entityName) {
        types.put(entityName, new EntityType(entityName));
    }

    public Type resolve(String typeName) {
        return types.get(typeName);
    }

    public boolean contains(String typeName) {
        return types.containsKey(typeName);
    }
}