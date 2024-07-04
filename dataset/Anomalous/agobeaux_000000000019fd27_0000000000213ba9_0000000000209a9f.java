import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentOpenParentheses = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentOpenParentheses < digit) {
                    result.append("(");
                    currentOpenParentheses++;
                }

                while (currentOpenParentheses > digit) {
                    result.append(")");
                    currentOpenParentheses--;
                }

                result.append(ch);
            }

            while (currentOpenParentheses > 0) {
                result.append(")");
                currentOpenParentheses--;
            }

            System.out.printf("Case #%d: %s%n", i, result.toString());
        }

        scanner.close();
    }
}