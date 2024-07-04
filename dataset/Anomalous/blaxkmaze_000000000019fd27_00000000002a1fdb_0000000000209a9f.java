import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String nestingDepth(String input) {
        StringBuilder builder = new StringBuilder();
        int previousDigit = 0;

        for (char c : input.toCharArray()) {
            int currentDigit = c - '0';

            if (previousDigit < currentDigit) {
                builder.append("(".repeat(currentDigit - previousDigit));
            } else if (previousDigit > currentDigit) {
                builder.append(")".repeat(previousDigit - currentDigit));
            }

            builder.append(c);
            previousDigit = currentDigit;
        }

        builder.append(")".repeat(previousDigit));
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String output = nestingDepth(input);
            System.out.println("Case #" + i + ": " + output);
        }
    }
}