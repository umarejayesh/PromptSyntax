package org.promptsyntax.ir;

import java.util.List;
import java.util.Optional;

public record IREntity(
        String name,
        Optional<String> parent,
        List<String> interfaces,
        List<IRField> fields,
        List<IRMethod> methods
) {}