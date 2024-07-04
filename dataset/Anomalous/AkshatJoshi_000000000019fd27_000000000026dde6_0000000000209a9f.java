import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        System.out.println("Inputs:");

        for (int i = 0; i < T; i++) {
            String expression = scanner.next();
            System.out.println("Case #" + (i + 1) + ": " + processExpression(expression));
        }
    }

    private static String processExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        int top = -1;
        int currentMax = 0;
        boolean open = true;

        for (int j = 0; j < expression.length(); j++) {
            char currentChar = expression.charAt(j);
            int currentInt = Character.getNumericValue(currentChar);
            System.out.println(currentInt);

            if (!open) { // Closing brackets
                if (currentInt == currentMax) {
                    result.add(currentChar);
                } else if (currentInt < currentMax) {
                    while (top > (currentInt - 1)) {
                        stack.pop();
                        top--;
                        result.add(')');
                    }
                    result.add(currentChar);
                    if (top == -1) {
                        open = true;
                        continue;
                    }
                } else { // currentInt > currentMax
                    while (top != -1) {
                        stack.pop();
                        top--;
                        result.add(')');
                    }
                    open = true;
                }
            }

            if (open) { // Opening brackets
                currentMax = currentInt;
                for (int temp = 0; temp < currentInt; temp++) {
                    stack.push('(');
                    top++;
                    result.add('(');
                }
                result.add(currentChar);
                open = false;
            }
        }

        // Empty remaining stack
        while (top != -1) {
            stack.pop();
            top--;
            result.add(')');
        }

        return getStringRepresentation(result);
    }

    private static String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
}