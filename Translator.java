/**
 * Created by grzesiek on 1/20/17.
 */
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
public class Translator {
    private ANTLRInputStream input;
    private Python3Lexer lexer ;
    private CommonTokenStream token;
    private Python3Parser parser;
    private ParseTree tree;

    public  String rewrite(String result){
        String myclass = "//WARNING!: PUT TYPES IF IT'S NECESSARY\nclass Main{\npublic static void main(String[] args){\n";
        result = result.replace("\n",";\n");
        result = result.replace("{;\n","{\n");
        result = result.replace("};\n","}\n");

        result = myclass + result + "}\n}";
        return result;
    }

    public String translationResult(String input){
        this.input = new ANTLRInputStream(input);
        this.lexer = new Python3Lexer(this.input);
        this.token = new CommonTokenStream(this.lexer);
        this.parser = new Python3Parser(this.token);
        this.tree = this.parser.file_input();
        ParseTreeWalker walker = new ParseTreeWalker();
        ASTWalker astWalker = new ASTWalker(this.token);
        walker.walk(astWalker,tree);
        String result = astWalker.getASTWalkerResult();
        return result;

    }

}
