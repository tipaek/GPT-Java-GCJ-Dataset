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
        Scanner scanner = new Scanner(new BufferedReader(new StringReader(input)));
        long numberOfCases = scanner.nextLong();

        for (int i = 0; i < numberOfCases; i++) {
            String s = scanner.next();
            String result = calculateNestingDepth(s);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String calculateNestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            int openBrackets = digit - currentDepth;

            if (openBrackets > 0) {
                result.append(repeatChar(openBrackets, '('));
                currentDepth = digit;
            } else if (openBrackets < 0) {
                result.append(repeatChar(-openBrackets, ')'));
                currentDepth = digit;
            }

            result.append(digit);
        }

        if (currentDepth > 0) {
            result.append(repeatChar(currentDepth, ')'));
        }

        return result.toString();
    }

    private static String repeatChar(int count, char c) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}