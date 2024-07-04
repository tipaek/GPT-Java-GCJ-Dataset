import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            String result = solution.solve(input);
            out.println("Case #" + t + ": " + result);
        }
        out.close();
    }

    public String solve(String input) {
        int currentDepth = 0;
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            int targetDepth = c - '0';

            while (currentDepth < targetDepth) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > targetDepth) {
                result.append(')');
                currentDepth--;
            }
            result.append(c);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }

    // FastScanner class for faster input
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}