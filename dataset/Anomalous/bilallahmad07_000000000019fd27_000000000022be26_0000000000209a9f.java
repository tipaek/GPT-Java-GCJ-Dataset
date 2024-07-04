import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));

            // Add opening parentheses for the first digit
            for (int i = 0; i < previousDigit; i++) {
                result.append('(');
            }
            result.append(input.charAt(0));

            // Process the rest of the digits
            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        result.append('(');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        result.append(')');
                    }
                }

                result.append(input.charAt(i));
                previousDigit = currentDigit;
            }

            // Add closing parentheses for the last digit
            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}