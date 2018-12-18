package mysql;

import mysql.antlr4.MySqlLexer;
import mysql.antlr4.MySqlParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王澎
 * @date 12/18/2018
 * @company VRV
 */
public class DataLineageListenerTest {

    @Test
    public void ddlStatementTest() {
        // First, we construct the lexer
        // As SQL grammar are normally not case sensitive but this grammar implementation is, you must use a custom character stream that converts all characters to uppercase before sending them to the lexer.
        String mySql = "create table c as select a.a1,a.a2,b.b1,b.b2 from a join b where a.a1 = b.b1".toUpperCase();
        MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(mySql));

        // Then, we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        MySqlParser parser = new MySqlParser(tokens);
        ParseTree tree = parser.ddlStatement();

        // And then, the walker and the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        DataLineageListener listener = new DataLineageListener();

        // Lastly, we tell ANTLR to walk through our sample class:
        walker.walk(listener, tree);

        // Print result
        System.out.println("*********************************");
        System.out.println(listener.tableName);
        System.out.println(listener.columnName);

        // Lineage
        System.out.println("*********************************");
        Map<String, List<String>> tableLineage = new HashMap<>();
        Map<String, List<String>> columnLineage = new HashMap<>();

        String dstTable = listener.tableName.get(0);
        listener.tableName.remove(0);
        tableLineage.put(dstTable, listener.tableName);
        System.out.println(tableLineage);

        String[] columnArray = null;
        List<String> columns = null;
        for (String columnName : listener.columnName) {
            columnArray = columnName.split("\\.");
            if (columnLineage.containsKey(columnArray[0])) {
                columnLineage.get(columnArray[0]).add(columnArray[1]);
            } else {
                columns = new ArrayList<String>();
                columns.add(columnArray[1]);
                columnLineage.put(columnArray[0], columns);
            }

        }
        System.out.println(columnLineage);
    }
}
