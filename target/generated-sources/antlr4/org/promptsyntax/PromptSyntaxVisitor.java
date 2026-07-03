// Generated from org/promptsyntax/PromptSyntax.g4 by ANTLR 4.13.1
package org.promptsyntax;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PromptSyntaxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PromptSyntaxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PromptSyntaxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#targetDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetDecl(PromptSyntaxParser.TargetDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#packageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDecl(PromptSyntaxParser.PackageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#importBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportBlock(PromptSyntaxParser.ImportBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#importItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportItem(PromptSyntaxParser.ImportItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(PromptSyntaxParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#entityDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityDecl(PromptSyntaxParser.EntityDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(PromptSyntaxParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(PromptSyntaxParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#constraintBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintBlock(PromptSyntaxParser.ConstraintBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#constraintItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintItem(PromptSyntaxParser.ConstraintItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#generateBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerateBlock(PromptSyntaxParser.GenerateBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#generateItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerateItem(PromptSyntaxParser.GenerateItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#verifyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerifyBlock(PromptSyntaxParser.VerifyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PromptSyntaxParser#verifyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerifyItem(PromptSyntaxParser.VerifyItemContext ctx);
}