package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class Solution {

    static String input = "8\n" +
            "0000\n" +
            "101\n" +
            "111000\n" +
            "1\n" +
            "021\n" +
            "312\n" +
            "4\n" +
            "221\n";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            String s = in.next();
            String result = nestingDepth(s);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String nestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}