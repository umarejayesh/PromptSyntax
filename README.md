# PromptSyntax Compiler v1.0 — Java/ANTLR4 Reference Implementation

This is a stronger reference implementation structure for the POPL-style PromptSyntax project.

Pipeline:

```text
PromptSyntax source
    ↓
ANTLR4 Lexer/Parser
    ↓
AST Builder
    ↓
Static Semantic Analyzer / Type Checker
    ↓
PromptIR JSON
    ↓
PromptIR Optimizer
    ↓
Backend Lowering
    ↓
GPT / Claude / Gemini / Qwen prompt
    ↓
Validation Engine
```

## Requirements

- Java 17+
- Maven 3.9+

## Build

```bash
mvn clean package
```

## Run

```bash
java -jar target/promptsyntax-compiler-1.0.0.jar examples/student.psx --backend gpt --out out
```

## Expected outputs

```text
out/student.promptir.json
out/student.gpt.prompt
out/validation_report.json
```

## Notes

This version includes:

- `PromptSyntax.g4` ANTLR grammar
- AST classes
- AST builder
- semantic analyzer
- PromptIR generator
- optimizer
- backend lowering modules
- validation report generator
- command-line driver


## Version 1.1 additions

This version adds:

- optional `package` declaration
- optional `imports` block
- optional `constraints` block
- generation directives: `equals`, `hashcode`, `tostring`
- semantic conflict check: `immutable` cannot be combined with `setters`

Run:

```bash
mvn clean package
java -jar target/promptsyntax-compiler-1.0.0.jar examples/student_v11.psx --backend gpt --out out
```

Test semantic error:

```bash
java -jar target/promptsyntax-compiler-1.0.0.jar examples/invalid_immutable_setters.psx --backend gpt --out out
```
