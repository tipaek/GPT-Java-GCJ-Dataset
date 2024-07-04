import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NamingCompromise solver = new NamingCompromise();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NamingCompromise {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            char[] s = sc.next().toCharArray();
            char[] t = sc.next().toCharArray();

            int n = s.length;
            int m = t.length;

            int dp[][][] = new int[n + 1][m + 1][300];
            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= m; ++j)
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }

            dp[0][0][0 + 150] = 0;
            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= m; ++j) {
                    if (i == 0 && j == 0)
                        continue;
                    for (int k = 0; k < 300; ++k) {
                        if (i - 1 >= 0 && j - 1 >= 0 && s[i - 1] == t[j - 1])
                            dp[i][j][k] = dp[i - 1][j - 1][k];
                        if (k - 1 >= 0 && i - 1 >= 0) {
                            if (dp[i - 1][j][k - 1] != Integer.MAX_VALUE)
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k - 1] + 1);
                            if (j - 1 >= 0 && dp[i - 1][j - 1][k - 1] != Integer.MAX_VALUE)
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][k - 1] + 1);
                        }
                        if (k + 1 < 300 && j - 1 >= 0) {
                            if (dp[i][j - 1][k + 1] != Integer.MAX_VALUE)
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i][j - 1][k + 1] + 1);
                            if (i - 1 >= 0 && dp[i - 1][j - 1][k + 1] != Integer.MAX_VALUE)
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][k + 1] + 1);
                        }
                        if (k + 1 < 300 && i - 1 >= 0 && dp[i - 1][j][k + 1] != Integer.MAX_VALUE)
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k + 1] + 1);
                        if (k - 1 >= 0 && j - 1 >= 0 && dp[i][j - 1][k - 1] != Integer.MAX_VALUE)
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i][j - 1][k - 1] + 1);
                    }
                }
            }

            int minCost = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < 300; ++i) {
                if (dp[n][m][i] < minCost) {
                    minCost = dp[n][m][i];
                    minDiff = Math.abs(i - 150);
                } else if (dp[n][m][i] == minCost) {
                    minDiff = Math.min(minDiff, Math.abs(i - 150));
                }
            }

//        out.println(minCost + " " + minDiff);

            int i = n, j = m, k = minDiff + 150;
            ArrayList<Character> ans = new ArrayList<>();
            while (!(i == 0 && j == 0)) {
//            out.println(i + " " + j + " " + (k - 150));
                if (k + 1 < 300 && i - 1 >= 0 && dp[i - 1][j][k + 1] == dp[i][j][k] - 1) {
                    ans.add(s[i - 1]);
                    i--;
                    k++;
                    continue;
                }

                if (k - 1 >= 0 && j - 1 >= 0 && dp[i][j - 1][k - 1] == dp[i][j][k] - 1) {
                    ans.add(t[j - 1]);
                    j--;
                    k--;
                    continue;
                }
                if (k + 1 < 300 && j - 1 >= 0) {
                    if (dp[i][j][k] - 1 == dp[i][j - 1][k + 1]) {
                        j--;
                        k++;
                        continue;
                    }
                    if (i - 1 >= 0 && dp[i][j][k] - 1 == dp[i - 1][j - 1][k + 1]) {
                        ans.add(s[i - 1]);
                        i--;
                        j--;
                        k++;
                        continue;
                    }
                }
                if (k - 1 >= 0 && i - 1 >= 0) {
                    if (dp[i][j][k] - 1 == dp[i - 1][j][k - 1]) {
                        i--;
                        k--;
                        continue;
                    }
                    if (j - 1 >= 0 && dp[i][j][k] - 1 == dp[i - 1][j - 1][k - 1]) {
                        ans.add(t[j - 1]);
                        i--;
                        j--;
                        k--;
                        continue;
                    }
                }
                if (i - 1 >= 0 && j - 1 >= 0 && s[i - 1] == t[j - 1] && dp[i][j][k] == dp[i - 1][j - 1][k]) {
                    ans.add(s[i - 1]);
                    i--;
                    j--;
                }
            }

            out.print("Case #" + testNumber + ": ");
            for (int ind = ans.size() - 1; ind >= 0; ind--)
                out.print(ans.get(ind));
            out.println();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

