import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int[][] ranges = new int[N][2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= 1; j++) {
                    ranges[i][j] = in.nextInt();
                }
            }

            Integer[] id = new Integer[N];
            for (int i = 0; i < N; i++) id[i] = i;

            Arrays.sort(id, (a, b) -> {
                if (ranges[a][0] == ranges[b][0]) {
                    return ranges[a][1] - ranges[b][1];
                }
                return ranges[a][0] - ranges[b][0];
            });

            out.println("Case #" + testNumber + ": " + solve(ranges, id));
        }

        private String solve(int[][] ranges, Integer[] id) {
            int N = ranges.length;
            char[] ans = new char[N];
            ans[id[0]] = 'C';
            ans[id[1]] = 'J';
            int C = id[0];
            int J = id[1];

            for (int i = 2; i < N; i++) {
                if (ranges[C][1] <= ranges[J][1]) {
                    if (ranges[C][1] > ranges[id[i]][0]) {
                        return "IMPOSSIBLE";
                    } else {
                        ans[id[i]] = 'C';
                        C = id[i];
                    }
                } else {
                    if (ranges[J][1] > ranges[id[i]][0]) {
                        return "IMPOSSIBLE";
                    } else {
                        ans[id[i]] = 'J';
                        J = id[i];
                    }
                }
            }

            return new String(ans);
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

