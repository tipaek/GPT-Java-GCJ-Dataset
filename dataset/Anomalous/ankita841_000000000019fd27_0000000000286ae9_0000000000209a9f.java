import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            Stack<Character> stack = new Stack<>();

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                // Push opening parentheses
                for (int i = 0; i < digit; i++) {
                    stack.push('(');
                }

                // Push the digit itself
                stack.push(ch);

                // Push closing parentheses
                for (int i = 0; i < digit; i++) {
                    stack.push(')');
                }
            }

            // Process the stack to remove redundant pairs
            List<Character> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            // Remove adjacent pairs of parentheses
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i) == '(' && result.get(i + 1) == ')') {
                    result.remove(i + 1);
                    result.remove(i);
                    i -= 2; // Move back to recheck after removal
                }
            }

            // Build the final string
            StringBuilder finalString = new StringBuilder();
            for (int i = result.size() - 1; i >= 0; i--) {
                finalString.append(result.get(i));
            }

            // Print the result
            System.out.println(finalString.toString());
        }

        scanner.close();
    }
}