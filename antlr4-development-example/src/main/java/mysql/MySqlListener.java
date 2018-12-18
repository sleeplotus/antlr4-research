package mysql;

import mysql.antlr4.MySqlParser;
import mysql.antlr4.MySqlParserBaseListener;

/**
 * @author 王澎
 * @date 12/18/2018
 * @company VRV
 */
public class MySqlListener extends MySqlParserBaseListener {

    @Override
    public void enterTableName(MySqlParser.TableNameContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterTableName");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterFullColumnName(MySqlParser.FullColumnNameContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterFullColumnName");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterInsertStatement(MySqlParser.InsertStatementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterInsertStatement");
        System.out.println(ctx.getText());
    }

    @Override
    public void exitInsertStatement(MySqlParser.InsertStatementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=ExitInsertStatement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterDeleteStatement(MySqlParser.DeleteStatementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterInsertStatement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterUpdateStatement(MySqlParser.UpdateStatementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterUpdateStatement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSimpleSelect");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSelectElements(MySqlParser.SelectElementsContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSelectElements");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSelectColumnElement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSelectFunctionElement(MySqlParser.SelectFunctionElementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSelectFunctionElement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterGroupByItem(MySqlParser.GroupByItemContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterGroupByItem");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSelectStarElement(MySqlParser.SelectStarElementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSelectStarElement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSelectFieldsInto(MySqlParser.SelectFieldsIntoContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSelectFieldsInto");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterDmlStatement(MySqlParser.DmlStatementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterDmlStatement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterDdlStatement(MySqlParser.DdlStatementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterDdlStatement");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterDropTable(MySqlParser.DropTableContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterDropTable");
        System.out.println(ctx.getText());
    }

}
