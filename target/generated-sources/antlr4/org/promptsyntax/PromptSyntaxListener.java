// Generated from org/promptsyntax/PromptSyntax.g4 by ANTLR 4.13.1
package org.promptsyntax;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PromptSyntaxParser}.
 */
public interface PromptSyntaxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PromptSyntaxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PromptSyntaxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#targetDecl}.
	 * @param ctx the parse tree
	 */
	void enterTargetDecl(PromptSyntaxParser.TargetDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#targetDecl}.
	 * @param ctx the parse tree
	 */
	void exitTargetDecl(PromptSyntaxParser.TargetDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void enterPackageDecl(PromptSyntaxParser.PackageDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#packageDecl}.
	 * @param ctx the parse tree
	 */
	void exitPackageDecl(PromptSyntaxParser.PackageDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#importBlock}.
	 * @param ctx the parse tree
	 */
	void enterImportBlock(PromptSyntaxParser.ImportBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#importBlock}.
	 * @param ctx the parse tree
	 */
	void exitImportBlock(PromptSyntaxParser.ImportBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#importItem}.
	 * @param ctx the parse tree
	 */
	void enterImportItem(PromptSyntaxParser.ImportItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#importItem}.
	 * @param ctx the parse tree
	 */
	void exitImportItem(PromptSyntaxParser.ImportItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(PromptSyntaxParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(PromptSyntaxParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityDecl(PromptSyntaxParser.EntityDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityDecl(PromptSyntaxParser.EntityDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(PromptSyntaxParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(PromptSyntaxParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(PromptSyntaxParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(PromptSyntaxParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#constraintBlock}.
	 * @param ctx the parse tree
	 */
	void enterConstraintBlock(PromptSyntaxParser.ConstraintBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#constraintBlock}.
	 * @param ctx the parse tree
	 */
	void exitConstraintBlock(PromptSyntaxParser.ConstraintBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#constraintItem}.
	 * @param ctx the parse tree
	 */
	void enterConstraintItem(PromptSyntaxParser.ConstraintItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#constraintItem}.
	 * @param ctx the parse tree
	 */
	void exitConstraintItem(PromptSyntaxParser.ConstraintItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#generateBlock}.
	 * @param ctx the parse tree
	 */
	void enterGenerateBlock(PromptSyntaxParser.GenerateBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#generateBlock}.
	 * @param ctx the parse tree
	 */
	void exitGenerateBlock(PromptSyntaxParser.GenerateBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#generateItem}.
	 * @param ctx the parse tree
	 */
	void enterGenerateItem(PromptSyntaxParser.GenerateItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#generateItem}.
	 * @param ctx the parse tree
	 */
	void exitGenerateItem(PromptSyntaxParser.GenerateItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#verifyBlock}.
	 * @param ctx the parse tree
	 */
	void enterVerifyBlock(PromptSyntaxParser.VerifyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#verifyBlock}.
	 * @param ctx the parse tree
	 */
	void exitVerifyBlock(PromptSyntaxParser.VerifyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PromptSyntaxParser#verifyItem}.
	 * @param ctx the parse tree
	 */
	void enterVerifyItem(PromptSyntaxParser.VerifyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PromptSyntaxParser#verifyItem}.
	 * @param ctx the parse tree
	 */
	void exitVerifyItem(PromptSyntaxParser.VerifyItemContext ctx);
}