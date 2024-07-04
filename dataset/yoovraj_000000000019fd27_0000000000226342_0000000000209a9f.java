/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author yoovraj.shinde
 */
public class Solution {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            solve(s, t);
        }
    }    
    public static void solve(final String s, int testCaseNumber) {
        String[] s_split = s.split("(?<=(.))(?!\\1)");
        for (int i = 0; i < s_split.length; i++) {
            if (!s_split[i].contains("0")) {
                int n = Integer.valueOf(s_split[i].substring(0, 1));
                char[] char_s, char_e;
                char_s = new char[n];
                char_e = new char[n];
                Arrays.fill(char_s, '(');
                Arrays.fill(char_e, ')');
                s_split[i] = new String(char_s) + s_split[i] + new String(char_e);
            }
        }
        String combinedString = Arrays.toString(s_split)
                .replace(" ", "").replace(",", "").replace("[", "").replace("]", "").trim();
        String finalString = combinedString.replace(")(", "");
        while (true) {
            if(!finalString.equals(combinedString)) {
                finalString = combinedString;
                combinedString = combinedString.replace(")(", "");
                
            } else {
                break;
            }
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + finalString);
    }
}
