package org.promptsyntax.ir;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public record PromptIR(
        String irVersion,
        String sourceLanguage,
        String target,
        Optional<String> packageName,
        List<String> imports,
        List<IREnum> enums,
        List<IRInterface> interfaces,
        List<IREntity> entities,
        List<IRRelation> relations,
        List<String> constraints,
        List<String> generate,
        List<String> verify,
        Map<String, String> backendHints,
        Map<String, String> metadata
) {}