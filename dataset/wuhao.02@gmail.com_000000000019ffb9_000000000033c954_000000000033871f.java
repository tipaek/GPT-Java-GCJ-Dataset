

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 5/16/20.
 */
public class Solution {

  static class Node {
    int index;
    List<Integer> adj;
    int time;
    int prev;
    Node(int index) {
      this.index = index;
      this.adj = new ArrayList<>();
      time = -1;
      prev = -1;
    }

    void add(int other) {
      adj.add(other);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      String[] tokens = getTokens(reader);
      int C = Integer.parseInt(tokens[0]);
      int D = Integer.parseInt(tokens[1]);

      Set<Integer> v = new HashSet<>();
      Node[] nodes = new Node[C];
      int[] ct = new int[C];
      ct[0] = 0;
      int[] x = new int[D];
      int[] y = new int[D];
      int maxint = 99999;

      tokens = getTokens(reader);
      nodes[0] = new Node(0);
      for (int i = 1; i < C; i++) {
        ct[i] = Integer.parseInt(tokens[i-1]);
        nodes[i] = new Node(i);
      }

      for (int i = 0; i<D; i++) {
        tokens = getTokens(reader);
        x[i] = Integer.parseInt(tokens[0]);
        y[i] = Integer.parseInt(tokens[1]);
        nodes[x[i]-1].add(y[i]-1);
        nodes[y[i]-1].add(x[i]-1);
      }

      int[] val = new int[C*C];

      List<Node> q = new ArrayList<>();
      int f = -1;
      q.add(nodes[0]);
      nodes[0].time = 0;
      v.add(0);
      int curr = 1;
      int count = 0;
      int inc = 0;
      while (f < q.size() - 1) {
        f++;
        boolean all = true;
        Node node = q.get(f);
        for (int i = 0; i < node.adj.size(); i++) {
          if (!v.contains(node.adj.get(i))) {
            int proposed = node.time + val[getIndex(node.index, node.adj.get(i), C)] + 1;
            if (proposed != curr) {
              count = 0;
              curr = proposed;
            }
            if (-ct[node.adj.get(i)] == v.size() - count) {
              q.add(nodes[node.adj.get(i)]);
              v.add(node.adj.get(i));
              nodes[node.adj.get(i)].time = proposed;
              nodes[node.adj.get(i)].prev = node.index;
              count++;
            } else {
              all = false;
            }
            val[getIndex(node.index, node.adj.get(i), C)] += 1;
          } else {
            if (nodes[node.adj.get(i)].prev!=node.index && node.prev != node.adj.get(i)) {
              val[getIndex(node.index, node.adj.get(i), C)] += 1;
            }
          }
        }
        if (!all) {
          q.add(q.get(f));
        }
      }


      System.out.print("Case #" + t + ": ");
      for (int i = 0; i<D; i++) {
        System.out.print(val[getIndex(x[i]-1,y[i]-1, C)] + " ");
      }
      System.out.println();
    }
  }

  private static int getIndex(int x, int y, int C) {
    if (x < y) {
      return x*C + y;
    } else {
      return y*C + x;
    }

  }

  private static String[] getTokens(BufferedReader reader) throws IOException {
    return reader.readLine().trim().split(" ");
  }

  private static int getInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine().trim());
  }
}
