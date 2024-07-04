import java.util.*;
import java.io.*;

class Solution {
    public static final char LP = '(';
    public static final char RP = ')';

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTestCount = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= totalTestCount; i++) {
            String inputString = in.nextLine();
            nestingDepth(i, inputString);
        }
    }

    public static void nestingDepth(int testNumber, String inputString) {

        Deque<String> deque = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            Integer digit = inputString.charAt(i) - '0';

            if (stack.isEmpty()) {
                deque.add(getBeginningParenthesis(0, digit));
                deque.add(digit.toString());
                stack.push(digit);
            } else if (stack.peek().intValue() < digit.intValue()) {
                deque.add(getBeginningParenthesis(stack.peek(), digit));
                deque.add(digit.toString());
                stack.push(digit);
            } else if (stack.peek().equals(digit)) {
                deque.add(digit.toString());
            } else {
                deque.add(getEndingParenthesis(stack.pop(), digit));
                deque.add(digit.toString());
                stack.push(digit);
            }

        }
        deque.add(getEndingParenthesis(stack.pop(), 0));

        System.out.println("Case #" + testNumber + ": " + dequeToString(deque));
    }

    public static String dequeToString(Deque<String> deque) {
        StringBuffer buffer = new StringBuffer();
        deque.forEach(item -> {
            buffer.append(item);
        });
        return buffer.toString();
    }

    public static String getEndingParenthesis(int previousDigit, int digit) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < previousDigit - digit; i++) {
            buffer.append(RP);
        }
        return buffer.toString();
    }

    public static String getBeginningParenthesis(Integer previousDigit, Integer digit) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < digit - previousDigit; i++) {
            buffer.append(LP);
        }
        return buffer.toString();
    }
}