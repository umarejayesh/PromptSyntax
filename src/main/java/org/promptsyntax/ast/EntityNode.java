package org.promptsyntax.ast;

import java.util.List;

public record EntityNode(
        String name,
        List<FieldNode> fields
) {}