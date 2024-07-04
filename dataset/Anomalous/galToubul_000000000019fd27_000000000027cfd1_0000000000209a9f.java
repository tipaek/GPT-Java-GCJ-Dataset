import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        StringBuilder[] results = new StringBuilder[testCases];

        for (int t = 0; t < testCases; t++) {
            StringBuilder result = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            String input = scanner.next();
            int index = 0;

            while (index < input.length()) {
                while (index < input.length() && input.charAt(index) == '0') {
                    result.append('0');
                    index++;
                }

                if (index < input.length() && input.charAt(index) == '1') {
                    result.append('(').append('1');
                    stack.push(1);
                    index++;
                    if (index == input.length()) {
                        result.append(')');
                    }
                }

                while (index < input.length() && input.charAt(index) == '1') {
                    result.append('1');
                    index++;
                    if (index == input.length()) {
                        result.append(')');
                    }
                }

                if (index < input.length() && input.charAt(index) == '0') {
                    result.append(')').append('0');
                    stack.pop();
                    index++;
                }
            }
            results[t] = result;
        }

        scanner.close();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}