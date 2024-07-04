import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int index = 0; index < inputString.length(); index++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(index));

                while (openParentheses < currentDigit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    result.append(')');
                    openParentheses--;
                }

                result.append(currentDigit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}