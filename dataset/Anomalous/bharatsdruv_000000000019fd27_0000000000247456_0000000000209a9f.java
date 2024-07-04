import java.util.Scanner;

class Solution {

    public static String generateParentheses(int count, char parenthesis) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(parenthesis);
        }
        return result.toString();
    }

    public static String addParentheses(int choice, int diff) {
        if (choice == 1) {
            return generateParentheses(diff, '(');
        } else {
            return generateParentheses(-diff, ')');
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int prev = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int diff = currentDigit - prev;

                if (diff > 0) {
                    result.append(addParentheses(1, diff));
                } else if (diff < 0) {
                    result.append(addParentheses(0, diff));
                }

                result.append(currentDigit);
                prev = currentDigit;
            }

            if (prev > 0) {
                result.append(generateParentheses(prev, ')'));
            }

            System.out.println("Case #" + tc + ": " + result.toString());
        }

        scanner.close();
    }
}