import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int testCaseNumber = 1; testCaseNumber <= testCaseCount; testCaseNumber++) {
            String inputNumber = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            char[] digits = inputNumber.toCharArray();
            int currentNumber = Character.getNumericValue(digits[0]);
            int openBrackets = currentNumber;

            // Append opening brackets for the first digit
            for (int i = 0; i < currentNumber; i++) {
                result.append('(');
            }
            result.append(currentNumber);

            // Process the rest of the digits
            for (int i = 1; i < digits.length; i++) {
                int nextNumber = Character.getNumericValue(digits[i]);

                if (nextNumber > currentNumber) {
                    for (int j = 0; j < (nextNumber - currentNumber); j++) {
                        result.append('(');
                    }
                } else if (nextNumber < currentNumber) {
                    for (int j = 0; j < (currentNumber - nextNumber); j++) {
                        result.append(')');
                    }
                }

                result.append(nextNumber);
                currentNumber = nextNumber;
            }

            // Append closing brackets for the last digit
            for (int i = 0; i < openBrackets; i++) {
                result.append(')');
            }

            System.out.println("Case #" + testCaseNumber + ": " + result.toString());
        }
    }
}