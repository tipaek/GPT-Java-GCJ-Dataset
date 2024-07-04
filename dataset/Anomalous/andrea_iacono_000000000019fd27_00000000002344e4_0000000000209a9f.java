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
        long testCases = scanner.nextLong();

        for (int i = 0; i < testCases; i++) {
            String sequence = scanner.next();
            String result = generateNestingDepth(sequence);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String generateNestingDepth(String sequence) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < sequence.length(); i++) {
            int digit = sequence.charAt(i) - '0';

            int openBrackets = digit - currentDepth;
            currentDepth += openBrackets;
            result.append(repeatChar(openBrackets, '(')).append(digit);

            int closeBrackets = 0;
            if (i < sequence.length() - 1) {
                int nextDigit = sequence.charAt(i + 1) - '0';
                if (digit > nextDigit) {
                    closeBrackets = digit - nextDigit;
                }
            } else {
                closeBrackets = currentDepth;
            }
            currentDepth -= closeBrackets;
            result.append(repeatChar(closeBrackets, ')'));
        }

        return result.toString();
    }

    private static String repeatChar(int count, char character) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
        return builder.toString();
    }
}