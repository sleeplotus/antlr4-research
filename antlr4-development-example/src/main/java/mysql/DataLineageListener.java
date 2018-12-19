package mysql;

import mysql.antlr4.MySqlParser;
import mysql.antlr4.MySqlParserBaseListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王澎
 * @date 12/18/2018
 * @company VRV
 */
public class DataLineageListener extends MySqlParserBaseListener {

    List<String> tableName = new ArrayList<>();
    List<String> columnName = new ArrayList<>();
    boolean queryCreateTable = false;

    @Override
    public void enterTableName(MySqlParser.TableNameContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterTableName");
        System.out.println(ctx.getText());
        tableName.add(ctx.getText());
    }

    @Override
    public void enterCopyCreateTable(MySqlParser.CopyCreateTableContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterCopyCreateTable");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterQueryCreateTable(MySqlParser.QueryCreateTableContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterQueryCreateTable");
        System.out.println(ctx.getText());
        queryCreateTable = true;
    }

    @Override
    public void enterColumnCreateTable(MySqlParser.ColumnCreateTableContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterColumnCreateTable");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSimpleSelect");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterSelectColumnElement");
        System.out.println(ctx.getText());
        columnName.add(ctx.getText());
    }

    @Override
    public void enterInnerJoin(MySqlParser.InnerJoinContext ctx) {
        System.out.println("*********************************");
        System.out.println("ListenerName=EnterInnerJoin");
        System.out.println(ctx.getText());
    }



}
