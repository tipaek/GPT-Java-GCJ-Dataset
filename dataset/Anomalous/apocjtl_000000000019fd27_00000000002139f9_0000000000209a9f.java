import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < testCases; i++) {
            String inputLine = scanner.nextLine();
            int[] digits = new int[inputLine.length()];

            for (int j = 0; j < inputLine.length(); j++) {
                digits[j] = Character.getNumericValue(inputLine.charAt(j));
            }

            StringBuilder result = new StringBuilder();

            if (digits[0] == 0) {
                result.append('0');
            } else {
                for (int j = 0; j < digits[0]; j++) {
                    result.append('(');
                }
                result.append(digits[0]);
            }

            for (int j = 1; j < digits.length; j++) {
                if (digits[j] == 0) {
                    for (int k = 0; k < digits[j - 1]; k++) {
                        result.append(')');
                    }
                    result.append('0');
                } else if (digits[j] > digits[j - 1]) {
                    for (int k = 0; k < digits[j] - digits[j - 1]; k++) {
                        result.append('(');
                    }
                    result.append(digits[j]);
                } else if (digits[j] < digits[j - 1]) {
                    for (int k = 0; k < digits[j - 1] - digits[j]; k++) {
                        result.append(')');
                    }
                    result.append(digits[j]);
                } else {
                    result.append(digits[j]);
                }
            }

            for (int j = 0; j < digits[digits.length - 1]; j++) {
                result.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}