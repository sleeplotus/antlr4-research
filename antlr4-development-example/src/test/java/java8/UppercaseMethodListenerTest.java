package java8;

import java8.antlr4.Java8Lexer;
import java8.antlr4.Java8Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * @author 王澎
 * @date 12/18/2018
 * @company VRV
 */
public class UppercaseMethodListenerTest {

    @Test
    public void listenerTest() {
        // First, we construct the lexer
        String javaClassContent = "public class SampleClass { void DoSomething(){} }";
        Java8Lexer java8Lexer = new Java8Lexer(CharStreams.fromString(javaClassContent));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(java8Lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParseTree tree = parser.compilationUnit();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        UppercaseMethodListener listener = new UppercaseMethodListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);

        // Print result
        System.out.println(listener.errors);
    }

}
