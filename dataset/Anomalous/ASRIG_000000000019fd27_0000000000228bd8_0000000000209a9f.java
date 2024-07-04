import java.io.*;
import java.util.*;

public class Solution {

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            Stack<Character> stack = new Stack<>();
            char[] str = sc.br.readLine().toCharArray();
            int strLength = str.length;

            for (int i = 0; i < strLength; i++) {
                int currentDigit = str[i] - '0';
                if (i == 0) {
                    for (int j = 0; j < currentDigit; j++) stack.push('(');
                    stack.push(str[i]);
                } else {
                    int previousDigit = stack.peek() - '0';
                    if (previousDigit > currentDigit) {
                        for (int j = 0; j < previousDigit - currentDigit; j++) stack.push(')');
                        stack.push(str[i]);
                    } else if (previousDigit == currentDigit) {
                        stack.push(str[i]);
                    } else {
                        for (int j = 0; j < currentDigit - previousDigit; j++) stack.push('(');
                        stack.push(str[i]);
                    }
                }

                if (i == strLength - 1) {
                    int lastDigit = stack.peek() - '0';
                    for (int j = 0; j < lastDigit; j++) stack.push(')');
                }
            }

            out.printf("Case #%d: ", tc);
            for (char ch : stack) {
                out.print(ch);
            }
            out.println();
            out.flush();
        }
    }
}