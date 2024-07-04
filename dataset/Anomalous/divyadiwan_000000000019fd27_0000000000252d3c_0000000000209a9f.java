import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer input

        for (int t = 1; t <= T; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char c : input.toCharArray()) {
                int targetDepth = Character.getNumericValue(c);

                while (currentDepth < targetDepth) {
                    result.append("(");
                    currentDepth++;
                }

                while (currentDepth > targetDepth) {
                    result.append(")");
                    currentDepth--;
                }

                result.append(c);
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}