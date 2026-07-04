package org.promptsyntax.ast;

import java.util.List;

public record InterfaceNode(
        String name,
        List<FieldNode> fields
) {}