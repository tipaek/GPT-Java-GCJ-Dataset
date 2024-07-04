import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder solution = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);

                if (num > currentDepth) {
                    solution.append("(".repeat(num - currentDepth));
                } else if (num < currentDepth) {
                    solution.append(")".repeat(currentDepth - num));
                }

                solution.append(num);
                currentDepth = num;
            }

            // Close any remaining open parentheses
            if (currentDepth > 0) {
                solution.append(")".repeat(currentDepth));
            }

            System.out.println("Case #" + i + ": " + solution);
        }

        scanner.close();
    }
}