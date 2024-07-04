import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + processString());
        }
    }

    private static String processString() {
        String input = scanner.next();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int length = input.length();
        Stack<Integer> balanceStack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int digit = characters[i] - '0';

            if (i == 0) {
                balanceStack.push(digit);
                for (int j = 0; j < digit; j++) {
                    result.append('(');
                }
            } else {
                int previousDigit = balanceStack.peek();
                int difference = digit - previousDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        result.append('(');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        result.append(')');
                    }
                }
                balanceStack.pop();
                balanceStack.push(digit);
            }
            result.append(characters[i]);
        }

        while (!balanceStack.isEmpty() && balanceStack.peek() > 0) {
            result.append(')');
            balanceStack.pop();
        }

        return result.toString();
    }
}