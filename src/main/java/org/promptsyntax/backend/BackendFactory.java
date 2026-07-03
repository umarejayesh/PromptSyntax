package org.promptsyntax.backend;

public final class BackendFactory {
    private BackendFactory() {}

    public static Backend create(String name) {
        if (name == null || name.isBlank()) {
            return new GptBackend();
        }

        return switch (name.toLowerCase()) {
            case "gpt", "openai", "chatgpt" -> new GptBackend();
            case "claude", "anthropic" -> new ClaudeBackend();
            case "gemini", "google" -> new GeminiBackend();
            case "qwen" -> new QwenBackend();
            case "deepseek" -> new DeepSeekBackend();
            default -> throw new IllegalArgumentException("Unknown backend: " + name);
        };
    }
}