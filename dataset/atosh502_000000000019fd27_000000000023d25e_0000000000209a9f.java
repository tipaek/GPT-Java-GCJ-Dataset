import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    private static int openCnt = 0;

    public static void addToStack(Stack<Character> stack, Character c, int count) {
        while (count != 0) {
            stack.push(c);
            count--;
        }
    }

    public static void addCharacter(Stack<Character> stack, Character c) {
        if (stack.empty()) {
            if (c == '0') {
                stack.push(c);
            } else {
                int curr = c - '0';
                openCnt += curr;
                addToStack(stack, '(', curr);
                addToStack(stack, c, 1);
            }
        } else {
            // stack is not empty
            int top = stack.peek() - '0';
            int curr = c - '0';
            if (top > curr) {
                int diff = top - curr;
                openCnt -= diff;
                addToStack(stack, ')', diff);
                addToStack(stack, c, 1);
            } else if (top < curr) {
                int diff = curr - openCnt;
                openCnt += diff;
                addToStack(stack, '(', diff);
                addToStack(stack, c, 1);
            } else {
                addToStack(stack, c, 1);
            }
        }
    }

    public static void main(String[] args) {
        FastReader cin = new FastReader();
        int tc = cin.nextInt();
        String s;
        Stack<Character> stack = new Stack<>();
        Stack<Character> reverseStack = new Stack<>();
        for (int t = 1; t <= tc; ++t) {

            reverseStack.clear();
            stack.clear();
            openCnt = 0;

            s = cin.nextLine();
            for (int i = 0; i < s.length(); ++i) {
                addCharacter(stack, s.charAt(i));
            }

            addToStack(stack, ')', openCnt);

            // reverse the stack
            while (!stack.empty()) {
                reverseStack.push(stack.pop());
            }

            StringBuilder result = new StringBuilder();
            while (!reverseStack.empty()) {
                result.append(reverseStack.pop());
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    // FastReader class
    // credit goes to GeeksForGeeks
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}