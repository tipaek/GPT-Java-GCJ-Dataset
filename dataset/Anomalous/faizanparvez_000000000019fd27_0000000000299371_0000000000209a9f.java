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
        scanner.close();
    }

    static void solve(String input) {
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (char c : characters) {
            int currentNumber = Character.getNumericValue(c);
            if (stack.isEmpty()) {
                for (int i = 0; i < currentNumber; i++) {
                    result.append('(');
                }
            } else {
                int previousNumber = stack.peek();
                int difference = previousNumber - currentNumber;
                if (difference > 0) {
                    for (int i = 0; i < difference; i++) {
                        result.append(')');
                    }
                } else if (difference < 0) {
                    for (int i = 0; i < -difference; i++) {
                        result.append('(');
                    }
                }
            }
            result.append(currentNumber);
            stack.push(currentNumber);
        }

        if (!stack.isEmpty()) {
            int lastNumber = stack.pop();
            for (int i = 0; i < lastNumber; i++) {
                result.append(')');
            }
        }

        System.out.println(result.toString());
    }
}