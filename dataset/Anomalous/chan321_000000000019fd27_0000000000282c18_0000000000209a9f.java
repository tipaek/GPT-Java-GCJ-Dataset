import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = reader.readLine().trim();
            processTestCase(inputString, caseNumber);
        }
    }

    public static void processTestCase(String input, int caseNumber) {
        int length = input.length();

        for (int digit = 0; digit < 9; digit++) {
            Deque<Integer> stack = new LinkedList<>();

            for (int index = 0; index < length; index++) {
                char currentChar = input.charAt(index);

                if (currentChar == '(' || currentChar == ')') {
                    continue;
                }

                if (stack.size() % 2 == 0) {
                    stack.push(index);
                }

                if (currentChar <= (char) (digit + '0')) {
                    if (stack.peek() == index) {
                        stack.pop();
                    } else {
                        stack.push(index);
                    }
                }
            }

            if (stack.size() % 2 != 0) {
                stack.push(length);
            }

            if (!stack.isEmpty()) {
                input = insertBrackets(input, stack);
            }
        }

        System.out.println();
        System.out.format("Case %d: %s", caseNumber, input);
    }

    public static String insertBrackets(String input, Deque<Integer> stack) {
        StringBuilder result = new StringBuilder(input);

        for (int i = 0; i < stack.size(); i++) {
            if (i % 2 == 0) {
                result.insert(stack.pollLast(), ")");
            } else {
                result.insert(stack.pollLast(), "(");
            }
        }

        return result.toString();
    }
}