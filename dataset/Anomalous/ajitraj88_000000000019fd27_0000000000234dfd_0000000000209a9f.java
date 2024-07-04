import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        int caseNumber = 1;

        while (testCaseCount-- > 0) {
            String input = scanner.next();
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            int currentIndex = 0;

            while (currentIndex < input.length()) {
                int currentDigit = input.charAt(currentIndex) - '0';
                int stackSize = stack.size();
                int difference = currentDigit - stackSize;

                if (difference > 0) {
                    for (int i = 0; i < difference; i++) {
                        stack.push('(');
                        result.append('(');
                    }
                } else if (difference < 0) {
                    for (int i = 0; i < Math.abs(difference); i++) {
                        stack.pop();
                        result.append(')');
                    }
                }

                result.append(input.charAt(currentIndex));
                currentIndex++;
            }

            while (!stack.isEmpty()) {
                stack.pop();
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }
}