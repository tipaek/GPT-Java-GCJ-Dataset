/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      int n = Integer.parseInt(br.readLine());
      Node[] nodes = new Node[n];
      Pair[] pairs = new Pair[n];
      for (int i=0; i<n; i++) {
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        pairs[i] = new Pair(start,end);
        nodes[i] = new Node(i);
      }
      for (int i=0; i<n; i++) {
        for (int j=i+1; j<n; j++) {
          if (overlap(pairs[i], pairs[j])) {
            nodes[i].adj.add(j);
            nodes[j].adj.add(i);
          }
        }
      }
      boolean possible = true;
      int[] colour = new int[n];
      for (int i=0; i<n; i++) {
        if (colour[i]==0) {
          possible = possible && dfs(i, nodes, colour);
        }
      }
      if (!possible) {
        sb.append(String.format("Case #%d: IMPOSSIBLE\n", test+1));
      } else {
        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<n; i++) {
          sb2.append(colour[i]==1 ? 'J' : 'C');
        }
        sb.append(String.format("Case #%d: %s\n", test+1, sb2.toString()));
      }
    }
    System.out.print(sb);
  }
  static boolean dfs(int curr, Node[] nodes, int[] colour) {
    int coloured = 0;
    for (int nbr: nodes[curr].adj) {
      coloured |= colour[nbr];
    }
    if (coloured==0 || coloured==2) {
      colour[curr] = 1;
    } else if (coloured==1) {
      colour[curr] = 2;
    } else {
      colour[curr] = 3;
      return false;
    }
    boolean possible = true;
    for (int nbr: nodes[curr].adj) {
      if (colour[nbr]==0) {
        possible = possible && dfs(nbr, nodes, colour);
      }
    }
    return possible;
  }
  static boolean overlap(Pair p1, Pair p2) {
    if (p1.b<=p2.a || p1.a>=p2.b)
      return false;
    return true;
  }
}
class Node {
  int id;
  ArrayList<Integer> adj = new ArrayList<Integer>();
  public Node(int idd) {
    id = idd;
  }
}
class Pair {
  int a,b;
  public Pair(int aa, int bb) {
    a = aa;
    b = bb;
  }
}
