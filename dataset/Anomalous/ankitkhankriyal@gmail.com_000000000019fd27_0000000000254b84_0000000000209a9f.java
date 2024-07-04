import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void addBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int length = input.length();
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 0; i < length; i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));

                if (stack.size() == 1 && currentDigit == 0) {
                    output.append(currentDigit);
                } else {
                    int top = stack.peek();
                    if (currentDigit > top) {
                        addBrackets(output, currentDigit - top, '(');
                        output.append(currentDigit);
                        stack.push(currentDigit);
                    } else {
                        addBrackets(output, top - currentDigit, ')');
                        stack.pop();
                        output.append(currentDigit);
                        stack.push(currentDigit);
                    }
                }
            }

            while (stack.size() > 1) {
                int top = stack.pop();
                int nextTop = stack.peek();
                addBrackets(output, top - nextTop, ')');
            }

            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }
    }
}