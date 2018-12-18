package java8;

import java8.antlr4.Java8BaseListener;
import java8.antlr4.Java8Parser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王澎
 * @date 12/17/2018
 * @company VRV
 */
public class UppercaseMethodListener extends Java8BaseListener {
    private List<String> errors = new ArrayList<>();

    // ... getter for errors

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        TerminalNode node = ctx.Identifier();
        String methodName = node.getText();

        if (Character.isUpperCase(methodName.charAt(0))) {
            String error = String.format("Method %s is uppercased!", methodName);
            errors.add(error);
        }
    }
}
