import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task1 solver = new Task1();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task1 {
        int x;
        int y;
        int[] path;
        int MAX_LEN = 8;
        StringBuilder ans;
        int minLen;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            int qq = 1;
            while (t > 0) {
                t--;
                x = in.nextInt();
                y = in.nextInt();
                path = new int[MAX_LEN];
                minLen = -1;
                out.println("Case #" + qq + ": " + sol());
                qq++;
            }
        }

        String sol() {
            rec(0, 0, 0);
            return minLen == -1 ? "IMPOSSIBLE" : ans.toString();
        }

        void rec(int cx, int cy, int pos) {
            if (cx == x & cy == y) {
                if (minLen == -1) {
                    ans = new StringBuilder();
                    minLen = pos + 1;
                    for (int i = 0; i < pos; i++) {
                        switch (path[i]) {
                            case 0:
                                ans.append("N");
                                break;
                            case 1:
                                ans.append("E");
                                break;
                            case 2:
                                ans.append("S");
                                break;
                            case 3:
                                ans.append("W");
                                break;
                        }
                    }
                } else {
                    if (pos + 1 < minLen) {
                        ans = new StringBuilder();
                        minLen = pos + 1;
                        for (int i = 0; i < pos; i++) {
                            switch (path[i]) {
                                case 0:
                                    ans.append("N");
                                    break;
                                case 1:
                                    ans.append("E");
                                    break;
                                case 2:
                                    ans.append("S");
                                    break;
                                case 3:
                                    ans.append("W");
                                    break;
                            }
                        }
                    }
                }
            } else {
                if (pos < MAX_LEN) {
                    for (int i = 0; i < 4; i++) {
                        int df = 1 << pos;
                        path[pos] = i;
                        switch (i) {
                            case 0:
                                rec(cx, cy + df, pos + 1);
                                break;
                            case 1:
                                rec(cx + df, cy, pos + 1);
                                break;
                            case 2:
                                rec(cx, cy - df, pos + 1);
                                break;
                            case 3:
                                rec(cx - df, cy, pos + 1);
                                break;
                        }
                    }
                } else {
                    // bad
                }
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

