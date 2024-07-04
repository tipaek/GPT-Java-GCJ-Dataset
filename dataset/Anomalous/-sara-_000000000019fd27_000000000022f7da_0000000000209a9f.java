import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Move to the next line to read input strings

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder solution = new StringBuilder();
            int[] digits = input.chars().map(Character::getNumericValue).toArray();

            if (digits[0] == 0) {
                solution.append("0");
            } else {
                solution.append("(1");
            }

            for (int j = 1; j < digits.length; j++) {
                if (digits[j] == digits[j - 1]) {
                    solution.append(digits[j]);
                } else if (digits[j] == 0) {
                    solution.append(")0");
                } else {
                    solution.append("(1");
                }
            }

            if (digits[digits.length - 1] == 1) {
                solution.append(")");
            }

            System.out.println("Case #" + i + ": " + solution);
        }

        scanner.close();
    }
}