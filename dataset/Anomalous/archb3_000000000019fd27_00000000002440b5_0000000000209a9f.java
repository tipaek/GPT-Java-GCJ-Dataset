import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            String result = new Solution().generateBalancedParentheses(input);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }

    private String generateBalancedParentheses(String input) {
        StringBuilder output = new StringBuilder();
        int openBrackets = 0;
        int previousDigit = 0;

        for (char c : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(c);

            while (openBrackets < currentDigit) {
                output.append('(');
                openBrackets++;
            }

            while (openBrackets > currentDigit) {
                output.append(')');
                openBrackets--;
            }

            output.append(c);
            previousDigit = currentDigit;
        }

        while (openBrackets > 0) {
            output.append(')');
            openBrackets--;
        }

        return output.toString();
    }
}