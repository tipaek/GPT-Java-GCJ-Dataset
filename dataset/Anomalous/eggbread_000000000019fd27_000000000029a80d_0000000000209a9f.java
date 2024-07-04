import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 1; i <= T; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int previousDigit = j == 0 ? 0 : Character.getNumericValue(input.charAt(j - 1));

                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        result.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        result.append(')');
                    }
                }
                result.append(currentDigit);
            }

            int lastDigit = Character.getNumericValue(input.charAt(input.length() - 1));
            for (int j = 0; j < lastDigit; j++) {
                result.append(')');
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}