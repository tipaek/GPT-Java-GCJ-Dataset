import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.next());
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            String result = addParentheses(input);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String addParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (openParentheses < digit) {
                result.append('(');
                openParentheses++;
            }

            while (openParentheses > digit) {
                result.append(')');
                openParentheses--;
            }

            result.append(ch);
        }

        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }

        return result.toString();
    }
}