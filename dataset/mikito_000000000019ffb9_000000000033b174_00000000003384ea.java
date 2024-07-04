import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        public void solve(int testNumber, LightScanner in, LightWriter out) {
            out.setCaseLabel(LightWriter.CaseLabel.GCJ);
            long lo = in.longs(), hi = in.longs();
            out.cases(testNumber);
            boolean rev = false;

            long x;
            {
                long min = 0, max = 2_000_000_000;
                while (max - min > 1) {
                    long mid = (min + max) / 2;
                    //System.out.println(mid);
                    long s = mid * (mid + 1) / 2;
                    if (Math.abs(hi - lo) >= s) min = mid;
                    else max = mid;
                }
                long st = min * (min + 1) / 2;
                if (lo >= hi) lo -= st;
                else hi -= st;
                x = min;
            }
            while (lo > x || hi > x) {
                if (lo > hi) {
                    rev = !rev;
                    long t = lo;
                    lo = hi;
                    hi = t;
                }
                if (lo == hi) {
                    lo -= ++x;
                    rev = false;
                    continue;
                }
                long min = -1, max = 200_000_000;
                while (max - min > 1) {
                    long n = (min + max) / 2;
                    long dl = n * (n + x + 1), dr = (n + 1) * (n + x + 1);
                    if (lo - dl <= hi - dr || lo - dl < 0 || hi - dr < 0) max = n;
                    else min = n;
                }
                long cnt = max, dl = max * (max + x + 1), dr = (max + 1) * (max + x + 1);
                if (lo - dl < 0 || hi - dr < 0) {
                    cnt = min;
                    dl = min * (min + x + 1);
                    dr = (min + 1) * (min + x + 1);
                }
                //System.out.println(cnt + " " + lo + " " + hi);
                //if (x > 1000) break;
                //System.out.println(lo + "-" + dl + " " + hi + "-" + dr);
                lo -= dl;
                hi -= dr;
                x += cnt * 2 + 1;

            }

            if (rev) {
                long t = lo;
                lo = hi;
                hi = t;
            }
            out.ans(x).ans(lo).ans(hi).ln();
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

        public LightWriter ans(String s) {
            if (!breaked) {
                print(' ');
            }
            return print(s);
        }

        public LightWriter ans(long l) {
            return ans(Long.toString(l));
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

        public String next() {
            return string();
        }

        public long longs() {
            return Long.parseLong(string());
        }

        public void close() {
            try {
                this.reader.close();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

    }
}

