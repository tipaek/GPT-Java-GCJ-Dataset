import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        int currentNumber = 0;
        int openBrackets = 0;

        int firstDigit = Character.getNumericValue(chars[0]);
        currentNumber = firstDigit;
        openBrackets = firstDigit;

        for (int i = 0; i < firstDigit; i++) {
            result.append('(');
        }
        result.append(firstDigit);

        for (int i = 1; i < chars.length; i++) {
            int digit = Character.getNumericValue(chars[i]);

            if (digit == currentNumber) {
                result.append(digit);
            } else if (digit > currentNumber) {
                int diff = digit - currentNumber;
                for (int j = 0; j < diff; j++) {
                    result.append('(');
                    openBrackets++;
                }
                result.append(digit);
            } else {
                int diff = currentNumber - digit;
                for (int j = 0; j < diff; j++) {
                    result.append(')');
                    openBrackets--;
                }
                result.append(digit);
            }

            currentNumber = digit;
        }

        while (openBrackets-- > 0) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}