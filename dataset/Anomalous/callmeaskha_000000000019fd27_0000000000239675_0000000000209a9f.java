import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String[] digits = reader.readLine().split("");
            int currentLevel = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < digits.length; j++) {
                int currentDigit = Integer.parseInt(digits[j]);
                int nextDigit = (j + 1 < digits.length) ? Integer.parseInt(digits[j + 1]) : 0;

                if (currentDigit > currentLevel) {
                    result.append("(".repeat(currentDigit - currentLevel));
                    currentLevel = currentDigit;
                } else if (currentDigit < currentLevel) {
                    result.append(")".repeat(currentLevel - currentDigit));
                    currentLevel = currentDigit;
                }
                result.append(currentDigit);
            }

            result.append(")".repeat(currentLevel));
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}