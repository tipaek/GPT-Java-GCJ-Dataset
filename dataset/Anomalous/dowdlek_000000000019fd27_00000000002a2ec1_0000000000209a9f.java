import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseIndex = 0; caseIndex < testCaseCount; caseIndex++) {
            resultBuilder.append("Case #").append(caseIndex + 1).append(": ");
            String inputLine = reader.readLine();
            char[] inputChars = inputLine.toCharArray();
            int[] digits = new int[inputChars.length];

            for (int i = 0; i < inputChars.length; i++) {
                digits[i] = Character.getNumericValue(inputChars[i]);
            }

            int openParentheses = 0;

            for (int digit : digits) {
                if (digit > openParentheses) {
                    resultBuilder.append(repeatCharacter(digit - openParentheses, '('));
                    openParentheses = digit;
                } else if (digit < openParentheses) {
                    resultBuilder.append(repeatCharacter(openParentheses - digit, ')'));
                    openParentheses = digit;
                }
                resultBuilder.append(digit);
            }
            resultBuilder.append(repeatCharacter(openParentheses, ')')).append('\n');
        }
        System.out.print(resultBuilder.toString());
    }

    private static String repeatCharacter(int count, char character) {
        StringBuilder repeatedChars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedChars.append(character);
        }
        return repeatedChars.toString();
    }
}