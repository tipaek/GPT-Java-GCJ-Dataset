import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by vaksenov on 04.04.2020.
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public class Vertex implements Comparable<Vertex> {
        int d = -1;
        int b = -1;
        int id;
        int dist = -1;

        public Vertex(int id) {
            this.id = id;
        }

        public int compareTo(Vertex v) {
            if (d == -1) {
                return b - v.b;
            } else {
                return d - v.d;
            }
        }
    }

    public class Edge {
        int u, v;
        int d;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        public int to(int u) {
            if (u == this.u)
                return v;
            else
                return this.u;
        }
    }

    ArrayList<Edge>[] edges;

    public void solve() throws IOException {
        int c = nextInt();
        int d = nextInt();

        edges = new ArrayList[c];
        for (int i = 0; i < edges.length; i++) {
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
                vert[i].b = -x - 1;
                before.add(vert[i]);
            } else {
                vert[i].d = x;
                dist.add(vert[i]);
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
        int r = 0;
        while (l < before.size()) {
            r = l + 1;
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
                    if (vert[v].dist == -1)
                        continue;
                    if (vert[v].dist == vert[u].dist) {
                        e.d = 1;
                    } else {
                        e.d = vert[u].dist - vert[v].dist;
                    }
                }
            }
            l = r;
        }

        for (Edge e : edgesById) {
            out.print(e.d + " ");
        }
        out.println();
    }

    public void run() {
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
