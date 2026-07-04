package org.promptsyntax.ir;

import java.util.List;

public record IREnum(
        String name,
        List<String> values
) {}