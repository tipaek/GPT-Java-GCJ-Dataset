import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static String solve(String expr) {
        Deque<Character> stack = new LinkedList<>();
        int openParentheses = 0;

        for (int i = 0; i < expr.length(); i++) {
            int currentNumber = expr.charAt(i) - '0';

            if (openParentheses == 0) {
                for (int j = 0; j < currentNumber; j++) {
                    stack.add('(');
                    openParentheses++;
                }
                stack.add(expr.charAt(i));
            } else {
                if (currentNumber == 0) {
                    while (openParentheses > 0) {
                        stack.add(')');
                        openParentheses--;
                    }
                    stack.add('0');
                } else {
                    int lastNumber = stack.peekLast() - '0';
                    if (lastNumber >= 0 && lastNumber <= 9) {
                        if (lastNumber > currentNumber) {
                            for (int j = 0; j < lastNumber - currentNumber; j++) {
                                stack.add(')');
                                openParentheses--;
                            }
                            stack.add(expr.charAt(i));
                        } else if (lastNumber == currentNumber) {
                            stack.add(expr.charAt(i));
                        } else {
                            while (openParentheses > 0) {
                                stack.add(')');
                                openParentheses--;
                            }
                            for (int j = 0; j < currentNumber; j++) {
                                stack.add('(');
                                openParentheses++;
                            }
                            stack.add(expr.charAt(i));
                        }
                    } else {
                        for (int j = 0; j < currentNumber; j++) {
                            stack.add('(');
                            openParentheses++;
                        }
                        stack.add(expr.charAt(i));
                    }
                }
            }
        }

        while (openParentheses > 0) {
            stack.add(')');
            openParentheses--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeFirst());
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            String expression = reader.readLine();
            System.out.println("Case #" + i + ": " + solve(expression));
        }
    }
}