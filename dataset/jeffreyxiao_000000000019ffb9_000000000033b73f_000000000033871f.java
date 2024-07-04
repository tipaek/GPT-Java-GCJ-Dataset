import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int T;
  static int C, D;
  static ArrayList<ArrayList<Edge>> adj;
  static State[] states;
  static int[] numBefore;
  static int[] dist;
  static int[] costs;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    // br = new BufferedReader(new FileReader("in.txt"));
    // out = new PrintWriter(new FileWriter("out.txt"));

    T = readInt();
    for (int t = 1; t <= T; t++) {
      C = readInt();
      D = readInt();

      adj = new ArrayList<>();
      costs = new int[D];
      Arrays.fill(costs, (int)1e6);

      for (int i = 0; i < C; i++) {
        adj.add(new ArrayList<>());
      }

      states = new State[C - 1];
      numBefore = new int[C];
      numBefore[0] = 0;
      for (int i = 1; i < C; i++) {
        numBefore[i] = -readInt();
        states[i - 1] = new State(i, numBefore[i]);
      }

      for (int i = 0; i < D; i++) {
        int u = readInt() - 1;
        int v = readInt() - 1;
        adj.get(u).add(new Edge(v, i));
        adj.get(v).add(new Edge(u, i));
      }

      Arrays.sort(states);
      for (int i = 0; i < C - 1; i++) {
        int curr = states[i].index;
        Edge minEdge = null;
        for (Edge edge : adj.get(curr)) {
          if (minEdge == null || (numBefore[minEdge.dest] > numBefore[edge.dest])) {
            minEdge = edge;
          }
        }
        costs[minEdge.index] = numBefore[curr] - numBefore[minEdge.dest];
      }

      out.printf("Case #%d:", t);
      for (int i = 0; i < D; i++) {
        out.print(" " + costs[i]);
      }
      out.println();
    }

    out.close();
  }

  static class State implements Comparable<State> {
    int index, numBefore;
    State(int index, int numBefore) {
      this.index = index;
      this.numBefore = numBefore;
    }

    public int compareTo(State s) {
      return numBefore - s.numBefore;
    }
  }

  static class Edge {
    int dest, index;
    Edge(int dest, int index) {
      this.dest = dest;
      this.index = index;
    }
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char readCharacter() throws IOException {
    return next().charAt(0);
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}
