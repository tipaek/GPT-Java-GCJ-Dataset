import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private class Vertex implements Comparable<Vertex> {
        int b = -1;
        int id;
        int dist = -1;

        Vertex(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.b, v.b);
        }
    }

    private class Edge {
        int u, v;
        int d;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        int to(int u) {
            return (u == this.u) ? v : this.u;
        }
    }

    private ArrayList<Edge>[] edges;

    private void solve() throws IOException {
        int c = nextInt();
        int d = nextInt();

        edges = new ArrayList[c];
        for (int i = 0; i < c; i++) {
            edges[i] = new ArrayList<>();
        }

        ArrayList<Vertex> dist = new ArrayList<>();
        ArrayList<Vertex> before = new ArrayList<>();
        Vertex[] vert = new Vertex[c];
        vert[0] = new Vertex(0);
        vert[0].dist = 0;

        for (int i = 1; i < c; i++) {
            vert[i] = new Vertex(i);
            int x = nextInt();
            if (x < 0) {
                vert[i].b = -x;
                before.add(vert[i]);
            }
        }

        Collections.sort(dist);
        Collections.sort(before);

        Edge[] edgesById = new Edge[d];
        for (int i = 0; i < d; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            Edge edge = new Edge(u, v);
            edgesById[i] = edge;
            edges[u].add(edge);
            edges[v].add(edge);
        }

        int l = 0;
        while (l < before.size()) {
            int r = l + 1;
            while (r < before.size() && before.get(l).b == before.get(r).b) {
                r++;
            }
            int max = 0;
            for (int i = l; i < r; i++) {
                int u = before.get(i).id;
                for (Edge e : edges[u]) {
                    max = Math.max(max, vert[e.to(u)].dist);
                }
            }
            max++;

            for (int i = l; i < r; i++) {
                int u = before.get(i).id;
                vert[u].dist = max;
            }
            for (int i = l; i < r; i++) {
                int u = before.get(i).id;
                for (Edge e : edges[u]) {
                    int v = e.to(u);
                    if (vert[v].dist != -1) {
                        e.d = Math.max(vert[u].dist - vert[v].dist, 1);
                    }
                }
            }
            l = r;
        }

        for (int i = 0; i < d; i++) {
            if (i != 0) {
                out.print(" ");
            }
            out.print(edgesById[i].d);
        }
        out.println();
    }

    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}