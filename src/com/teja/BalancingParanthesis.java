package com.teja;

import java.util.Scanner;
import java.util.Stack;

public class BalancingParanthesis {

    public static void main(String []args) {
        String input = "(){}[]{}(()){{}}";
        if(!validateInput(input)) {
            System.out.println("Input String invalid, please enter only paranthesis..");
            return;
        }
        checkBalancingParanthesis(input);
    }

    private static void checkBalancingParanthesis(String input) {
        Stack<Character> paranthesisChecker = new Stack<>();
        boolean mismatch = false;
        paranthesisChecker.push(input.charAt(0));
        for(int i=1; i<input.length(); i++) {
            if(!paranthesisChecker.isEmpty() && ((paranthesisChecker.peek() == '(' && input.charAt(i) == ')') || (paranthesisChecker.peek() == '{' && input.charAt(i) == '}') || (paranthesisChecker.peek() == '[' && input.charAt(i) == ']'))) {
                    paranthesisChecker.pop();
                    continue;
            }
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[')
                paranthesisChecker.push(input.charAt(i));
            else {
                mismatch = true;
                break;
            }
        }
        if(mismatch || paranthesisChecker.size() > 0)
            System.out.println("False");
        else
            System.out.println("True");
    }

    private static boolean validateInput(String input) {
        String value = input.replaceAll("[(){}\\[\\]]", "");
        if(value.length() > 0)
            return false;
        else
            return true;
    }
}
