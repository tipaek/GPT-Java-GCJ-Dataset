import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            result.append("Case #").append(caseNumber).append(": ");

            char[] inputDigits = reader.readLine().toCharArray();
            int[] digits = new int[inputDigits.length];

            for (int i = 0; i < inputDigits.length; i++) {
                digits[i] = Character.getNumericValue(inputDigits[i]);
            }

            int openBrackets = 0;

            for (int digit : digits) {
                if (digit > openBrackets) {
                    result.append(repeatChar(digit - openBrackets, '('));
                    openBrackets = digit;
                } else if (digit < openBrackets) {
                    result.append(repeatChar(openBrackets - digit, ')'));
                    openBrackets = digit;
                }
                result.append(digit);
            }
            result.append(repeatChar(openBrackets, ')')).append('\n');
        }
        
        System.out.print(result.toString());
    }

    private static String repeatChar(int count, char character) {
        StringBuilder repeatedChars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedChars.append(character);
        }
        return repeatedChars.toString();
    }
}