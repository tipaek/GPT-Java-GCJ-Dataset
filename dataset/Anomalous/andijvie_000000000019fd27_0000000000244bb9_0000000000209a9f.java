import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine().trim());
        
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            System.out.println(formatWithParentheses(input));
        }
    }

    private static String formatWithParentheses(String input) {
        StringBuilder output = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            int difference = digit - currentDepth;

            if (difference > 0) {
                output.append("(".repeat(difference));
            } else if (difference < 0) {
                output.append(")".repeat(-difference));
            }

            output.append(ch);
            currentDepth = digit;
        }

        output.append(")".repeat(currentDepth));
        return output.toString();
    }
}