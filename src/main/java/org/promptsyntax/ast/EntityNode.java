package org.promptsyntax.ast;

import java.util.List;
import java.util.Optional;

public record EntityNode(
        String name,
        Optional<String> parent,
        List<String> interfaces,
        List<FieldNode> fields,
        List<MethodNode> methods
) {}