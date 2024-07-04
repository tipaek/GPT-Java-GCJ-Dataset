import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= testCount; test++) {
            String input = scanner.nextLine();
            String result = addParentheses(input);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String addParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;
        int closeParentheses = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            int balance = currentDigit - (openParentheses - closeParentheses);

            while (balance < 0) {
                result.append(')');
                closeParentheses++;
                balance++;
            }

            while (balance > 0) {
                result.append('(');
                openParentheses++;
                balance--;
            }

            result.append(input.charAt(i));
        }

        while (closeParentheses < openParentheses) {
            result.append(')');
            closeParentheses++;
        }

        return result.toString();
    }
}