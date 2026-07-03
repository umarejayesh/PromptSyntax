package org.promptsyntax.ir;

import java.util.List;

public record IREntity(
        String name,
        List<IRField> fields
) {}