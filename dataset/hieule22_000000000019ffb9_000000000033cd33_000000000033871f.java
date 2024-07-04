import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Hieu Le
 */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    SecurityUpdate solver = new SecurityUpdate();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class SecurityUpdate {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int numNodes = in.nextInt();
      int numEdges = in.nextInt();

      Node[] nodes = new Node[numNodes];
      nodes[0] = new Node();
      for (int i = 1; i < numNodes; ++i) {
        nodes[i] = new Node();
        int x = in.nextInt();
        if (x < 0) {
          nodes[i].rank = -x;
        } else {
          nodes[i].latency = x;
        }
      }

      for (int i = 0; i < numEdges; ++i) {
        Node u = nodes[in.nextInt() - 1];
        Node v = nodes[in.nextInt() - 1];
        u.edges.add(new Edge(v, i));
        v.edges.add(new Edge(u, i));
      }

      int[] weights = new int[numEdges];

      List<Node> frontier = new ArrayList<>();
      frontier.add(nodes[0]);
      nodes[0].seen = true;

      for (int rank = 1; rank <= 1000; ++rank) {
        List<Node> choices = new ArrayList<>();
        for (Node node : frontier) {
          for (Edge edge : node.edges) {
            Node adj = edge.adj;
            if (!adj.seen && (adj.rank == rank || adj.latency == rank)) {
              adj.seen = true;
              adj.rank = adj.latency = rank;
              weights[edge.index] = adj.rank - node.rank;
              choices.add(adj);
            }
          }
        }

        frontier = choices;
      }

      out.printf("Case #%d:", testNumber);
      for (int i = 0; i < numEdges; ++i) {
        out.printf(" %d", weights[i] > 0 ? weights[i] : 1000000);
      }
      out.println();
    }

    private class Edge {
      Node adj;
      int index;

      Edge(Node adj, int index) {
        this.adj = adj;
        this.index = index;
      }
    }

    private class Node {
      List<Edge> edges = new ArrayList<>();
      int rank;
      int latency;
      boolean seen = false;
    }
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private static final int BUFFER_SIZE = 32768;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
