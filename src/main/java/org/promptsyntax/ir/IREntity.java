package org.promptsyntax.ir;

import java.util.List;

public record IREntity(
        String name,
        List<String> interfaces,
        List<IRField> fields,
        List<IRMethod> methods
) {}