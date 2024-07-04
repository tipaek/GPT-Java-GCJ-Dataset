import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tokenizer = new StringTokenizer("");

        Task solver = new Task();
        solver.solve();

        br.close();
        out.close();
    }

    static class Task {
        public void solve() throws IOException {
            int t = nextInt();

            for (int caseNum = 1; caseNum <= t; caseNum++) {
                char[] s = nextCharArray();
                List<Character> result = new ArrayList<>();

                for (char c : s) {
                    int num = c - '0';
                    balanceBrackets(result, num);
                    result.add(c);
                }

                finalizeBrackets(result);

                StringBuilder sb = new StringBuilder();
                for (char c : result) {
                    sb.append(c);
                }

                out.println("Case #" + caseNum + ": " + sb.toString());
            }
        }

        private void balanceBrackets(List<Character> result, int num) {
            int open = 0, close = 0;
            for (char c : result) {
                if (c == '(') open++;
                else if (c == ')') close++;
            }

            while (open - close != num) {
                if (open - close < num) {
                    result.add('(');
                    open++;
                } else {
                    result.add(')');
                    close++;
                }
            }
        }

        private void finalizeBrackets(List<Character> result) {
            int n = result.size() - 1;
            while (n >= 0) {
                if (Character.isDigit(result.get(n))) {
                    int num = result.get(n) - '0';
                    int open = 0, close = 0;

                    for (int j = n + 1; j < result.size(); j++) {
                        if (result.get(j) == '(') open++;
                        else if (result.get(j) == ')') close++;
                    }

                    while (close - open < num) {
                        result.add(n + 1, ')');
                        close++;
                    }
                }
                n--;
            }
        }
    }

    private static String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            tokenizer = new StringTokenizer(line.trim());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static char[] nextCharArray() throws IOException {
        return nextToken().toCharArray();
    }
}