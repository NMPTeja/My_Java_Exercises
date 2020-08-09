package com.teja;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleCalculator {

    public static void main(String[] arg) {
        String input = "- ( 3 + ( 2 - 1 ) )";

        System.out.println(calculateResult(sanitize(input)));
    }

    private static String sanitize(String input) {
        return input.trim()
                    .replaceAll("\\s", "");
    }

    private static String calculateResult(String input) {

        String expr = new StringBuilder(input).reverse().toString();
        Deque<String> store = new ArrayDeque<>();
        Integer result = 0;
        for(int i=0; i< expr.length(); i++) {
            if(expr.charAt(i) != '(') {
                store.push(expr.charAt(i)+"");
            } else {
                i++;
                String evalExp = "";
                while(!store.peek().equals(")")) {
                    evalExp += store.pop();
                }
                result = result + evaluateExpr(evalExp);
                store.push(result.toString());
            }
        }
        String evalExp = "";
        while(!store.isEmpty()) {
            if(!store.equals(")"))
                evalExp += store.pop();
        }
        result = result + evaluateExpr(evalExp);

        return "";
    }

    private static Integer evaluateExpr(String exp) {
        if(exp.matches("[+-]?[0-9]+"))
            return new Integer(exp);
        int interim = exp.charAt(0);
        for(int c=1; c<exp.length(); c++) {
            if(exp.charAt(c) == '-') {
                interim = interim - exp.charAt(++c);
            } else if(exp.charAt(c) == '+') {
                interim = interim + exp.charAt(++c);
            }
        }
        return interim;
    }

}
