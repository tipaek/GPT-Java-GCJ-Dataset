import java.util.Scanner;
import java.util.Arrays;

class Solution {

    public static void processCase(int caseNumber, String input) {
        input = "0" + input + "0";
        int length = input.length();
        int[] digits = new int[length];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }

        for (int i = 1; i < length - 1; i++) {
            int openBrackets = digits[i] - digits[i - 1];
            int closeBrackets = digits[i] - digits[i + 1];

            while (openBrackets > 0) {
                result.append('(');
                openBrackets--;
            }

            result.append(digits[i]);

            while (closeBrackets > 0) {
                result.append(')');
                closeBrackets--;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();

        for (int i = 1; i <= totalCases; i++) {
            String input = scanner.next();
            processCase(i, input);
        }

        scanner.close();
    }
}