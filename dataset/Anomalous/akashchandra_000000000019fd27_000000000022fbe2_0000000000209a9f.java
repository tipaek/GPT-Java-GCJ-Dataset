import java.util.Scanner;

class Solution {

    public static String appendClosingBrackets(String str, int count) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.append(")");
        }
        return sb.toString();
    }

    public static String appendOpeningBrackets(String str, int count) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.append("(");
        }
        return sb.toString();
    }

    public static String processString(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();
        int[] digits = new int[length];

        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }

        result.append(appendOpeningBrackets("", digits[0])).append(digits[0]);

        for (int i = 1; i < length; i++) {
            if (digits[i] > digits[i - 1]) {
                result.append(appendOpeningBrackets("", digits[i] - digits[i - 1])).append(digits[i]);
            } else if (digits[i] < digits[i - 1]) {
                result.append(appendClosingBrackets("", digits[i - 1] - digits[i])).append(digits[i]);
            } else {
                result.append(digits[i]);
            }
        }

        result.append(appendClosingBrackets("", digits[length - 1]));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String output = processString(input);
            System.out.println("Case #" + i + ": " + output);
        }
        scanner.close();
    }
}