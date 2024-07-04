import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int previousValue = Character.getNumericValue(input.charAt(0));
            result.append(repeatParentheses(previousValue));
            result.append(input.charAt(0));

            for (int j = 0; j < input.length() - 1; j++) {
                int currentValue = Character.getNumericValue(input.charAt(j));
                int nextValue = Character.getNumericValue(input.charAt(j + 1));
                int difference = nextValue - currentValue;
                result.append(repeatParentheses(difference));
                result.append(input.charAt(j + 1));
            }

            int lastValue = Character.getNumericValue(input.charAt(input.length() - 1));
            result.append(repeatParentheses(-lastValue));

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }

    private static String repeatParentheses(int count) {
        StringBuilder parentheses = new StringBuilder();
        String paren = count > 0 ? "(" : ")";
        for (int i = 0; i < Math.abs(count); i++) {
            parentheses.append(paren);
        }
        return parentheses.toString();
    }
}