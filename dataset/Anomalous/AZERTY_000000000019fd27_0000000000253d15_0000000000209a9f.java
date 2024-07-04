import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int openBrackets = currentDigit - balance;

                for (int k = 0; k < openBrackets; k++) {
                    result.append("(");
                }

                int closeBrackets = balance - currentDigit;

                for (int k = 0; k < closeBrackets; k++) {
                    result.append(")");
                }

                balance += openBrackets;
                result.append(currentDigit);
            }

            for (int j = 0; j < balance; j++) {
                result.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}