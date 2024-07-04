import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            String input = reader.readLine();
            StringBuilder modifiedString = new StringBuilder();

            // Add opening parentheses at the beginning
            int initialDigit = Character.getNumericValue(input.charAt(0));
            for (int count = 0; count < initialDigit; count++) {
                modifiedString.append('(');
            }
            modifiedString.append(input.charAt(0));

            for (int charIndex = 1; charIndex < input.length(); charIndex++) {
                int currentDigit = Character.getNumericValue(input.charAt(charIndex));
                int previousDigit = Character.getNumericValue(input.charAt(charIndex - 1));

                if (currentDigit > previousDigit) {
                    char[] openParentheses = new char[currentDigit - previousDigit];
                    Arrays.fill(openParentheses, '(');
                    modifiedString.append(openParentheses);
                } else if (currentDigit < previousDigit) {
                    char[] closeParentheses = new char[previousDigit - currentDigit];
                    Arrays.fill(closeParentheses, ')');
                    modifiedString.append(closeParentheses);
                }
                modifiedString.append(input.charAt(charIndex));
            }

            // Add closing parentheses at the end
            int finalDigit = Character.getNumericValue(input.charAt(input.length() - 1));
            for (int count = 0; count < finalDigit; count++) {
                modifiedString.append(')');
            }

            writer.write("Case #" + (caseIndex + 1) + ": " + modifiedString.toString() + "\n");
        }
        writer.flush();
    }
}