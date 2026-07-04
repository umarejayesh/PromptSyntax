package org.promptsyntax.ast;

import java.util.List;
import java.util.Optional;

public record ProgramNode(
        String target,
        Optional<String> packageName,
        List<String> imports,
        List<EnumNode> enums,
        List<InterfaceNode> interfaces,
        List<EntityNode> entities,
        List<String> constraints,
        List<String> generationDirectives,
        List<String> verificationDirectives
) {}