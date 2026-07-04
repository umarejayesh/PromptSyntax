package org.promptsyntax.ast;

import java.util.List;

public record EnumNode(
        String name,
        List<String> values
) {}