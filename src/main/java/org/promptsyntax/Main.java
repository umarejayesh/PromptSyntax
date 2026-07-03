package org.promptsyntax;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.promptsyntax.ast.ProgramNode;
import org.promptsyntax.backend.Backend;
import org.promptsyntax.backend.GptBackend;
import org.promptsyntax.frontend.AstBuilder;
import org.promptsyntax.ir.PromptIR;
import org.promptsyntax.ir.PromptIRGenerator;
import org.promptsyntax.ir.PromptIROptimizer;
import org.promptsyntax.semantics.SemanticAnalyzer;

import java.nio.file.Files;
import java.nio.file.Path;

public final class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: promptsyntax <file.psx>");
            System.exit(1);
        }

        String source = Files.readString(Path.of(args[0]));

        CharStream input = CharStreams.fromString(source);
        PromptSyntaxLexer lexer = new PromptSyntaxLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PromptSyntaxParser parser = new PromptSyntaxParser(tokens);

        lexer.removeErrorListeners();
        parser.removeErrorListeners();

        SyntaxErrorCollector syntaxErrors = new SyntaxErrorCollector();
        lexer.addErrorListener(syntaxErrors);
        parser.addErrorListener(syntaxErrors);

        ParseTree tree = parser.program();

        if (syntaxErrors.hasErrors()) {
            System.err.println("Syntax errors found:");
            System.err.println(syntaxErrors.getErrors());
            System.exit(1);
        }

        AstBuilder astBuilder = new AstBuilder();
        ProgramNode ast = (ProgramNode) astBuilder.visit(tree);

        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
        semanticAnalyzer.analyze(ast);

        PromptIRGenerator irGenerator = new PromptIRGenerator();
        PromptIR ir = irGenerator.generate(ast);

        PromptIROptimizer optimizer = new PromptIROptimizer();
        PromptIR optimizedIR = optimizer.optimize(ir);

        Backend backend = new GptBackend();
        String prompt = backend.lower(optimizedIR);

        System.out.println("=== PromptSyntax Compilation Successful ===");
        System.out.println();
        System.out.println("Target: " + optimizedIR.target());
        System.out.println("Entities: " + optimizedIR.entities().size());
        System.out.println("Backend: " + backend.name());
        System.out.println();
        System.out.println("=== Generated Backend Prompt ===");
        System.out.println(prompt);
    }

    private static final class SyntaxErrorCollector extends BaseErrorListener {
        private final StringBuilder errors = new StringBuilder();

        @Override
        public void syntaxError(
                Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line,
                int charPositionInLine,
                String msg,
                RecognitionException e
        ) {
            errors.append("line ")
                    .append(line)
                    .append(":")
                    .append(charPositionInLine)
                    .append(" ")
                    .append(msg)
                    .append(System.lineSeparator());
        }

        boolean hasErrors() {
            return !errors.isEmpty();
        }

        String getErrors() {
            return errors.toString();
        }
    }
}