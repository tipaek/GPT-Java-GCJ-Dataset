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

        long n = in.nextLong();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            String result = calculateNestingDepth(s);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String calculateNestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            int depthChange = digit - currentDepth;

            if (depthChange > 0) {
                result.append(repeatCharacter('(', depthChange));
            } else if (depthChange < 0) {
                result.append(repeatCharacter(')', -depthChange));
            }

            result.append(digit);
            currentDepth = digit;
        }

        if (currentDepth > 0) {
            result.append(repeatCharacter(')', currentDepth));
        }

        return result.toString();
    }

    private static String repeatCharacter(char c, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}