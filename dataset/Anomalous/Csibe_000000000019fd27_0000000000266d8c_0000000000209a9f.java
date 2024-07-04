import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previousDigit = -1;

            for (char character : inputLine.toCharArray()) {
                int currentDigit = Character.getNumericValue(character);

                if (previousDigit < 0) {
                    appendParentheses(output, LEFT_PARENTHESIS, currentDigit);
                } else {
                    if (currentDigit > previousDigit) {
                        appendParentheses(output, LEFT_PARENTHESIS, currentDigit - previousDigit);
                    } else if (currentDigit < previousDigit) {
                        appendParentheses(output, RIGHT_PARENTHESIS, previousDigit - currentDigit);
                    }
                }

                output.append(currentDigit);
                previousDigit = currentDigit;
            }

            appendParentheses(output, RIGHT_PARENTHESIS, previousDigit);
            System.out.println("Case #" + caseNumber + ": " + output);
        }

        scanner.close();
    }

    private static void appendParentheses(StringBuilder stringBuilder, String parenthesis, int count) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(parenthesis);
        }
    }
}