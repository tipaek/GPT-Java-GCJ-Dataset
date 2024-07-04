import java.io.*;
import java.util.*;

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
            if (d == -1) {
                return b - v.b;
            } else {
                return d - v.d;
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
            return this.u == u ? v : this.u;
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

        ArrayList<Vertex> distList = new ArrayList<>();
        ArrayList<Vertex> beforeList = new ArrayList<>();
        Vertex[] vertices = new Vertex[c];
        vertices[0] = new Vertex(0);
        vertices[0].dist = 0;

        for (int i = 1; i < c; i++) {
            vertices[i] = new Vertex(i);
            int x = nextInt();
            if (x < 0) {
                vertices[i].b = -x;
                beforeList.add(vertices[i]);
            } else {
                vertices[i].d = x;
                distList.add(vertices[i]);
            }
        }

        Collections.sort(distList);
        Collections.sort(beforeList);

        Edge[] edgesById = new Edge[d];
        for (int i = 0; i < d; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            Edge edge = new Edge(u, v);
            edgesById[i] = edge;
            edges[u].add(edge);
            edges[v].add(edge);
        }

        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(vertices[0]);

        int l = 0, r = 0, maxDist = 0, distIndex = 0;
        while (l < beforeList.size()) {
            r = l + 1;
            while (r < beforeList.size() && beforeList.get(l).b == beforeList.get(r).b) {
                r++;
            }

            for (int i = l; i < r; i++) {
                int u = beforeList.get(i).id;
                for (Edge e : edges[u]) {
                    maxDist = Math.max(maxDist, vertices[e.to(u)].dist);
                }
                visitedVertices.add(beforeList.get(i));
            }
            maxDist++;

            for (int i = l; i < r; i++) {
                int u = beforeList.get(i).id;
                vertices[u].dist = maxDist;
            }
            for (int i = l; i < r; i++) {
                int u = beforeList.get(i).id;
                for (Edge e : edges[u]) {
                    int v = e.to(u);
                    if (vertices[v].dist == -1) continue;
                    if (vertices[v].dist == vertices[u].dist) {
                        e.d = 1;
                    } else {
                        e.d = vertices[u].dist - vertices[v].dist;
                    }
                }
            }

            while (distIndex < distList.size() && 
                   (r == beforeList.size() || visitedVertices.size() < beforeList.get(r).b)) {
                Vertex u = distList.get(distIndex++);
                u.dist = u.d;

                for (Edge e : edges[u.id]) {
                    int v = e.to(u.id);
                    if (vertices[v].dist == -1) continue;
                    e.d = Math.max(vertices[u.id].dist - vertices[v].dist, 1);
                }
                visitedVertices.add(u);
                maxDist = Math.max(maxDist, u.dist + 1);
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