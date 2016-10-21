package gramatica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.Program;
import visitor.PrettyPrintVisitor;

public class Teste {

	public static void main(String[] args) throws IOException {
		File f1 = new File("C:\\Users\\Lapp\\Desktop\\AST MiniJava\\testes\\BinarySearch.txt");
		FileInputStream f = new FileInputStream(f1);
		ANTLRInputStream in = new ANTLRInputStream(f);
		MiniJavaGrammarLexer lex = new MiniJavaGrammarLexer(in);
		CommonTokenStream tok = new CommonTokenStream(lex);
		MiniJavaGrammarParser pars = new MiniJavaGrammarParser(tok);
		//ParseTree tree = pars.goal();
		Semente s = new Semente();
		Program p = s.getProgram(pars.goal());
		PrettyPrintVisitor ppv = new PrettyPrintVisitor();
		p.accept(ppv);
		
	}

}
