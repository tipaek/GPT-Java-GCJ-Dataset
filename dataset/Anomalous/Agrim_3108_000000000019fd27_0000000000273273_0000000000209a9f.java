import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int firstDigit = input.charAt(0) - '0';

            // Add opening brackets for the first digit
            for (int j = 0; j < firstDigit; j++) {
                result.append("(");
            }
            result.append(input.charAt(0));

            for (int j = 1; j < input.length(); j++) {
                int currentDigit = input.charAt(j) - '0';
                int previousDigit = input.charAt(j - 1) - '0';

                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(")");
                    }
                }
                result.append(input.charAt(j));
            }

            // Close any remaining open brackets
            int openBrackets = firstDigit;
            for (int j = 1; j < input.length(); j++) {
                if (input.charAt(j) - '0' > input.charAt(j - 1) - '0') {
                    openBrackets += (input.charAt(j) - '0') - (input.charAt(j - 1) - '0');
                } else if (input.charAt(j) - '0' < input.charAt(j - 1) - '0') {
                    openBrackets -= (input.charAt(j - 1) - '0') - (input.charAt(j) - '0');
                }
            }
            for (int j = 0; j < openBrackets; j++) {
                result.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}