import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int digit = Character.getNumericValue(currentChar);

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(currentChar);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.printf("Case #%d: %s\n", t, result.toString());
        }
    }
}