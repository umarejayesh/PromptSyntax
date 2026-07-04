package org.promptsyntax.types;

public enum BuiltinType implements Type {

    INT("int"),
    LONG("long"),
    FLOAT("float"),
    DOUBLE("double"),
    BOOLEAN("boolean"),
    CHAR("char"),
    STRING("String"),
    DATE("Date"),
    UUID("UUID"),
    DECIMAL("Decimal");

    private final String text;

    BuiltinType(String text) {
        this.text = text;
    }

    @Override
    public String displayName() {
        return text;
    }

    public static BuiltinType fromName(String value) {
        for (BuiltinType t : values()) {
            if (t.text.equals(value))
                return t;
        }
        return null;
    }
}