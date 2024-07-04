import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            int lastDigit = Character.getNumericValue(input.charAt(input.length() - 1));

            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                stack.push(currentChar);
                int currentDigit = Character.getNumericValue(currentChar);

                if (j == 0) {
                    for (int k = 0; k < currentDigit; k++) {
                        output.append("(");
                    }
                    output.append(stack.pop());
                } else {
                    int previousDigit = Character.getNumericValue(input.charAt(j - 1));

                    if (previousDigit > currentDigit) {
                        for (int k = 0; k < previousDigit - currentDigit; k++) {
                            output.append(")");
                        }
                    } else {
                        for (int k = 0; k < currentDigit - previousDigit; k++) {
                            output.append("(");
                        }
                    }
                    output.append(stack.pop());
                }
            }

            for (int j = 0; j < lastDigit; j++) {
                output.append(")");
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}