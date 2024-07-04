import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
                String input = reader.readLine();
                StringBuilder result = new StringBuilder();
                int previousDigit = 0;

                for (char ch : input.toCharArray()) {
                    int currentDigit = ch - '0';
                    if (previousDigit < currentDigit) {
                        result.append("(".repeat(currentDigit - previousDigit));
                    } else if (previousDigit > currentDigit) {
                        result.append(")".repeat(previousDigit - currentDigit));
                    }
                    result.append(currentDigit);
                    previousDigit = currentDigit;
                }

                result.append(")".repeat(previousDigit));
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }
}