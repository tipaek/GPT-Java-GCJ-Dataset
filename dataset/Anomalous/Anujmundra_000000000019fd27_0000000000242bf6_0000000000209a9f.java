import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next() + "0";
            StringBuilder result = new StringBuilder();

            int firstDigit = Character.getNumericValue(input.charAt(0));
            appendParentheses(result, firstDigit, true);

            for (int j = 0; j < input.length() - 1; j++) {
                result.append(input.charAt(j));

                int currentDigit = Character.getNumericValue(input.charAt(j));
                int nextDigit = Character.getNumericValue(input.charAt(j + 1));
                int difference = nextDigit - currentDigit;

                appendParentheses(result, Math.abs(difference), difference >= 0);
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static void appendParentheses(StringBuilder sb, int count, boolean open) {
        char parenthesis = open ? '(' : ')';
        for (int k = 0; k < count; k++) {
            sb.append(parenthesis);
        }
    }
}