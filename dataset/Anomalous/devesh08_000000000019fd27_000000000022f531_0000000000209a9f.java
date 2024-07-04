import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            int length = inputString.length();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < length; i++) {
                int currentDigit = inputString.charAt(i) - '0';

                if (currentDigit > previousDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }

                result.append(inputString.charAt(i));
                previousDigit = currentDigit;
            }

            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}