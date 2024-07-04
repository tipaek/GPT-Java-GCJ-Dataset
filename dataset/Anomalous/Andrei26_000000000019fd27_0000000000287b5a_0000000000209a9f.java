import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character after the integer input

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputString = scanner.nextLine();
            StringBuilder modifiedString = new StringBuilder();
            StringBuilder resultString = new StringBuilder();

            modifiedString.append("0").append(inputString).append("0");

            int inputIndex = 0;
            for (int i = 0; i < modifiedString.length() - 1 && inputIndex < inputString.length(); i++) {
                int currentDigit = Character.getNumericValue(modifiedString.charAt(i));
                int nextDigit = Character.getNumericValue(modifiedString.charAt(i + 1));
                int difference = currentDigit - nextDigit;

                if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        resultString.append("(");
                    }
                } else if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        resultString.append(")");
                    }
                }
                resultString.append(inputString.charAt(inputIndex));
                inputIndex++;
            }

            for (int i = 0; i < Character.getNumericValue(inputString.charAt(inputString.length() - 1)); i++) {
                resultString.append(")");
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + resultString.toString());
        }
    }
}