import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void appendBrackets(StringBuilder strBuilder, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            strBuilder.append(bracket);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int length = input.length();
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 0; i < length; i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                if (stack.size() == 1 && currentDigit == 0) {
                    result.append(currentDigit);
                } else {
                    if (currentDigit > stack.peek()) {
                        appendBrackets(result, currentDigit - stack.peek(), '(');
                        result.append(currentDigit);
                        stack.push(currentDigit);
                    } else {
                        appendBrackets(result, stack.peek() - currentDigit, ')');
                        while (stack.peek() > currentDigit) {
                            stack.pop();
                        }
                        result.append(currentDigit);
                        stack.push(currentDigit);
                    }
                }
            }

            while (stack.size() > 1) {
                int top = stack.pop();
                int nextTop = stack.peek();
                appendBrackets(result, top - nextTop, ')');
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}