import java.util.Scanner;

class Solution {

    static String makeParens(int count, String segment) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            result.append("(");
        }
        result.append(segment);
        for (int i = 0; i < count; ++i) {
            result.append(")");
        }
        return result.toString();
    }

    static String solve(String input) {
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < input.length()) {
            char currentChar = input.charAt(index);
            StringBuilder segment = new StringBuilder();
            while (index < input.length() && input.charAt(index) == currentChar) {
                segment.append(currentChar);
                index++;
            }
            int digit = Character.getNumericValue(currentChar);
            result.append(makeParens(digit, segment.toString()));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}