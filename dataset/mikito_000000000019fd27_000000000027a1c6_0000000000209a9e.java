import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

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
        ESAbATAd solver = new ESAbATAd();
        solver.solve(1, in, out);
        out.close();
    }

    static class ESAbATAd {
        public void solve(int testNumber, LightScanner in, LightWriter out) {
            // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
            // out.setCaseLabel(LightWriter.CaseLabel.NONE);
            out.enableAutoFlush();
            int testCases = in.ints(), b = in.ints();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                out.ans(1).ln().ans(1).ln();
                in.voids();
                in.voids();// sentinel
                ESAbATAd.Storage storage = new ESAbATAd.Storage(b);
                int cursor = 0;
                while (cursor * 2 < b) {
                    for (int _x = 0; _x < 4 && cursor * 2 < b; _x++) {
                        out.ans(cursor + 1).ln().ans(b - cursor).ln();
                        storage.a[cursor] = in.ints();
                        storage.a[b - cursor - 1] = in.ints();
                        cursor++;
                    }
                    if (cursor * 2 >= b) break;

                    int s = storage.pick(0);
                    if (s >= 0) {
                        out.ans(s + 1).ln();
                        if (storage.a[s] != in.ints()) storage.flip();
                    } else {
                        out.ans(1).ln();
                        in.voids();
                    }

                    int t = storage.pick(1);
                    if (t >= 0) {
                        out.ans(t + 1).ln();
                        if (storage.a[t] != in.ints()) storage.reverse();
                    } else {
                        out.ans(1).ln();
                        in.voids();
                    }
                }
                for (int i = 0; i < b; i++) out.print((char) (storage.a[i] + '0'));
                out.ln();
                if ("N".equals(in.string())) return;
            }
        }

        private static class Storage {
            int n;
            int[] a;

            Storage(int n) {
                this.n = n;
                this.a = new int[n];
                Arrays.fill(a, -1);
            }

            void reverse() {
                ArrayUtil.reverse(a, 0, n);
            }

            void flip() {
                for (int i = 0; i < n; i++) {
                    if (a[i] >= 0) a[i] ^= 1;
                }
            }

            int pick(int xor) {
                for (int i = 0; i * 2 < n; i++) {
                    if (a[i] >= 0 && a[n - i - 1] >= 0 && (a[i] ^ a[n - i - 1]) == xor) return i;
                }
                return -1;
            }

        }

    }

    static class LightWriter implements AutoCloseable {
        private final Writer out;
        private boolean autoflush = false;
        private boolean breaked = true;

        public LightWriter(Writer out) {
            this.out = out;
        }

        public LightWriter(OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
        }

        public void enableAutoFlush() {
            autoflush = true;
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

        public LightWriter ans(String s) {
            if (!breaked) {
                print(' ');
            }
            return print(s);
        }

        public LightWriter ans(int i) {
            return ans(Integer.toString(i));
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

    }

    static final class ArrayUtil {
        private ArrayUtil() {
        }

        public static void reverse(int[] a, int left, int right) {
            right--;
            while (left < right) {
                int temp = a[left];
                a[left++] = a[right];
                a[right--] = temp;
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

        public void voids() {
            string();
        }

        public int ints() {
            return Integer.parseInt(string());
        }

    }
}

