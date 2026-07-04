package org.promptsyntax.ast;

import java.util.List;

public record MethodNode(
        String name,
        List<ParameterNode> parameters,
        String returnType,
        List<ContractNode> contracts
) {}