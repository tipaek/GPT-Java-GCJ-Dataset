import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Move to the next line after reading the number of cases

        for (int t = 1; t <= testCases; ++t) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int previousDigit = Character.getNumericValue(input.charAt(0));
            if (previousDigit > 0) {
                result.append("(".repeat(previousDigit));
            }

            int count = 1;

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (previousDigit == currentDigit) {
                    count++;
                } else {
                    result.append(String.valueOf(previousDigit).repeat(count));
                    count = 1;

                    if (previousDigit < currentDigit) {
                        result.append("(".repeat(currentDigit - previousDigit));
                    } else {
                        result.append(")".repeat(previousDigit - currentDigit));
                    }

                    previousDigit = currentDigit;
                }
            }

            result.append(String.valueOf(previousDigit).repeat(count));
            if (previousDigit > 0) {
                result.append(")".repeat(previousDigit));
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}