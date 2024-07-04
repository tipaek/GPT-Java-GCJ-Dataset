import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = input.charAt(0) - '0';

            // Append opening brackets for the first digit
            for (int i = 0; i < previousDigit; i++) {
                result.append('(');
            }
            result.append(previousDigit);

            int currentDepth = previousDigit;

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                if (currentDigit > previousDigit) {
                    // Append opening brackets
                    for (int j = 0; j < currentDigit - currentDepth; j++) {
                        result.append('(');
                    }
                    currentDepth = currentDigit;
                } else if (currentDigit < previousDigit) {
                    // Append closing brackets
                    for (int j = 0; j < currentDepth - currentDigit; j++) {
                        result.append(')');
                    }
                    currentDepth = currentDigit;
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Append closing brackets for the remaining depth
            for (int i = 0; i < currentDepth; i++) {
                result.append(')');
            }

            System.out.println(result.toString());
        }
    }
}