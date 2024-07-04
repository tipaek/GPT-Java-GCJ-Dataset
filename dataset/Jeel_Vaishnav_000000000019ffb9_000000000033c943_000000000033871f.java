import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int values[] = new int[n];
            for (int i = 1; i < n; ++i)
                values[i] = sc.nextInt();

            ArrayList<Pair> list = new ArrayList<>();
            ArrayList<Pair> qList = new ArrayList<>();
            ArrayList<Pair> vList = new ArrayList<>();

            list.add(new Pair(0, 0));
            for (int i = 1; i < n; ++i) {
                if (values[i] < 0)
                    qList.add(new Pair(i, -values[i]));
                else
                    vList.add(new Pair(i, values[i]));
            }

            Collections.sort(qList, new Comparator<Pair>() {

                public int compare(Pair o1, Pair o2) {
                    if (o1.value < o2.value)
                        return -1;
                    if (o1.value > o2.value)
                        return 1;
                    return 0;
                }
            });

            Collections.sort(vList, new Comparator<Pair>() {

                public int compare(Pair o1, Pair o2) {
                    if (o1.value < o2.value)
                        return -1;
                    if (o1.value > o2.value)
                        return 1;
                    return 0;
                }
            });


            ArrayList<Integer> adj[] = new ArrayList[n];
            for (int i = 0; i < n; ++i)
                adj[i] = new ArrayList<>();

            Edge e[] = new Edge[m];
            for (int i = 0; i < m; ++i) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                e[i] = new Edge(u, v);
                adj[u].add(i);
                adj[v].add(i);
            }

            int vptr = 0, qptr = 0;
            while (list.size() < n) {
                int size = list.size();
                int lastValue = list.get(size - 1).value;

                while (vptr < vList.size() && vList.get(vptr).value == size) {
                    Pair curP = vList.get(vptr);
                    list.add(new Pair(curP.ind, lastValue + 1));
                    vptr++;
                }

                if (size == list.size()) {
                    list.add(qList.get(qptr++));
                }
            }

            int ans[] = new int[n];
            Arrays.fill(ans, -1);
            ans[0] = 0;

            for (Pair curP : list) {
                int ind = curP.ind;
                for (int edgeInd : adj[ind]) {
                    Edge curE = e[edgeInd];
                    int j = curE.findAnother(ind);
                    if (ans[j] != -1 && curP.value - ans[j] > 0) {
                        e[edgeInd].latency = curP.value - ans[j];
                        break;
                    }
                }
                ans[ind] = curP.value;
            }

            System.out.print("Case #" + testNumber + ": ");
            for (Edge curE : e)
                System.out.print(curE.latency + " ");
            System.out.println();
        }

        class Edge {
            int u;
            int v;
            int latency;

            Edge(int a, int b) {
                u = a;
                v = b;
                latency = 1000000;
            }

            int findAnother(int a) {
                if (u == a)
                    return v;
                return u;
            }

        }

        class Pair {
            int ind;
            int value;

            Pair(int a, int b) {
                ind = a;
                value = b;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

