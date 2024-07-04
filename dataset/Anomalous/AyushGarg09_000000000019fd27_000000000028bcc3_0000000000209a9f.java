import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static String create(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int prev = -1;
        for (char c : s.toCharArray()) {
            int a = Character.getNumericValue(c);

            if (a != 0) {
                if (prev <= 0) {
                    for (int i = 0; i < a; i++) {
                        stack.push(')');
                        result.append('(');
                    }
                    result.append(a);
                } else {
                    if (a < prev) {
                        int n = prev - a;
                        for (int i = 0; i < n; i++) {
                            result.append(stack.pop());
                        }
                    } else if (a > prev) {
                        int n = a - prev;
                        for (int i = 0; i < n; i++) {
                            result.append('(');
                            stack.push(')');
                        }
                    }
                    result.append(a);
                }
            } else {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(a);
            }
            prev = a;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            String input = scanner.next();
            String result = create(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}