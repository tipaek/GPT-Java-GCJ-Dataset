import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            results[i] = "";
        }

        for (int i = 0; i < testCaseCount; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            String[] digits = input.split("");
            int[] numbers = new int[digits.length];

            for (int j = 0; j < digits.length; j++) {
                numbers[j] = Integer.parseInt(digits[j]);
            }

            int currentNumber = numbers[0];
            appendParentheses(output, currentNumber, '(');
            output.append(currentNumber);

            for (int j = 1; j < numbers.length; j++) {
                int previousNumber = numbers[j - 1];
                currentNumber = numbers[j];

                if (currentNumber < previousNumber) {
                    appendParentheses(output, previousNumber - currentNumber, ')');
                } else if (currentNumber > previousNumber) {
                    appendParentheses(output, currentNumber - previousNumber, '(');
                }

                output.append(currentNumber);
            }

            appendParentheses(output, numbers[numbers.length - 1], ')');
            results[i] = output.toString();
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static void appendParentheses(StringBuilder output, int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            output.append(parenthesis);
        }
    }
}