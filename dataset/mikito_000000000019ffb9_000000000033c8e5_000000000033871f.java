import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.List;
import java.util.AbstractCollection;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.util.Comparator;
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
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        private static final int INF = 1_000_000;

        public void solve(int testNumber, LightScanner in, LightWriter out) {
            int n = in.ints(), m = in.ints();
            SecurityUpdate.Node[] nodes = new SecurityUpdate.Node[n];
            SecurityUpdate.Edge[] edges = new SecurityUpdate.Edge[m];
            nodes[0] = new SecurityUpdate.Node();
            nodes[0].t = 0;
            nodes[0].k = 0;
            nodes[0].done = true;
            for (int i = 1; i < n; i++) {
                nodes[i] = new SecurityUpdate.Node();
                int x = in.ints();
                if (x < 0) nodes[i].k = -x;
                else nodes[i].t = x;
            }
            for (int i = 0; i < m; i++) {
                int x = in.ints() - 1, y = in.ints() - 1;
                edges[i] = new SecurityUpdate.Edge(nodes[x], nodes[y]);
                nodes[x].edges.add(edges[i]);
                nodes[y].edges.add(edges[i]);
            }

            PriorityQueue<SecurityUpdate.Visit> tq = new PriorityQueue<>(Comparator.comparing(v -> v.to.t)), kq = new PriorityQueue<>(Comparator.comparing(v -> v.to.k));
            for (SecurityUpdate.Edge e : nodes[0].edges) {
                SecurityUpdate.Node dest = e.other(nodes[0]);
                if (dest.k >= 0) kq.offer(new SecurityUpdate.Visit(nodes[0], dest, e));
                else tq.offer(new SecurityUpdate.Visit(nodes[0], dest, e));
            }
            int count = 1, time = 1;
            while (count < n) {
                if (!tq.isEmpty() && (kq.isEmpty() || kq.peek().to.k < count || tq.peek().to.t == time)) {
                    time = tq.peek().to.t;
                    int deltac = 0;
                    while (!tq.isEmpty() && tq.peek().to.t == time) {
                        SecurityUpdate.Visit v = tq.poll();
                        if (v.to.done || v.from.t == time) continue;
                        deltac++;
                        v.to.k = count;
                        v.to.done = true;
                        v.via.d = time - v.from.t;
                        for (SecurityUpdate.Edge e : v.to.edges) {
                            SecurityUpdate.Node dest = e.other(v.to);
                            if (dest.done) continue;
                            if (dest.k >= 0) kq.offer(new SecurityUpdate.Visit(v.to, dest, e));
                            else tq.offer(new SecurityUpdate.Visit(v.to, dest, e));
                        }
                    }
                    count += deltac;
                    //System.out.println(deltac);
                } else {
                    if (kq.isEmpty()) throw new RuntimeException();
                    int k = kq.peek().to.k;
                    while (!kq.isEmpty() && kq.peek().to.k == k) {
                        SecurityUpdate.Visit v = kq.poll();
                        if (v.to.done || v.from.t == time) continue;
                        v.to.t = time;
                        v.to.done = true;
                        v.via.d = time - v.from.t;
                        for (SecurityUpdate.Edge e : v.to.edges) {
                            SecurityUpdate.Node dest = e.other(v.to);
                            if (dest.done) continue;
                            if (dest.k >= 0) kq.offer(new SecurityUpdate.Visit(v.to, dest, e));
                            else tq.offer(new SecurityUpdate.Visit(v.to, dest, e));
                        }
                        count++;
                    }
                    time++;
                }
            }

            out.setCaseLabel(LightWriter.CaseLabel.GCJ);
            out.cases(testNumber);
            for (int i = 0; i < m; i++) out.ans(edges[i].d);
            out.ln();
        }

        private static class Node {
            private int k = -1;
            private int t = -1;
            boolean done = false;
            List<SecurityUpdate.Edge> edges = new ArrayList<>();

        }

        private static class Edge {
            final SecurityUpdate.Node x;
            final SecurityUpdate.Node y;
            int d = INF;

            Edge(SecurityUpdate.Node x, SecurityUpdate.Node y) {
                this.x = x;
                this.y = y;
            }

            SecurityUpdate.Node other(SecurityUpdate.Node s) {
                return s == x ? y : x;
            }

        }

        private static class Visit {
            final SecurityUpdate.Node from;
            final SecurityUpdate.Node to;
            final SecurityUpdate.Edge via;

            Visit(SecurityUpdate.Node from, SecurityUpdate.Node to, SecurityUpdate.Edge via) {
                this.from = from;
                this.to = to;
                this.via = via;
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
}

