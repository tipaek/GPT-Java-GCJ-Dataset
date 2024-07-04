import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            for (int i = 1; i <= testCases; i++) {
                String input = scanner.nextLine();
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < input.length(); j++) {
                    String currentChar = input.substring(j, j + 1);
                    result.append(generateParentheses(currentChar));
                }
                String finalResult = result.toString();
                while (finalResult.contains(")(")) {
                    finalResult = finalResult.replace(")(", "");
                }
                System.out.println("Case #" + i + ": " + finalResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateParentheses(String digit) {
        int num = Integer.parseInt(digit);
        StringBuilder parentheses = new StringBuilder();
        for (int i = 0; i < num; i++) {
            parentheses.append("(");
        }
        parentheses.append(num);
        for (int i = 0; i < num; i++) {
            parentheses.append(")");
        }
        return parentheses.toString();
    }
}