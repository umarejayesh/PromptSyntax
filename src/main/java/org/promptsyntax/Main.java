package org.promptsyntax;

import org.promptsyntax.lexer.Lexer;
import org.promptsyntax.lexer.Token;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java -jar promptsyntax.jar <file.psx>");
            System.exit(1);
        }

        String source = Files.readString(Path.of(args[0]));

        Lexer lexer = new Lexer(source);
        List<Token> tokens = lexer.tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}