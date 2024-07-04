import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine();
            results[i] = processInput(input);
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static String processInput(String input) {
        StringBuilder output = new StringBuilder();
        int[] digits = input.chars().map(c -> c - '0').toArray();
        int currentDepth = 0;

        for (int digit : digits) {
            while (currentDepth < digit) {
                output.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                output.append(')');
                currentDepth--;
            }
            output.append(digit);
        }

        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }

        return output.toString();
    }
}