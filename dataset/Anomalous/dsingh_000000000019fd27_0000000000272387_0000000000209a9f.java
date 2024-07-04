import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = -1;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (previousDigit != -1) {
                    if (previousDigit > currentDigit) {
                        result.append(")".repeat(previousDigit - currentDigit));
                    } else if (previousDigit < currentDigit) {
                        result.append(")".repeat(previousDigit));
                        result.append("(".repeat(currentDigit));
                    }
                } else {
                    result.append("(".repeat(currentDigit));
                }

                result.append(currentDigit);
                previousDigit = currentDigit;

                if (i == input.length() - 1) {
                    result.append(")".repeat(currentDigit));
                }
            }
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}