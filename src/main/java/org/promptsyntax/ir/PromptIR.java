package org.promptsyntax.ir;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record PromptIR(
        String target,
        Optional<String> packageName,
        List<String> imports,
        List<IREntity> entities,
        List<String> constraints,
        List<String> generate,
        List<String> verify,
        Map<String, String> metadata
) {}
