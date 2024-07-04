import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  private static final char CAMERON = 'C';

  private static final char JAMIE = 'J';

  private static final String IMPOSSIBLE = "IMPOSSIBLE";

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Number of test cases
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      // Number of activities
      int n = in.nextInt();
      List<Node> graphNodes = new ArrayList<>(n);
      int[][] activityTimes = new int[n][2];
      activityTimes[0][0] = in.nextInt();
      activityTimes[0][1] = in.nextInt();
      graphNodes.add(new Node());
      for (int j = 1; j < n; j++) {
        int s = in.nextInt();
        int e = in.nextInt();
        activityTimes[j][0] = s;
        activityTimes[j][1] = e;
        Node node = new Node();
        graphNodes.add(node);
        for (int k = 0; k < j; k++) {
          int ts = activityTimes[k][0];
          int te = activityTimes[k][1];
          if (!((s < ts && e <= ts) || (s >= te && e >= te))) {
            graphNodes.get(k).addEdge(node);
          }
        }
      }

      int visitedNodeCount = 0;
      Set<Node> nodesCameronCannotVisit = new HashSet<>();
      for (Node node : graphNodes) {
        if (!nodesCameronCannotVisit.contains(node)) {
          node.parent = CAMERON;
          node.visited = true;
          visitedNodeCount++;
          nodesCameronCannotVisit.addAll(node.neighbours);
        }
      }

      Set<Node> nodesJaimeCannotVisit = new HashSet<>();
      for (Node node : nodesCameronCannotVisit) {
        if (!nodesJaimeCannotVisit.contains(node)) {
          node.parent = JAMIE;
          node.visited = true;
          visitedNodeCount++;
          nodesJaimeCannotVisit.addAll(node.neighbours);
        }
      }

      StringBuilder result = new StringBuilder();
      if (visitedNodeCount != n) {
        result.append(IMPOSSIBLE);
      } else {
        for (Node node : graphNodes) {
          result.append(node.parent);
        }
      }

      System.out.println("Case #" + i + ": " + result.toString());
    }
  }
}

class Node {

  char parent;
  boolean visited;
  Set<Node> neighbours;

  Node() {
    neighbours = new HashSet<>();
    visited = false;
  }

  void addEdge(Node n) {
    this.neighbours.add(n);
    n.neighbours.add(this);
  }
}
