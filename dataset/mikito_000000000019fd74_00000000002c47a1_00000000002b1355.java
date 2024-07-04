import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.ArrayDeque;
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
        SquareDance solver = new SquareDance();
        solver.solve(1, in, out);
        out.close();
    }

    static class SquareDance {
        private static final int[] DX = {1, 0, -1, 0};
        private static final int[] DY = {0, -1, 0, 1};
        private static final int[] REV = {2, 3, 0, 1};

        public void solve(int testNumber, LightScanner in, LightWriter out) {
            out.setCaseLabel(LightWriter.CaseLabel.GCJ);
            int testCases = in.ints();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                out.cases(testCase);
                int h = in.ints(), w = in.ints();
                long ans = 0, sum = 0;
                Queue<SquareDance.Node> q = new ArrayDeque<>(h * w), r = new ArrayDeque<>(h * w);
                SquareDance.Node[][] nodes = new SquareDance.Node[h][w];

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        nodes[i][j] = new SquareDance.Node(in.ints());
                        q.offer(nodes[i][j]);
                        sum += nodes[i][j].power;
                    }
                }
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        for (int k = 0; k < 4; k++) {
                            int y = i + DY[k], x = j + DX[k];
                            if (0 <= x && x < w && 0 <= y && y < h) {
                                nodes[i][j].neighbor[k] = nodes[y][x];
                            }
                        }
                    }
                }

                boolean cont = true;
                int uniq = 0;
                while (cont) {
                    cont = false;
                    uniq++;
                    ans += sum;
                    while (!q.isEmpty()) {
                        SquareDance.Node node = q.poll();
                        if (!node.wins()) {
                            node.destroyed = true;
                            cont = true;
                            r.offer(node);
                            sum -= node.power;
                        }
                    }
                    while (!r.isEmpty()) {
                        SquareDance.Node node = r.poll();
                        node.rebuild();
                        for (int i = 0; i < 4; i++) {
                            if (node.neighbor[i] != null && node.neighbor[i].t != uniq) {
                                q.offer(node.neighbor[i]);
                                node.neighbor[i].t = uniq;
                            }
                        }
                    }
                }
                out.ans(ans).ln();
            }
        }

        private static class Node {
            final int power;
            SquareDance.Node[] neighbor = new SquareDance.Node[4];
            boolean destroyed = false;
            int t = 0;

            Node(int power) {
                this.power = power;
            }

            boolean wins() {
                int count = 0, sum = 0;
                for (int i = 0; i < 4; i++) {
                    if (neighbor[i] != null) {
                        count++;
                        sum += neighbor[i].power;
                    }
                }
                return power * count >= sum;
            }

            void rebuild() {
                if (!destroyed) return;
                for (int i = 0; i < 4; i++) {
                    if (neighbor[i] != null) neighbor[i].neighbor[REV[i]] = neighbor[REV[i]];
                }
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
}

