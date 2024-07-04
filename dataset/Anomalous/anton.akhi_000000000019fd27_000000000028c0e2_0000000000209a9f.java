import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            char[] s = nextToken().toCharArray();
            int currentDepth = 0;
            for (char c : s) {
                int requiredDepth = c - '0';
                while (requiredDepth > currentDepth) {
                    out.print("(");
                    currentDepth++;
                }
                while (requiredDepth < currentDepth) {
                    out.print(")");
                    currentDepth--;
                }
                out.print(c);
            }
            while (currentDepth > 0) {
                out.print(")");
                currentDepth--;
            }
            out.println();
        }
    }
}