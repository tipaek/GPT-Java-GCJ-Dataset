import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + formatString(input));
        }
    }

    private static String formatString(String input) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char digitChar : input.toCharArray()) {
            int digit = digitChar - '0';

            while (openBrackets < digit) {
                result.append('(');
                openBrackets++;
            }
            while (openBrackets > digit) {
                result.append(')');
                openBrackets--;
            }
            result.append(digitChar);
        }

        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }

        return result.toString();
    }
}