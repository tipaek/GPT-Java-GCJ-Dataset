import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int balance = 0;
            int previousDigit = 0;

            for (int j = 0; j < inputString.length(); j++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(j));
                if (j == 0) {
                    result.append("(".repeat(currentDigit));
                    balance = currentDigit;
                } else {
                    if (currentDigit > previousDigit) {
                        result.append("(".repeat(currentDigit - previousDigit));
                    } else if (currentDigit < previousDigit) {
                        result.append(")".repeat(previousDigit - currentDigit));
                    }
                    balance += (currentDigit - previousDigit);
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(balance));
            System.out.println("Case #" + i + ": " + result);
        }
    }
}