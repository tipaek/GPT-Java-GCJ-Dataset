import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            Stack<Character> stack = new Stack<Character>();
            for (char c : s.toCharArray()) {
                int in = Integer.parseInt(String.valueOf(c));
                for (int j = 0; j < in; j++) {
                    if (!stack.empty()) {
                        if (stack.peek().charValue() == ')') {
                            stack.pop();
                        } else {
                            stack.push('(');
                        }

                    } else {
                        stack.push('(');
                    }
                }
                stack.push(c);
                for (int j = 0; j < in; j++) {
                    stack.push(')');
                }
            }
            String collect = Arrays.stream(stack.toArray()).map(Object::toString).collect(Collectors.joining());
            sout(i, collect);
        }
        scanner.close();
    }

    private static void sout(int x, String s) {
        System.out.println("Case #" + (x + 1) + ": " + s);
    }
}