import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int firstDigit = Character.getNumericValue(input.charAt(0));
            int lastDigit = Character.getNumericValue(input.charAt(input.length() - 1));

            for (int k = 0; k < firstDigit; k++) {
                result.append("(");
            }
            result.append(input.charAt(0));

            for (int j = 0; j < input.length() - 1; j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int nextDigit = Character.getNumericValue(input.charAt(j + 1));

                if (currentDigit > nextDigit) {
                    for (int k = 0; k < currentDigit - nextDigit; k++) {
                        result.append(")");
                    }
                } else if (currentDigit < nextDigit) {
                    for (int k = 0; k < nextDigit - currentDigit; k++) {
                        result.append("(");
                    }
                }
                result.append(input.charAt(j + 1));
            }

            for (int k = 0; k < lastDigit; k++) {
                result.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}