package org.promptsyntax.ir;

import java.util.List;

public record IRInterface(
        String name,
        List<IRField> fields
) {}