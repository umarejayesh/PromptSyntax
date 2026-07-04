package org.promptsyntax.frontend;

import org.promptsyntax.ast.EntityNode;
import org.promptsyntax.ast.EnumNode;
import org.promptsyntax.ast.FieldNode;
import org.promptsyntax.ast.ProgramNode;
import org.promptsyntax.PromptSyntaxBaseVisitor;
import org.promptsyntax.PromptSyntaxParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AstBuilder extends PromptSyntaxBaseVisitor<Object> {

    @Override
    public ProgramNode visitProgram(PromptSyntaxParser.ProgramContext ctx) {
        String target = ctx.targetDecl().IDENTIFIER().getText();

        Optional<String> packageName = Optional.empty();
        if (ctx.packageDecl() != null) {
            packageName = Optional.of(ctx.packageDecl().qualifiedName().getText());
        }

        List<String> imports = new ArrayList<>();
        if (ctx.importBlock() != null) {
            for (PromptSyntaxParser.ImportItemContext ictx : ctx.importBlock().importItem()) {
                imports.add(ictx.getText().replace(";", ""));
            }
        }

        List<EnumNode> enums = new ArrayList<>();
        List<EntityNode> entities = new ArrayList<>();

        for (PromptSyntaxParser.TopLevelDeclContext dctx : ctx.topLevelDecl()) {
            if (dctx.enumDecl() != null) {
                enums.add((EnumNode) visitEnumDecl(dctx.enumDecl()));
            } else if (dctx.entityDecl() != null) {
                entities.add((EntityNode) visitEntityDecl(dctx.entityDecl()));
            }
        }

        List<String> constraints = new ArrayList<>();
        if (ctx.constraintBlock() != null) {
            for (PromptSyntaxParser.ConstraintItemContext cctx : ctx.constraintBlock().constraintItem()) {
                constraints.add(cctx.getChild(0).getText());
            }
        }

        List<String> generation = new ArrayList<>();
        for (PromptSyntaxParser.GenerateItemContext gctx : ctx.generateBlock().generateItem()) {
            generation.add(gctx.getChild(0).getText());
        }

        List<String> verification = new ArrayList<>();
        if (ctx.verifyBlock() != null) {
            for (PromptSyntaxParser.VerifyItemContext vctx : ctx.verifyBlock().verifyItem()) {
                verification.add(vctx.getChild(0).getText());
            }
        }

        return new ProgramNode(target, packageName, imports, enums, entities, constraints, generation, verification);
    }

    @Override
    public EnumNode visitEnumDecl(PromptSyntaxParser.EnumDeclContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        List<String> values = new ArrayList<>();
        for (PromptSyntaxParser.EnumItemContext item : ctx.enumItem()) {
            values.add(item.IDENTIFIER().getText());
        }
        return new EnumNode(name, values);
    }

    @Override
    public EntityNode visitEntityDecl(PromptSyntaxParser.EntityDeclContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        List<FieldNode> fields = new ArrayList<>();
        for (PromptSyntaxParser.FieldDeclContext fctx : ctx.fieldDecl()) {
            fields.add((FieldNode) visitFieldDecl(fctx));
        }
        return new EntityNode(name, fields);
    }

    @Override
    public FieldNode visitFieldDecl(PromptSyntaxParser.FieldDeclContext ctx) {
        return new FieldNode(ctx.IDENTIFIER().getText(), ctx.typeName().IDENTIFIER().getText());
    }
}