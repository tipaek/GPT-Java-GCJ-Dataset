import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  static class Node {
    int i;
    int before;
    int distToSrc = -1;
    ArrayList<Edge> edges = new ArrayList<>();
  }

  static class Edge {
    int idx;
    Node to;

    Edge(int idx, Node to) {
      this.idx = idx;
      this.to = to;
    }
  }

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in);

    int T = io.getInt();

    for (int tc = 0; tc < T; tc++) {
      int C = io.getInt();
      int D = io.getInt();

      Node[] nodes = new Node[C];

      for (int i = 0; i < C; i++) {
        Node node = new Node();
        node.i = i;
        nodes[i] = node;
      }

      nodes[0].distToSrc = 0;

      boolean cannotSolve = false;

      for (int i = 1; i < C; i++) {
        int x = io.getInt();
        if (x > 0) cannotSolve = true;

        nodes[i].before = -x;
      }

      int[] edgeWeights = new int[D];

      for (int i = 0; i < D; i++) {
        int u = io.getInt()-1;
        int v = io.getInt()-1;

        edgeWeights[i] = -1;

        nodes[u].edges.add(new Edge(i, nodes[v]));
        nodes[v].edges.add(new Edge(i, nodes[u]));
      }

      if (!cannotSolve) {
        Arrays.sort(nodes, Comparator.comparingInt(n -> n.before));

        ArrayList<ArrayList<Node>> nodeGroups = new ArrayList<>();
        int lastVal = -1;
        for (int i = 0; i < C; i++) {
          Node n = nodes[i];
          if (n.i == 0) continue;

          if (n.before > lastVal) {
            lastVal = n.before;
            nodeGroups.add(new ArrayList<>());
          }
          nodeGroups.get(nodeGroups.size() - 1).add(n);
        }

        int maxDist = 0;
        for (ArrayList<Node> group : nodeGroups) {
          for (Node n : group) {
            int bestEdgeDist = 10000000;
            for (Edge e : n.edges) {
              int d = e.to.distToSrc;
              if (d != -1 && d < bestEdgeDist) {
                bestEdgeDist = d;
              }
            }
            if (bestEdgeDist > maxDist) {
              maxDist = bestEdgeDist;
            }
          }
          maxDist++;
          for (Node n : group) {
            int bestEdgeDist = 10000000;
            Edge bestEdge = null;
            for (Edge e : n.edges) {
              int d = e.to.distToSrc;
              if (d != -1 && d < bestEdgeDist) {
                bestEdgeDist = d;
                bestEdge = e;
              }
            }
            edgeWeights[bestEdge.idx] = maxDist - bestEdgeDist;
            n.distToSrc = maxDist;
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      sb.append("Case #").append(tc+1).append(':');
      for (int i = 0; i < D; i++) {
        sb.append(' ').append(edgeWeights[i] != -1 ? edgeWeights[i] : 1000000);
      }
      io.println(sb.toString());
    }

    io.close();
  }

}

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }
  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() {
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }



  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null) return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) { }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}
