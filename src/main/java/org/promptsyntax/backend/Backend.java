package org.promptsyntax.backend;

import org.promptsyntax.ir.PromptIR;

public interface Backend {
    String name();

    String lower(PromptIR ir);
}