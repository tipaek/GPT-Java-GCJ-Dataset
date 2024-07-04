import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.Collections;
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
        OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakeChoppers {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int D = in.nextInt();
            long[] A = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }

            if (D <= 3) {
                out.println("Case #" + testNumber + ": " + solveTest1(N, D, A));
            } else {
                out.println("Case #" + testNumber + ": " + solveTest2(N, D, A));
            }
        }

        private int solveTest1(int N, int D, long[] A) {
            Set<Long> set = new HashSet<>();
            Map<Long, Integer> cnt = new HashMap<>();
            int maxCnt = 1;
            for (long a : A) {
                set.add(a);
                cnt.put(a, cnt.getOrDefault(a, 0) + 1);
            }
            maxCnt = Collections.max(cnt.values());

            if (D == 2) {
                if (maxCnt >= 2) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                //D == 3;
                if (maxCnt >= 3) {
                    return 0;
                } else if (maxCnt >= 2) {
                    if (N == 2) {
                        return 2;
                    } else {
                        return 1;
                    }
                } else {
                    for (long a : A) {
                        if (set.contains(2 * a)) {
                            return 1;
                        }
                    }
                    return 2;
                }
            }
        }

        private int solveTest2(int N, int D, long[] A) {
            return 0;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

