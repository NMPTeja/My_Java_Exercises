package com.teja;

import java.util.Scanner;

public class LongestPalindromeSubstring {

    private static String longestPalindrome(String input) {
        if(checkIfPalindrome(input))
            return input;
        for(int i=0; i< input.length(); i++) {
            for (int len = 1; len <= input.length() - i; len++) {
                return "";
            }
        }
        return "";
    }

    private static boolean checkIfPalindrome(String input) {
        char[] s = input.toCharArray();
        int i=0, j=s.length-1;
        for(; i!=j; i++, j--) {
            //System.out.print(s[i]+" "+s[j]+"\n");
            if(s[i] != s[j])
                return false;
        }
        return true;
    }

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String input = sc.next();
        System.out.println("\nLongest palindrome is " + longestPalindrome(input));
        sc.close();
    }
}
