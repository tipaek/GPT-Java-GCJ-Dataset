import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digitChar);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }
}