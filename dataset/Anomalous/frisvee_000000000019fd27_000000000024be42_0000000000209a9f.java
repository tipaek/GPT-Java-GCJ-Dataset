import java.util.*;
import java.io.*;

public class Solution {
    private static String solve(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : input.toCharArray()) {
            int value = digit - '0';

            for (int i = 0; i < value; i++) {
                if (!stack.isEmpty() && stack.peekLast() == ')') {
                    stack.removeLast();
                } else {
                    stack.addLast('(');
                }
            }
            stack.addLast(digit);
            for (int i = 0; i < value; i++) {
                stack.addLast(')');
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + caseNumber + ": " + solve(input));
        }

        scanner.close();
    }
}