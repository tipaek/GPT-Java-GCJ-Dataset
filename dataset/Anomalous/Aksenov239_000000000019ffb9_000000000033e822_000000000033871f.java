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
        int d = -1;
        int b = -1;
        int id;
        int dist = -1;

        Vertex(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Vertex v) {
            return d == -1 ? b - v.b : d - v.d;
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
            return u == this.u ? v : this.u;
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

        ArrayList<Vertex> vertices = new ArrayList<>();
        vertices.add(vert[0]);

        int l = 0;
        int r = 0;
        int max = 0;
        int D = 0;

        while (l < before.size()) {
            r = l + 1;
            while (r < before.size() && before.get(l).b == before.get(r).b) {
                r++;
            }

            for (int i = l; i < r; i++) {
                int u = before.get(i).id;
                for (Edge e : edges[u]) {
                    max = Math.max(max, vert[e.to(u)].dist);
                }
                vertices.add(before.get(i));
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
                    if (vert[v].dist == -1) continue;
                    e.d = vert[v].dist == vert[u].dist ? 1 : vert[u].dist - vert[v].dist;
                }
            }

            while (D < dist.size() && (r == before.size() || vertices.size() < before.get(r).b)) {
                Vertex u = dist.get(D++);
                u.dist = u.d;

                for (Edge e : edges[u.id]) {
                    int v = e.to(u.id);
                    if (vert[v].dist == -1) continue;
                    e.d = Math.max(vert[u.id].dist - vert[v].dist, 1);
                }
                vertices.add(u);
                max = Math.max(max, u.dist + 1);
            }
            l = r;
        }

        for (Edge e : edgesById) {
            out.print(e.d + " ");
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