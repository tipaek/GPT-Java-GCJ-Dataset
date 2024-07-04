import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
        int testCases = nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.print("Case #" + testCase + ": ");
            int left = nextInt();
            int right = nextInt();
            int last = 0;
            for (int i = 1; i <= Math.max(left, right); i++) {
                if (right > left) {
                    right -= i;
                } else {
                    left -= i;
                }
                last = i;
            }
            out.println(last + " " + left + " " + right);
        }
    }
}