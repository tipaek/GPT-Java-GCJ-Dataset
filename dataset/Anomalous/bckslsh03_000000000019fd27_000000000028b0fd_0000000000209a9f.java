import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int previousDigit = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        result.append('(');
                        stack.push(')');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        result.append(stack.pop());
                    }
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}