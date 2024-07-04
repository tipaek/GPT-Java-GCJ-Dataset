import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

    private static String solve(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            int d = c - '0';
            for (int j = 0; j < d; j++) {
                if (!deque.isEmpty() && deque.peek() == ')') {
                    deque.poll();
                } else {
                    deque.push('(');
                }
            }
            deque.push(c);
            for (int j = 0; j < d; j++) {
                deque.push(')');
            }
        }
        StringBuilder sb = new StringBuilder();
        deque.descendingIterator().forEachRemaining(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            PrintStream out = System.out;
            int t = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                String s = in.nextLine();
                out.println("Case #" + i + ": " + solve(s));
            }
        }
    }
}