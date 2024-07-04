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

    private BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;
    private PrintWriter printWriter;

    private String getNextToken() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    private int getNextInt() throws IOException {
        return Integer.parseInt(getNextToken());
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
            return (d == -1) ? Integer.compare(b, other.b) : Integer.compare(d, other.d);
        }
    }

    private class Edge {
        int u, v;
        int d;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        int otherEnd(int node) {
            return (node == this.u) ? v : this.u;
        }
    }

    private ArrayList<Edge>[] edges;

    private void solve() throws IOException {
        int c = getNextInt();
        int d = getNextInt();

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
            int x = getNextInt();
            if (x < 0) {
                vertices[i].b = -x - 1;
                beforeVertices.add(vertices[i]);
            } else {
                vertices[i].d = x;
                distVertices.add(vertices[i]);
            }
        }

        Collections.sort(distVertices);
        Collections.sort(beforeVertices);

        Edge[] edgeList = new Edge[d];
        for (int i = 0; i < d; i++) {
            int u = getNextInt() - 1;
            int v = getNextInt() - 1;
            Edge edge = new Edge(u, v);
            edgeList[i] = edge;
            edges[u].add(edge);
            edges[v].add(edge);
        }

        int l = 0;
        while (l < beforeVertices.size()) {
            int r = l + 1;
            while (r < beforeVertices.size() && beforeVertices.get(l).b == beforeVertices.get(r).b) {
                r++;
            }

            int maxDist = 0;
            for (int i = l; i < r; i++) {
                int u = beforeVertices.get(i).id;
                for (Edge e : edges[u]) {
                    maxDist = Math.max(maxDist, vertices[e.otherEnd(u)].dist);
                }
            }
            maxDist++;

            for (int i = l; i < r; i++) {
                int u = beforeVertices.get(i).id;
                vertices[u].dist = maxDist;
            }

            for (int i = l; i < r; i++) {
                int u = beforeVertices.get(i).id;
                for (Edge e : edges[u]) {
                    int v = e.otherEnd(u);
                    if (vertices[v].dist == -1) continue;
                    e.d = (vertices[v].dist == vertices[u].dist) ? 1 : vertices[u].dist - vertices[v].dist;
                }
            }
            l = r;
        }

        for (Edge e : edgeList) {
            printWriter.print(e.d + " ");
        }
        printWriter.println();
    }

    private void execute() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(System.out);

            int t = getNextInt();
            for (int i = 0; i < t; i++) {
                printWriter.printf("Case #%d: ", i + 1);
                solve();
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}