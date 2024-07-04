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
  static PriorityQueue<State> numBeforePQ, costPQ;
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

      dist = new int[C];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[0] = 0;

      costs = new int[D];
      Arrays.fill(costs, (int)1e6);

      numBeforePQ = new PriorityQueue<>();
      costPQ = new PriorityQueue<>();

      for (int i = 0; i < C; i++) {
        adj.add(new ArrayList<>());
      }

      for (int i = 1; i < C; i++) {
        int val = readInt();
        if (val < 0) {
          numBeforePQ.offer(new State(i, -val));
        } else {
          costPQ.offer(new State(i, val));
        }
      }

      for (int i = 0; i < D; i++) {
        int u = readInt() - 1;
        int v = readInt() - 1;
        adj.get(u).add(new Edge(v, i));
        adj.get(v).add(new Edge(u, i));
      }

      int nodesFixed = 1;
      int prevMax = 0;
      while (!numBeforePQ.isEmpty()) {
        State numBeforeNode = numBeforePQ.poll();
        while (nodesFixed != numBeforeNode.val) {
          State costNode = costPQ.poll();
          fixCostNode(costNode.index, costNode.val);
          prevMax = Math.max(prevMax,  dist[costNode.index]);
          nodesFixed++;
        }

        int nextMax = prevMax;
        fixNumBeforeNode(numBeforeNode.index, prevMax);
        nextMax = Math.max(nextMax, dist[numBeforeNode.index]);
        nodesFixed++;
        while (!numBeforePQ.isEmpty() && numBeforePQ.peek().val == numBeforeNode.val) {
          numBeforeNode = numBeforePQ.poll();
          fixNumBeforeNode(numBeforeNode.index, prevMax);
          nextMax = Math.max(nextMax, dist[numBeforeNode.index]);
          nodesFixed++;
        }
        prevMax = nextMax;
      }

      while (!costPQ.isEmpty()) {
        State costNode = costPQ.poll();
        fixCostNode(costNode.index, costNode.val);
        nodesFixed++;
      }

      out.printf("Case #%d:", t);
      for (int i = 0; i < D; i++) {
        out.print(" " + costs[i]);
      }
      out.println();
    }

    out.close();
  }

  static void fixCostNode(int index, int currDist) {
    Edge minEdge = null;
    for (Edge edge : adj.get(index)) {
      if (minEdge == null || (dist[minEdge.dest] > dist[edge.dest])) {
        minEdge = edge;
      }
    }
    dist[index] = currDist;
    costs[minEdge.index] = currDist - dist[minEdge.dest];
  }

  static void fixNumBeforeNode(int index, int prevMax) {
    Edge minEdge = null;
    for (Edge edge : adj.get(index)) {
      if (minEdge == null || (dist[minEdge.dest] > dist[edge.dest])) {
        minEdge = edge;
      }
    }
    dist[index] = prevMax + 1;
    costs[minEdge.index] = prevMax + 1 - dist[minEdge.dest];
  }

  static class State implements Comparable<State> {
    int index, val;
    State(int index, int val) {
      this.index = index;
      this.val = val;
    }

    public int compareTo(State s) {
      return val - s.val;
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
