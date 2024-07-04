import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (currentDigit > openParentheses) {
                    appendCharacters(result, currentDigit - openParentheses, '(');
                    openParentheses = currentDigit;
                } else if (currentDigit < openParentheses) {
                    appendCharacters(result, openParentheses - currentDigit, ')');
                    openParentheses = currentDigit;
                }

                result.append(input.charAt(i));
            }

            appendCharacters(result, openParentheses, ')');
            System.out.printf("Case #%d: %s%n", testCase, result.toString());
        }

        scanner.close();
    }

    private static void appendCharacters(StringBuilder builder, int count, char character) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}