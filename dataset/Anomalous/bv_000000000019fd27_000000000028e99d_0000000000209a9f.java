import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class ParenthesisValidator {
    public String validateParenthesis(String s) {
        StringBuilder builder = new StringBuilder(s);
        int i = 0;

        while (i < builder.length() - 1) {
            if (builder.charAt(i) == ')' && builder.charAt(i + 1) == '(') {
                builder.deleteCharAt(i + 1);
                builder.deleteCharAt(i);
                i--;
                continue;
            }
            i++;
        }
        return builder.toString();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        ParenthesisValidator validator = new ParenthesisValidator();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            StringBuilder inputBuilder = new StringBuilder();

            for (char c : inputLine.toCharArray()) {
                int digit = c - '0';
                inputBuilder.append("(".repeat(digit))
                            .append(digit)
                            .append(")".repeat(digit));
            }

            String validatedOutput = validator.validateParenthesis(inputBuilder.toString());
            System.out.println("Case #" + i + ": " + validatedOutput);
        }
    }
}