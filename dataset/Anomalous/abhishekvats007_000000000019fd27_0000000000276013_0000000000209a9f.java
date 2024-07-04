import java.util.Scanner;

public class Solution {

    public static void addBrackets(StringBuilder strBuilder, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            strBuilder.append(bracket);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();
        scanner.nextLine();

        for (byte i = 0; i < totalTestCases; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = input.charAt(j) - '0';

                addBrackets(output, currentDigit - openBrackets, '(');
                output.append(input.charAt(j));

                int closeBrackets;
                if (j + 1 >= input.length()) {
                    closeBrackets = currentDigit;
                } else {
                    int nextDigit = input.charAt(j + 1) - '0';
                    closeBrackets = Math.max(0, currentDigit - nextDigit);
                }

                openBrackets = currentDigit - closeBrackets;
                addBrackets(output, closeBrackets, ')');
            }

            System.out.printf("Case #%d: %s%n", i + 1, output);
        }
    }
}