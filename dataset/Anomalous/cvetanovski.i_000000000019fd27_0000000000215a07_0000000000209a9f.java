import java.util.Scanner;

public class Solution {
    public static String generateParentheses(int count, char parenthesis) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(parenthesis);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentLevel = 0;

            for (char ch : inputString.toCharArray()) {
                int number = Character.getNumericValue(ch);
                if (currentLevel < number) {
                    output.append(generateParentheses(number - currentLevel, '('));
                    currentLevel = number;
                } else if (currentLevel > number) {
                    output.append(generateParentheses(currentLevel - number, ')'));
                    currentLevel = number;
                }
                output.append(number);
            }
            output.append(generateParentheses(currentLevel, ')'));
            results[i] = output.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}