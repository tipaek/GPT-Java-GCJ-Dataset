import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            char[] digits = reader.readLine().toCharArray();
            int previousDigit = 0;

            for (char digitChar : digits) {
                int currentDigit = digitChar - '0';
                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                result.append(digitChar);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(previousDigit)).append("\n");
        }

        System.out.print(result.toString());
    }
}