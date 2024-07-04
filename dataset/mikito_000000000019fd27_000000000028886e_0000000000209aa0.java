import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.function.IntFunction;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mikit
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        LightScanner in = new LightScanner(inputStream);
        LightWriter out = new LightWriter(outputStream);
        Indicium solver = new Indicium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, LightScanner in, LightWriter out) {
            out.setCaseLabel(LightWriter.CaseLabel.GCJ);
            out.setBoolLabel(LightWriter.BoolLabel.POSSIBLE_IMPOSSIBLE_ALL_UP);
            int testCases = in.ints();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                out.cases(testCase);
                int n = in.ints(), k = in.ints();
                int[][] mat = new int[n][n];
                ArrayUtil.fill(mat, -1);
                if (!dfs(n, mat, 0, k)) out.noln();
                else {
                    out.yesln();
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            out.ans(mat[i][j] + 1);
                        }
                        out.ln();
                    }
                }
            }
        /*
        int[][] mat = new int[N][N];
        ArrayUtil.fill(mat, -1);
        dfs(N, mat, 0, 5);
        //if (!dfs(mat, 0, 10)) return;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                out.ans(mat[i][j] + 1);
            }
            out.ln();
        }*/
        }

        private static boolean dfs(int n, int[][] mat, int now, int goal) {
            if (now == n * n) {
                int diag = 0;
                for (int i = 0; i < n; i++) diag += mat[i][i] + 1;
                return diag == goal;
            }

            int y = (now + now / n) % n, x = now % n;
            int f = 0;
            for (int i = 0; i < n; i++) {
                if (mat[x][i] >= 0) f |= (1 << mat[x][i]);
                if (mat[i][y] >= 0) f |= (1 << mat[i][y]);
            }
            for (int i = 0; i < n; i++) {
                if (((f >> i) & 1) == 1) continue;
                mat[x][y] = i;
                if (dfs(n, mat, now + 1, goal)) return true;
                mat[x][y] = -1;
            }
            return false;
        }

    }

    static class LightWriter implements AutoCloseable {
        private final Writer out;
        private boolean autoflush = false;
        private boolean breaked = true;
        private LightWriter.BoolLabel boolLabel = LightWriter.BoolLabel.YES_NO_FIRST_UP;
        private LightWriter.CaseLabel caseLabel = LightWriter.CaseLabel.NONE;

        public LightWriter(Writer out) {
            this.out = out;
        }

        public LightWriter(OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
        }

        public void setBoolLabel(LightWriter.BoolLabel label) {
            this.boolLabel = Objects.requireNonNull(label);
        }

        public void setCaseLabel(LightWriter.CaseLabel label) {
            this.caseLabel = Objects.requireNonNull(label);
        }

        public LightWriter print(char c) {
            try {
                out.write(c);
                breaked = false;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
            return this;
        }

        public LightWriter print(String s) {
            try {
                out.write(s, 0, s.length());
                breaked = false;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
            return this;
        }

        public LightWriter cases(int x) {
            if (!breaked) ln();
            print(caseLabel.format.apply(x));
            breaked = true;
            return this;
        }

        public LightWriter ans(String s) {
            if (!breaked) {
                print(' ');
            }
            return print(s);
        }

        public LightWriter ans(int i) {
            return ans(Integer.toString(i));
        }

        public LightWriter ans(boolean b) {
            return ans(boolLabel.transfer(b));
        }

        public LightWriter yesln() {
            return ans(true).ln();
        }

        public LightWriter noln() {
            return ans(false).ln();
        }

        public LightWriter ln() {
            print(System.lineSeparator());
            breaked = true;
            if (autoflush) {
                try {
                    out.flush();
                } catch (IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            }
            return this;
        }

        public void close() {
            try {
                out.close();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

        public enum BoolLabel {
            YES_NO_FIRST_UP("Yes", "No"),
            YES_NO_ALL_UP("YES", "NO"),
            YES_NO_ALL_DOWN("yes", "no"),
            Y_N_ALL_UP("Y", "N"),
            POSSIBLE_IMPOSSIBLE_FIRST_UP("Possible", "Impossible"),
            POSSIBLE_IMPOSSIBLE_ALL_UP("POSSIBLE", "IMPOSSIBLE"),
            POSSIBLE_IMPOSSIBLE_ALL_DOWN("possible", "impossible"),
            FIRST_SECOND_FIRST_UP("First", "Second"),
            FIRST_SECOND_ALL_UP("FIRST", "SECOND"),
            FIRST_SECOND_ALL_DOWN("first", "second"),
            ALICE_BOB_FIRST_UP("Alice", "Bob"),
            ALICE_BOB_ALL_UP("ALICE", "BOB"),
            ALICE_BOB_ALL_DOWN("alice", "bob"),
            ;
            private final String positive;
            private final String negative;

            BoolLabel(String positive, String negative) {
                this.positive = positive;
                this.negative = negative;
            }

            private String transfer(boolean f) {
                return f ? positive : negative;
            }

        }

        public enum CaseLabel {
            NONE(x -> ""),
            GCJ(x -> "Case #" + x + ": "),
            ;
            private final IntFunction<String> format;

            CaseLabel(IntFunction<String> format) {
                this.format = format;
            }

        }

    }

    static final class ArrayUtil {
        private ArrayUtil() {
        }

        public static void fill(int[] a, int v) {
            Arrays.fill(a, v);
        }

        public static void fill(int[][] a, int v) {
            for (int i = 0; i < a.length; i++) {
                fill(a[i], v);
            }
        }

    }

    static class LightScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public LightScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public String string() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ints() {
            return Integer.parseInt(string());
        }

    }
}

