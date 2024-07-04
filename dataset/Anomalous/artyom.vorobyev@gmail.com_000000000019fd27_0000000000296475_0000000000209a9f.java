import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            String inputString = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + convert(inputString));
        }
    }

    private static String convert(String input) {
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (char c : input.toCharArray()) {
            int digit = c - '0';
            if (currentLevel < digit) {
                addParentheses(result, '(', digit - currentLevel);
            } else {
                addParentheses(result, ')', currentLevel - digit);
            }
            result.append(c);
            currentLevel = digit;
        }
        addParentheses(result, ')', currentLevel);
        return result.toString();
    }

    private static void addParentheses(StringBuilder sb, char parenthesis, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(parenthesis);
        }
    }
}