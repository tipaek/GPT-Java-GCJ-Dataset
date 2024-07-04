import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    private static int openCount = 0;

    public static void addToStack(Stack<Character> stack, char c, int count) {
        for (int i = 0; i < count; i++) {
            stack.push(c);
        }
    }

    public static void addCharacter(Stack<Character> stack, char c) {
        if (stack.isEmpty()) {
            if (c == '0') {
                stack.push(c);
            } else {
                int current = c - '0';
                openCount += current;
                addToStack(stack, '(', current);
                stack.push(c);
            }
        } else {
            int top = stack.peek() - '0';
            int current = c - '0';
            if (top > current) {
                int diff = top - current;
                openCount -= diff;
                addToStack(stack, ')', diff);
                stack.push(c);
            } else if (top < current) {
                int diff = current - openCount;
                openCount += diff;
                addToStack(stack, '(', diff);
                stack.push(c);
            } else {
                stack.push(c);
            }
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            Stack<Character> stack = new Stack<>();
            Stack<Character> reverseStack = new Stack<>();
            openCount = 0;

            String input = reader.nextLine();
            for (char c : input.toCharArray()) {
                addCharacter(stack, c);
            }

            addToStack(stack, ')', openCount);

            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }

            StringBuilder result = new StringBuilder();
            while (!reverseStack.isEmpty()) {
                result.append(reverseStack.pop());
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}