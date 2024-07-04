import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int openBrackets = currentDigit - balance;

                for (int j = 0; j < openBrackets; j++) {
                    result.append("(");
                }

                int closeBrackets = balance - currentDigit;
                for (int j = 0; j < closeBrackets; j++) {
                    result.append(")");
                }

                balance = currentDigit;
                result.append(currentDigit);
            }

            for (int j = 0; j < balance; j++) {
                result.append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}