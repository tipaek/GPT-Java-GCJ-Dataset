import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            int length = input.length();
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(input.charAt(i));
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}