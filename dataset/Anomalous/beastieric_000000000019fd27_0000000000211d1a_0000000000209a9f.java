import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                String input = scanner.next();
                System.out.println(processString(input));
            }
        }
    }

    private static String processString(String input) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            while (openParentheses < currentDigit) {
                result.append('(');
                openParentheses++;
            }
            while (openParentheses > currentDigit) {
                result.append(')');
                openParentheses--;
            }

            result.append(currentDigit);
        }

        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }

        return result.toString();
    }
}