import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            System.out.print("Case #" + i + ": ");
            processString(inputString);
        }
    }

    private static void processString(String inputString) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int currentDigit = inputString.charAt(i) - '0';

            while (openParentheses < currentDigit) {
                result.append('(');
                openParentheses++;
            }

            while (openParentheses > currentDigit) {
                result.append(')');
                openParentheses--;
            }

            result.append(inputString.charAt(i));
        }

        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }

        System.out.println(result.toString());
    }
}