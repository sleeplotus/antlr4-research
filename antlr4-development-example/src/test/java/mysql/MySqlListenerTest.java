package mysql;

import mysql.antlr4.MySqlLexer;
import mysql.antlr4.MySqlParser;
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
public class MySqlListenerTest {

    @Test
    public void dmlStatementTest() {
        // First, we construct the lexer
        // As SQL grammar are normally not case sensitive but this grammar implementation is, you must use a custom character stream that converts all characters to uppercase before sending them to the lexer.
        String mySql = "select id,name,max(area_code) from area group by id,name".toUpperCase();
        MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(mySql));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.dmlStatement();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlListener listener = new MySqlListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);
    }

    @Test
    public void insertStatementTest() {
        // First, we construct the lexer
        // As SQL grammar are normally not case sensitive but this grammar implementation is, you must use a custom character stream that converts all characters to uppercase before sending them to the lexer.
        String mySql = "insert into area(id,name) values(1,'Jame')".toUpperCase();
        MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(mySql));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.insertStatement();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlListener listener = new MySqlListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);
    }

    @Test
    public void deleteStatementTest() {
        // First, we construct the lexer
        // As SQL grammar are normally not case sensitive but this grammar implementation is, you must use a custom character stream that converts all characters to uppercase before sending them to the lexer.
        String mySql = "delete from area where id = 1".toUpperCase();
        MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(mySql));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.deleteStatement();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlListener listener = new MySqlListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);
    }

    @Test
    public void updateStatementTest() {
        // First, we construct the lexer
        // As SQL grammar are normally not case sensitive but this grammar implementation is, you must use a custom character stream that converts all characters to uppercase before sending them to the lexer.
        String mySql = "update area set name = 'Jame' where id = 1".toUpperCase();
        MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(mySql));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.updateStatement();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlListener listener = new MySqlListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);
    }

    @Test
    public void selectStatementTest() {
        // First, we construct the lexer
        // As SQL grammar are normally not case sensitive but this grammar implementation is, you must use a custom character stream that converts all characters to uppercase before sending them to the lexer.
        String mySql = "select id,name from area".toUpperCase();
        MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(mySql));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.selectStatement();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MySqlListener listener = new MySqlListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);
    }
}
