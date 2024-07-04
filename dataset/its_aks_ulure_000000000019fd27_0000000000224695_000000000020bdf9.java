import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
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
        Task solver = new Task();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task {
        int MAXN = 1005;
        PrintWriter out;
        InputReader in;
        ArrayList<Integer>[] graph = new ArrayList[MAXN];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int n = ni();
            int[][] time = new int[n][2];
            int i = 0, j = 0;
            for (i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                time[i][0] = ni();
                time[i][1] = ni();
            }
            for (i = 0; i < n; i++) {
                for (j = i + 1; j < n; j++) {
                    if (time[i][0] >= time[j][0] && time[i][0] < time[j][1]) {
                        graph[i].add(j);
                        graph[j].add(i);
                    } else if (time[j][0] >= time[i][0] && time[j][0] < time[i][1]) {
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }
            // for(i = 0; i < n; i++)
            //pn(graph[i]);
            Queue<Integer> qu = new LinkedList<>();
            int[] col = new int[n];
            Arrays.fill(col, -1);
            boolean is_bipartite = true;
            for (int st = 0; st < n; st++) {
                if (col[st] == -1) {
                    qu.add(st);
                    col[st] = 0;
                    while (qu.size() > 0) {
                        int v = qu.poll();
                        for (int u : graph[v]) {
                            if (col[u] == -1) {
                                col[u] = col[v] ^ 1;
                                qu.add(u);
                            } else
                                is_bipartite &= (col[u] != col[v]);
                        }
                    }
                }
            }
            p("Case #" + testNumber + ": ");
            if (!is_bipartite)
                pn("IMPOSSIBLE");
            else {
                for (i = 0; i < n; i++) {
                    if (col[i] == 0)
                        p("C");
                    else
                        p("J");
                }
                pn("");
            }
        }

        int ni() {
            return in.nextInt();
        }

        void pn(String zx) {
            out.println(zx);
        }

        void p(Object o) {
            out.print(o);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

