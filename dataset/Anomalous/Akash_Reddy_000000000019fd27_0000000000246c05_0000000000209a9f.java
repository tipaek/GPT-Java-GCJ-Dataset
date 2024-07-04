import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = reader.readLine();
            int length = input.length();
            int[] digits = new int[length];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            for (int i = 0; i < length; i++) {
                int currentDigit = digits[i];
                if (i == 0) {
                    result.append("(".repeat(currentDigit)).append(currentDigit);
                } else {
                    int previousDigit = digits[i - 1];
                    if (currentDigit > previousDigit) {
                        result.append("(".repeat(currentDigit - previousDigit)).append(currentDigit);
                    } else if (currentDigit < previousDigit) {
                        result.append(")".repeat(previousDigit - currentDigit)).append(currentDigit);
                    } else {
                        result.append(currentDigit);
                    }
                }
            }

            result.append(")".repeat(digits[length - 1]));

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}