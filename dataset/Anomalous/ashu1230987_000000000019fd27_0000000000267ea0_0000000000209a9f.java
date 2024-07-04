import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            String input = scanner.next();
            Stack<String> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                queue.add(digit);
            }

            int currentDepth = 0;
            answer.append("Case #").append(caseNumber).append(":");

            while (!queue.isEmpty()) {
                int nextDigit = queue.remove();
                int stackSize = stack.size();

                if (stackSize < nextDigit) {
                    for (int i = 0; i < (nextDigit - stackSize); i++) {
                        answer.append("(");
                        stack.push("(");
                    }
                } else if (stackSize > nextDigit) {
                    for (int i = 0; i < (stackSize - nextDigit); i++) {
                        answer.append(")");
                        stack.pop();
                    }
                }

                answer.append(nextDigit);
                currentDepth = nextDigit;
            }

            for (int i = 0; i < currentDepth; i++) {
                answer.append(")");
            }

            answer.append("\n");
            testCases--;
            caseNumber++;
        }

        System.out.print(answer);
    }
}