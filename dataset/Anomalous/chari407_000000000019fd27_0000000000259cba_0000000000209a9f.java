import java.util.Scanner;

public class Solution {

    private static char getLeftParenthesis() {
        return '(';
    }

    private static char getRightParenthesis() {
        return ')';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentOpen = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                int difference = digit - currentOpen;

                if (difference > 0) {
                    result.append(String.valueOf(getLeftParenthesis()).repeat(difference));
                } else {
                    result.append(String.valueOf(getRightParenthesis()).repeat(-difference));
                }

                result.append(digit);
                currentOpen = digit;
            }

            result.append(String.valueOf(getRightParenthesis()).repeat(currentOpen));
            System.out.printf("Case #%d: %s\n", testCase, result.toString());
        }
    }
}