import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine() + "0"; // Append '0' to ensure proper closing of parentheses
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(ch);
            }

            // Remove the last appended '0'
            result.setLength(result.length() - 1);

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}