package org.promptsyntax.ast;

import java.util.List;

public record EntityNode(
        String name,
        List<String> interfaces,
        List<FieldNode> fields,
        List<MethodNode> methods
) {}