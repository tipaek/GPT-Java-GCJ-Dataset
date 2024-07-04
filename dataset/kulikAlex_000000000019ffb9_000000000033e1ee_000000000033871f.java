import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        A solver = new A();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int C = in.nextInt();
            int D = in.nextInt();
            ArrayList<node> nodes = new ArrayList<>();
            nodes.add(new node());
            nodes.get(0).id = 1;
            nodes.get(0).dist = 0;
            int[] dist = new int[C + 1];
            for (int i = 1; i < C; i++) {
                node cur = new node();
                cur.id = i + 1;
                cur.dist = in.nextInt();
                nodes.add(cur);
                dist[cur.id] = cur.dist;
            }
            ArrayList<edge> edges = new ArrayList<>();
            ArrayList<ArrayList<edge>> edgesByNode = new ArrayList<>();
            for (int i = 0; i <= C; i++) {
                edgesByNode.add(new ArrayList<>());
            }
            for (int i = 0; i < D; i++) {
                edge cur = new edge();
                cur.id = i;
                cur.u = in.nextInt();
                cur.v = in.nextInt();
                cur.w = 999_999;
                edges.add(cur);
                edgesByNode.get(cur.u).add(cur);
                edgesByNode.get(cur.v).add(cur);
            }
            for (node cur : nodes) {
                for (edge e : edgesByNode.get(cur.id)) {
                    int to = e.u;
                    if (to == cur.id) {
                        to = e.v;
                    }
                    if (dist[cur.id] > dist[to]) {
                        e.w = dist[cur.id] - dist[to];
                    }
                }
            }
            out.print("Case #" + testNumber + ":");
            for (edge cur : edges) {
                out.print(" " + cur.w);
            }
            out.println();
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() {

            try {

                return reader.readLine();

            } catch (IOException e) {

                return null;

            }

        }

        public String next() {

            while (stt == null || !stt.hasMoreTokens()) {

                stt = new StringTokenizer(nextLine());

            }

            return stt.nextToken();

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

    }

    static class node {
        int id;
        int dist;

    }

    static class edge {
        int id;
        int u;
        int v;
        int w;

    }
}

