import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            char[] characters = input.toCharArray();
            int openParenthesesCount = 0;

            for (char character : characters) {
                int currentNumber = Character.getNumericValue(character);

                if (openParenthesesCount < currentNumber) {
                    for (int i = openParenthesesCount; i < currentNumber; i++) {
                        result.append("(");
                    }
                } else if (openParenthesesCount > currentNumber) {
                    for (int i = openParenthesesCount; i > currentNumber; i--) {
                        result.append(")");
                    }
                }

                openParenthesesCount = currentNumber;
                result.append(character);
            }

            for (int i = 0; i < openParenthesesCount; i++) {
                result.append(")");
            }

            results[testCaseIndex] = "Case #" + (testCaseIndex + 1) + ": " + result.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}