import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            String inputString = scanner.next();
            System.out.printf("Case #%d: %s%n", i, generateNestedString(inputString));
        }
        scanner.close();
    }

    private static String generateNestedString(String input) {
        char[] characters = input.toCharArray();
        StringBuilder nestedString = new StringBuilder();
        int currentDepth = 0;

        for (char character : characters) {
            int digit = Character.getNumericValue(character);
            int depthDifference = Math.abs(digit - currentDepth);
            char bracket = digit >= currentDepth ? '(' : ')';

            for (int j = 0; j < depthDifference; j++) {
                nestedString.append(bracket);
            }

            nestedString.append(character);
            currentDepth = digit;
        }

        for (int j = 0; j < currentDepth; j++) {
            nestedString.append(')');
        }

        return nestedString.toString();
    }
}