import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
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
        public int compareTo(Vertex other) {
            if (d == -1) {
                return b - other.b;
            } else {
                return d - other.d;
            }
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

        ArrayList<Vertex> distVertices = new ArrayList<>();
        ArrayList<Vertex> beforeVertices = new ArrayList<>();
        Vertex[] vertices = new Vertex[c];
        vertices[0] = new Vertex(0);
        vertices[0].dist = 0;

        for (int i = 1; i < c; i++) {
            vertices[i] = new Vertex(i);
            int x = nextInt();
            if (x < 0) {
                vertices[i].b = -x;
                beforeVertices.add(vertices[i]);
            } else {
                vertices[i].d = x;
                distVertices.add(vertices[i]);
            }
        }

        Collections.sort(distVertices);
        Collections.sort(beforeVertices);

        Edge[] edgesById = new Edge[d];
        for (int i = 0; i < d; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            Edge edge = new Edge(u, v);
            edgesById[i] = edge;
            edges[u].add(edge);
            edges[v].add(edge);
        }

        ArrayList<Vertex> processedVertices = new ArrayList<>();
        processedVertices.add(vertices[0]);

        int l = 0, r = 0, maxDist = 0, distIndex = 0;

        while (l < beforeVertices.size()) {
            r = l + 1;
            while (r < beforeVertices.size() && beforeVertices.get(l).b == beforeVertices.get(r).b) {
                r++;
            }

            for (int i = l; i < r; i++) {
                int u = beforeVertices.get(i).id;
                for (Edge e : edges[u]) {
                    maxDist = Math.max(maxDist, vertices[e.to(u)].dist);
                }
                processedVertices.add(beforeVertices.get(i));
            }

            maxDist++;
            for (int i = l; i < r; i++) {
                int u = beforeVertices.get(i).id;
                vertices[u].dist = maxDist;
            }

            for (int i = l; i < r; i++) {
                int u = beforeVertices.get(i).id;
                for (Edge e : edges[u]) {
                    int v = e.to(u);
                    if (vertices[v].dist == -1) continue;
                    e.d = vertices[u].dist == vertices[v].dist ? 1 : vertices[u].dist - vertices[v].dist;
                }
            }

            while (distIndex < distVertices.size() &&
                    (r == beforeVertices.size() || processedVertices.size() < beforeVertices.get(r).b)) {
                Vertex u = distVertices.get(distIndex++);
                u.dist = u.d;

                for (Edge e : edges[u.id]) {
                    int v = e.to(u.id);
                    if (vertices[v].dist == -1) continue;
                    e.d = Math.max(vertices[u.id].dist - vertices[v].dist, 1);
                }
                processedVertices.add(u);
                maxDist = Math.max(maxDist, u.dist + 1);
            }

            l = r;
        }

        for (Edge e : edgesById) {
            out.print(e.d + " ");
        }
        out.println();
    }

    private void execute() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.printf("Case #%d: ", i + 1);
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}