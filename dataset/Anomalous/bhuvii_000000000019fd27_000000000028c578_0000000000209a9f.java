import java.util.Scanner;

class Solution {

    private static void appendOpenParentheses(int count, StringBuilder builder) {
        for (int i = 0; i < count; i++) {
            builder.append('(');
        }
    }

    private static void appendClosedParentheses(int count, StringBuilder builder) {
        for (int i = 0; i < count; i++) {
            builder.append(')');
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int firstDigit = Character.getNumericValue(input.charAt(0));
            appendOpenParentheses(firstDigit, result);
            result.append(input.charAt(0));

            for (int i = 1; i < input.length(); i++) {
                int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (previousDigit > currentDigit) {
                    appendClosedParentheses(previousDigit - currentDigit, result);
                } else if (previousDigit < currentDigit) {
                    appendOpenParentheses(currentDigit - previousDigit, result);
                }

                result.append(input.charAt(i));
            }

            int lastDigit = Character.getNumericValue(input.charAt(input.length() - 1));
            appendClosedParentheses(lastDigit, result);

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        scanner.close();
    }
}