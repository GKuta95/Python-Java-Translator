import org.antlr.v4.runtime.ParserRuleContext;
        import org.antlr.v4.runtime.CommonTokenStream;
        import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * Created by grzesiek on 1/2/17.
 */
public class ASTWalker extends Python3BaseListener {
    private TokenStreamRewriter rewriter;

    public ASTWalker(CommonTokenStream stream) {
        this.rewriter = new TokenStreamRewriter(stream);
    }

    @Override
    public void enterWhile_stmt(Python3Parser.While_stmtContext ctx) {
        rewriter.replace(ctx.WHILE().getSymbol(), "while");
    }


    @Override
    public void enterExcept_stmt(Python3Parser.Except_stmtContext ctx) {
        rewriter.replace(ctx.EXCEPT().getSymbol(), "catch");
    }

    @Override
    public void enterFuncdef(Python3Parser.FuncdefContext ctx) {
        rewriter.replace(ctx.DEF().getSymbol(), "public void ");
    }

    @Override
    public void enterEnd_stmt(Python3Parser.End_stmtContext ctx) {
        rewriter.replace(ctx.END().getSymbol(),"}");
    }

    @Override public void enterAnd_stmt(Python3Parser.And_stmtContext ctx) {
        rewriter.replace(ctx.AND().getSymbol()," && ");
    }

    @Override public void enterAnd_test(Python3Parser.And_testContext ctx) {
    }

    @Override public void enterColon_stmt(Python3Parser.Colon_stmtContext ctx) {
        rewriter.replace(ctx.COLON().getSymbol(),"{");
    }

    @Override public void enterIf_stmt(Python3Parser.If_stmtContext ctx) {
        rewriter.replace(ctx.IF().getSymbol(),"if");
    }

    @Override
    public void enterOr_stmt(Python3Parser.Or_stmtContext ctx) {
        rewriter.replace(ctx.OR().getSymbol()," || ");
    }

    @Override
    public void enterRaise_stmt(Python3Parser.Raise_stmtContext ctx) {
        rewriter.replace(ctx.RAISE().getSymbol(),"throw new ");
    }

    @Override
    public void enterNot_stmt(Python3Parser.Not_stmtContext ctx) {
        rewriter.replace(ctx.NOT().getSymbol(),"!");
    }

    @Override
    public void enterPrint_stmt(Python3Parser.Print_stmtContext ctx) {
        rewriter.replace(ctx.PRINT().getSymbol(),"System.out.println");
    }

    @Override
    public void enterTrue_stmt(Python3Parser.True_stmtContext ctx) {
        rewriter.replace(ctx.TRUE().getSymbol(),"true");
    }

    @Override public void enterFalse_stmt(Python3Parser.False_stmtContext ctx) {
        rewriter.replace(ctx.FALSE().getSymbol(),"false");
    }

    @Override
    public void enterInt_stmt(Python3Parser.Int_stmtContext ctx) {
        rewriter.replace(ctx.INT().getSymbol(),"int ");
    }

    @Override
    public void enterStr_stmt(Python3Parser.Str_stmtContext ctx) {
        rewriter.replace(ctx.STR().getSymbol(),"String ");
    }

    @Override public void enterElif_stmt(Python3Parser.Elif_stmtContext ctx) {rewriter.replace(ctx.ELIF().getSymbol(),"else if"); }
    @Override public void enterIn_stmt(Python3Parser.In_stmtContext ctx) { rewriter.replace(ctx.IN().getSymbol()," : ");}
    @Override public void enterFloat_stmt(Python3Parser.Float_stmtContext ctx) { rewriter.replace(ctx.FLOAT().getSymbol(),"double ");}
    @Override public void enterSqrt_stmt(Python3Parser.Sqrt_stmtContext ctx) {rewriter.replace(ctx.SQRT().getSymbol(),"Math.sqrt"); }
    public String getASTWalkerResult() {
        return rewriter.getText();
    }
}


