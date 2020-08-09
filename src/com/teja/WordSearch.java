package com.teja;

import jdk.nashorn.internal.objects.Global;

import java.util.ArrayList;
import java.util.logging.Logger;

public class WordSearch {

    public static void main(String[] arg) {
        char[][] input =
                {{'F', 'A', 'C', 'I', 'P'},
                 {'O', 'B', 'Q', 'P', 'D'},
                 {'A', 'N', 'O', 'B', 'A'},
                 {'M', 'A', 'S', 'S', 'Q'}};
        String word = "aq";
        //System.out.println(input.length);
        System.out.println(checkIfWordEcolValueists(input, word));
    }

    private static boolean checkIfWordEcolValueists(char[][] input, String word) {
        word = word.toUpperCase();
        for(char[] row: input) {
            if(String.valueOf(row).contains(word))
                return true;
        }

        for(int col=0; col < input[0].length ; col++) {
            StringBuilder sb = new StringBuilder();
            for(int row=0; row<input.length; row++) {
                //System.out.println(row + "-" + col + "-" + input[row][col]);
                sb.append(input[row][col]);
            }
            if(sb.toString().contains(word))
                return true;
        }


        return false;
    }
}
