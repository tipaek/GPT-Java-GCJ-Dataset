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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D_EsabAtad solver = new D_EsabAtad();
        solver.solve(1, in, out);
        out.close();
    }

    static class D_EsabAtad {
        FastScanner in;
        PrintWriter out;
        int B;
        final int S = 10;
        int numAsked;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            this.in = in;
            this.out = out;

            int numTests = in.nextInt();
            B = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                solveOne();
            }
        }

        private void solveOne() {
            numAsked = 0;
            int[] askTime = new int[B];
            boolean[] same = new boolean[B];
            int numBlocks = B / S;
            int[] diffInBlock = new int[numBlocks];
            int[] sameInBlock = new int[numBlocks];
            Arrays.fill(diffInBlock, -1);
            Arrays.fill(sameInBlock, -1);
            int[] valueWhenFirstAsked = new int[B];
            for (int i = 0; i < B / 2; i++) {
                int j = B - i - 1;
                int block = numAsked / S;
                askTime[i] = block;
                askTime[j] = block;
                valueWhenFirstAsked[i] = ask(i);
                valueWhenFirstAsked[j] = ask(j);
                if (valueWhenFirstAsked[i] == valueWhenFirstAsked[j]) {
                    same[i] = true;
                    same[j] = true;
                    sameInBlock[block] = i;
                } else {
                    same[i] = false;
                    same[j] = false;
                    diffInBlock[block] = i;
                }
            }

            char[] ans = new char[B];
            Arrays.fill(ans, '.');

            int anySame = -1;
            int anySameVal = -1;
            for (int block = 0; block < numBlocks; block++) {
                int i = sameInBlock[block];
                if (i < 0) {
                    continue;
                }
                int x = ask(i);
                anySame = i;
                anySameVal = x;
                ans[i] = (char) (x + '0');
            }
            while (numAsked % S != 0) {
                ask(0);
            }

            int anyDiff = -1;
            int anyDiffVal = -1;
            for (int block = 0; block < numBlocks; block++) {
                int i = diffInBlock[block];
                if (i < 0) {
                    continue;
                }
                int x = ask(i);
                anyDiff = i;
                anyDiffVal = x;
                ans[i] = (char) (x + '0');
            }
            while (numAsked % S != 0) {
                ask(0);
            }

            if (anySame >= 0) {
                int x = ask(anySame);
                if (x != anySameVal) {
                    for (int i = 0; i < B / 2; i++) {
                        if (same[i] && ans[i] != '.') {
                            ans[i] = flip(ans[i], false);
                        }
                    }
                }
            }

            if (anyDiff >= 0) {
                int x = ask(anyDiff);
                if (x != anyDiffVal) {
                    for (int i = 0; i < B / 2; i++) {
                        if (!same[i] && ans[i] != '.') {
                            ans[i] = flip(ans[i], false);
                        }
                    }
                }
            }

            for (int i = 0; i < B / 2; i++) {
                if (ans[i] != '.') {
                    continue;
                }
                for (int j = 0; j < B / 2; j++) {
                    if (same[i] == same[j] && askTime[i] == askTime[j]) {
                        ans[i] = flip(ans[j], valueWhenFirstAsked[i] == valueWhenFirstAsked[j]);
                    }
                }
            }
            for (int i = B / 2; i < B; i++) {
                ans[i] = flip(ans[B - i - 1], same[i]);
            }

            out.println(new String(ans));
            out.flush();
            String t = in.next();
            if (!t.equals("Y")) {
                throw new AssertionError(t);
            }
        }

        private char flip(char c, boolean same) {
            if (same) {
                return c;
            }
            return (char) (c ^ '0' ^ '1');
        }

        private int ask(int pos) {
            if (++numAsked >= 150) {
                throw new AssertionError("Too many queries");
            }
            out.println(pos + 1);
            out.flush();
            return in.nextInt();
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

