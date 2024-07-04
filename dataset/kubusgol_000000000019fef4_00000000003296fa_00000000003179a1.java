import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
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
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int U = in.nextInt();
            int Q_LEN = 10000;
            int[] Q = new int[Q_LEN];
            String[] R = new String[Q_LEN];
            boolean test2 = U == 16;
            boolean test3 = false;
            for (int i = 0; i < Q_LEN; i++) {
                Q[i] = in.nextInt();
                R[i] = in.next();
                if (Q[i] == -1) {
                    test3 = true;
                }
            }

            if (test3) {
                out.println("Case #" + testNumber + ": " + solveTest3(U, Q, R));
            } else if (test2) {
                out.println("Case #" + testNumber + ": " + solveTest1(U, Q, R));
            } else {
                out.println("Case #" + testNumber + ": " + solveTest1(U, Q, R));
            }
        }

        private String solveTest1(int U, int[] Q, String[] R) {
            Map<Integer, Set<Character>> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < Q.length; i++) {
                map.computeIfAbsent(Q[i], x -> new HashSet<>());
                for (char c : R[i].toCharArray()) {
                    map.get(Q[i]).add(c);
                    set.add(c);
                }
            }

            char[] ans = new char[10];

            for (int d = 1; d <= 9; d++) {
                for (char cand : map.get(d)) {
                    if (set.contains(cand)) {
                        set.remove(cand);
                        ans[d] = cand;
                        break;
                    }
                }
            }
            ans[0] = set.iterator().next();

            return new String(ans);
        }

        private String solveTest2(int U, int[] Q, String[] R) {
            return "";
        }

        private String solveTest3(int U, int[] Q, String[] R) {
            return "";
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

