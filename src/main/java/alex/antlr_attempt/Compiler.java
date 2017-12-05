package alex.antlr_attempt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CharStreams;

import alex.antlr_attempt.parsers.Java8Lexer;
import alex.antlr_attempt.parsers.Java8Parser;
import alex.antlr_attempt.parsers.Java8Parser.ClassDeclarationContext;
import alex.antlr_attempt.parsers.Java8Parser.PackageDeclarationContext;
import alex.antlr_attempt.parsers.Java8Parser.CompilationUnitContext;
import alex.antlr_attempt.MyVisitor;


public class Compiler {
	
	public static void main(String[] args) {
	    try {
	    		
	    		String filePath = "./src/main/java/alex/antlr_attempt/example_no_comments.java";
	    	
	    		// Java8Lexer lexer = new Java8Lexer(CharStreams.fromFileName(args[0]));
	    		Java8Lexer lexer = new Java8Lexer(CharStreams.fromFileName(filePath));
	    		
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			
	  		Java8Parser parser = new Java8Parser(tokens);
	  		
	  		MyVisitor<String> visitor = new MyVisitor<String>();
	  		
	  		Java8Parser.CompilationUnitContext ctx = parser.compilationUnit();
	  		
	  		visitor.visit(ctx);
	  		
	  		/*List<String> methodNames = getMethodNames(ctx);
	  		
	  		for(String methodName : methodNames) {
	  			System.out.println(methodName);
	  		}*/
	  		
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static List<String> getMethodNames(Java8Parser.CompilationUnitContext ctx) {
		/*output: isOk(intvalue)*/
		
		List<Java8Parser.ClassBodyDeclarationContext> methods = ctx.typeDeclaration().get(0).classDeclaration().normalClassDeclaration().classBody().classBodyDeclaration();
		
		List<String> output = new ArrayList<String>();
		
		for(Java8Parser.ClassBodyDeclarationContext method: methods ) {
			//output.add(method.classMemberDeclaration().methodDeclaration().methodHeader().methodDeclarator().getText());
			output.add(method.classMemberDeclaration().methodDeclaration().methodHeader().methodDeclarator().Identifier().getText());

		}
		
		return output;
	}

}
