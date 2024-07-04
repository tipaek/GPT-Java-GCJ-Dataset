import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.nextLine().trim();
            Digit[] digits = new Digit[input.length()];
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                digits[i] = new Digit(Character.getNumericValue(input.charAt(i)));
                if (currentDepth > digits[i].needs) {
                    digits[i - 1].after = currentDepth - digits[i].needs;
                } else if (currentDepth < digits[i].needs) {
                    digits[i].before = digits[i].needs - currentDepth;
                }
                currentDepth = digits[i].needs;
            }

            digits[digits.length - 1].after = currentDepth;

            StringBuilder result = new StringBuilder();
            for (Digit digit : digits) {
                for (int j = 0; j < digit.before; j++) {
                    result.append('(');
                }
                result.append(digit.needs);
                for (int j = 0; j < digit.after; j++) {
                    result.append(')');
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }

        scanner.close();
    }

    private static class Digit {
        private int before;
        private int after;
        private int needs;

        public Digit(int value) {
            this.before = 0;
            this.after = 0;
            this.needs = value;
        }
    }
}