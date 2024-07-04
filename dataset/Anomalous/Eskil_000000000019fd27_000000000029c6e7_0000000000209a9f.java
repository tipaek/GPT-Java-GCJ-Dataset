import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String inputNumber = reader.readLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char digitChar : inputNumber.toCharArray()) {
                int currentDigit = digitChar - '0';
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(previousDigit));
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}