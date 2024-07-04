import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            String inputString = scanner.nextLine();
            int previousDigit = Character.getNumericValue(inputString.charAt(0));

            // Append opening parentheses for the first digit
            for (int i = 0; i < previousDigit; i++) {
                result.append('(');
            }
            result.append(previousDigit);

            for (int i = 1; i < inputString.length(); i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));

                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(')');
                    }
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Append closing parentheses for the last digit
            for (int i = 0; i < previousDigit; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}