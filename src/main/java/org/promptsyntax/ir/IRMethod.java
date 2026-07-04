package org.promptsyntax.ir;

import java.util.List;

public record IRMethod(
        String name,
        List<IRParameter> parameters,
        String returnType
) {}