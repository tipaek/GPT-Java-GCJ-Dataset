import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.List;
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
        PatternMatching solver = new PatternMatching();
        solver.solve(1, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, LightScanner in, LightWriter out) {
            // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
            out.setCaseLabel(LightWriter.CaseLabel.GCJ);
            int testCases = in.ints();
            loop:
            for (int testCase = 1; testCase <= testCases; testCase++) {
                out.cases(testCase);
                int n = in.ints();
                List<String> tokens = new ArrayList<>();
                String first = "", last = "";
                boolean ok = true;

                for (int i = 0; i < n; i++) {
                    char[] s = in.chars();
                    if (!ok) continue;

                    int m = s.length;
                    StringBuilder head = new StringBuilder(), tail = new StringBuilder(), middle = new StringBuilder();
                    int begin, end;
                    for (begin = 0; begin < m && s[begin] != '*'; begin++) head.append(s[begin]);
                    for (end = m - 1; end >= 0 && s[end] != '*'; end--) tail.append(s[end]);
                    for (int j = begin; j <= end; j++) if (s[j] != '*') middle.append(s[j]);
                    tail.reverse();
                    String heads = head.toString(), tails = tail.toString();
                    tokens.add(middle.toString());

                    if (!startsWith(heads, first) || !endsWith(tails, last)) {
                        ok = false;
                    } else {
                        first = max(first, heads);
                        last = max(last, tails);
                    }
                }
                //System.out.println(first + " + " + tokens + " + " + last);
                //System.out.println(Arrays.toString("A*C*E".split("\\*")));
                if (ok) {
                    out.print(first);
                    if (tokens.isEmpty()) tokens.add("A");
                    for (String x : tokens) out.print(x);
                    out.print(last);
                    out.ln().flush();
                } else {
                    out.print('*').ln().flush();
                }
            }
        }

        private static String max(String a, String b) {
            return a.length() > b.length() ? a : b;
        }

        private static boolean startsWith(String a, String b) {
            return a.length() > b.length() ? a.startsWith(b) : b.startsWith(a);
        }

        private static boolean endsWith(String a, String b) {
            return a.length() > b.length() ? a.endsWith(b) : b.endsWith(a);
        }

    }

    static class LightScanner implements AutoCloseable {
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

        public char[] chars() {
            return string().toCharArray();
        }

        public int ints() {
            return Integer.parseInt(string());
        }

        public void close() {
            try {
                this.reader.close();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

    }

    static class LightWriter implements AutoCloseable {
        private final Writer out;
        private boolean autoflush = false;
        private boolean breaked = true;
        private LightWriter.CaseLabel caseLabel = LightWriter.CaseLabel.NONE;

        public LightWriter(Writer out) {
            this.out = out;
        }

        public LightWriter(OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
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

        public LightWriter flush() {
            try {
                out.flush();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
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
}

