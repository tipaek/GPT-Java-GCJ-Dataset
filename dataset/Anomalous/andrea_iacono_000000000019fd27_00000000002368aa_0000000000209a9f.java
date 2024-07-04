import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long testCases = scanner.nextLong();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            String output = calculateNestingDepth(input);
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            int depthDifference = digit - currentDepth;

            if (depthDifference > 0) {
                appendCharacters(result, '(', depthDifference);
            } else if (depthDifference < 0) {
                appendCharacters(result, ')', -depthDifference);
            }

            result.append(digit);
            currentDepth = digit;
        }

        if (currentDepth > 0) {
            appendCharacters(result, ')', currentDepth);
        }

        return result.toString();
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}