import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String inputString = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int balance = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentValue = Character.getNumericValue(inputString.charAt(i));
                int openBracketsToAdd = currentValue - balance;

                if (openBracketsToAdd > 0) {
                    resultBuilder.append("(".repeat(openBracketsToAdd));
                } else if (openBracketsToAdd < 0) {
                    resultBuilder.append(")".repeat(-openBracketsToAdd));
                }

                balance = currentValue;
                resultBuilder.append(currentValue);
            }

            resultBuilder.append(")".repeat(balance));
            System.out.println("Case #" + caseIndex + ": " + resultBuilder.toString());
        }
    }
}