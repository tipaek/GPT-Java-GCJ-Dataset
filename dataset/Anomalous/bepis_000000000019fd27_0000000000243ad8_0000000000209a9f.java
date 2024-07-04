import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = testCases;

        while (testCases-- > 0) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();

            int currentDigit = Character.getNumericValue(input.charAt(0));
            appendCharacters(result, '(', currentDigit);
            result.append(input.charAt(0));

            for (int i = 1; i < input.length(); i++) {
                int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                int nextDigit = Character.getNumericValue(input.charAt(i));

                if (previousDigit < nextDigit) {
                    appendCharacters(result, '(', nextDigit - previousDigit);
                } else if (previousDigit > nextDigit) {
                    appendCharacters(result, ')', previousDigit - nextDigit);
                }
                result.append(input.charAt(i));
            }

            appendCharacters(result, ')', currentDigit);
            output.append("Case #").append(caseNumber - testCases).append(": ").append(result).append("\n");
        }

        System.out.print(output);
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}