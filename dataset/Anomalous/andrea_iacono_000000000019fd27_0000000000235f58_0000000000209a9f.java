package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long testCases = scanner.nextLong();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            String result = calculateNestingDepth(inputString);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String calculateNestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            int depthChange = digit - currentDepth;

            if (depthChange > 0) {
                result.append(repeatChar('(', depthChange));
            } else if (depthChange < 0) {
                result.append(repeatChar(')', -depthChange));
            }

            result.append(digit);
            currentDepth = digit;
        }

        if (currentDepth > 0) {
            result.append(repeatChar(')', currentDepth));
        }

        return result.toString();
    }

    private static String repeatChar(char c, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}