import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = reader.readLine();
            String result = generateParenthesizedString(inputString);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }

    private static String generateParenthesizedString(String input) {
        StringBuilder result = new StringBuilder();
        int previousValue = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentValue = Character.getNumericValue(input.charAt(i));
            adjustParentheses(result, previousValue, currentValue);
            result.append(currentValue);
            previousValue = currentValue;
        }
        adjustParentheses(result, previousValue, 0);

        return result.toString();
    }

    private static void adjustParentheses(StringBuilder result, int previousValue, int currentValue) {
        int difference = previousValue - currentValue;
        if (difference > 0) {
            appendCharacters(result, ')', difference);
        } else if (difference < 0) {
            appendCharacters(result, '(', -difference);
        }
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}