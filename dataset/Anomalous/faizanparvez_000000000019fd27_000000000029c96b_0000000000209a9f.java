import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            String input = scanner.next();
            solve(input);
        }
    }

    static void solve(String input) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char[] characters = input.toCharArray();

        for (char character : characters) {
            int currentNum = Character.getNumericValue(character);
            if (stack.isEmpty()) {
                appendCharacters(result, '(', currentNum);
            } else {
                int previousNum = stack.peek();
                int diff = previousNum - currentNum;
                if (diff > 0) {
                    appendCharacters(result, ')', diff);
                } else if (diff < 0) {
                    appendCharacters(result, '(', -diff);
                }
            }
            result.append(currentNum);
            stack.push(currentNum);
        }

        if (!stack.isEmpty()) {
            int remaining = stack.pop();
            appendCharacters(result, ')', remaining);
        }

        System.out.print(result.toString());
    }

    static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}