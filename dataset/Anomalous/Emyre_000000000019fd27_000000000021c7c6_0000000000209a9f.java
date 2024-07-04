import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String S = br.readLine();
            StringBuilder result = new StringBuilder();

            int previousDigit = 0;
            for (int i = 0; i < S.length(); i++) {
                int currentDigit = Character.getNumericValue(S.charAt(i));

                // Add opening parentheses if needed
                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append("(");
                    }
                }

                // Add closing parentheses if needed
                if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(")");
                    }
                }

                // Append the current digit
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Close any remaining open parentheses
            for (int j = 0; j < previousDigit; j++) {
                result.append(")");
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}