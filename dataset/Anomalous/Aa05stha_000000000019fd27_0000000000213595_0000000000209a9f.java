import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            Stack<Character> tempStack = new Stack<>();
            int openBracketsNeeded = 0, remainingBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '0') {
                    stack.push(currentChar);
                } else {
                    if (!stack.isEmpty() && stack.peek() == ')') {
                        int count = 0;
                        while (!stack.isEmpty() && stack.peek() == ')' && count < (currentChar - '0')) {
                            tempStack.push(stack.pop());
                            count++;
                        }

                        if (count == currentChar - '0') {
                            stack.push(currentChar);
                            while (!tempStack.isEmpty()) {
                                stack.push(tempStack.pop());
                            }
                        } else {
                            openBracketsNeeded = currentChar - '0' - count;
                            remainingBrackets = openBracketsNeeded;
                            while (openBracketsNeeded > 0) {
                                stack.push('(');
                                openBracketsNeeded--;
                            }
                            stack.push(currentChar);
                            while (remainingBrackets > 0) {
                                stack.push(')');
                                remainingBrackets--;
                            }
                            while (!tempStack.isEmpty()) {
                                stack.push(tempStack.pop());
                            }
                        }
                    } else {
                        openBracketsNeeded = currentChar - '0';
                        remainingBrackets = openBracketsNeeded;
                        while (openBracketsNeeded > 0) {
                            stack.push('(');
                            openBracketsNeeded--;
                        }
                        stack.push(currentChar);
                        while (remainingBrackets > 0) {
                            stack.push(')');
                            remainingBrackets--;
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            result.reverse();

            System.out.println("Case #" + t + ": " + result);
        }
    }
}