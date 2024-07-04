import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String args[]) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int N = input.nextInt();
      System.out.println("Case #" + ks + ": " + parentingPartnering(N, input));
    }
  }

  static class Node {

    int val;
    boolean start;
    int id;

    public Node(int val, boolean start, int id) {
      this.val = val;
      this.start = start;
      this.id = id;
    }
  }

  private static String parentingPartnering(int n, Scanner input) {
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Node start = new Node(input.nextInt(), true, i);
      Node end = new Node(input.nextInt(), false, i);
      nodes.add(start);
      nodes.add(end);
    }

    Collections.sort(nodes, (o1, o2) -> {
      if (o1.val == o2.val) {
        if (!o1.start) {
          return -1;
        } else {
          return 1;
        }
      }
      return o1.val - o2.val;
    });

    char[] result = new char[n];

    int c = -1;
    int j = -1;
    int i = 0;

    for (; i < 2 * n; i++) {
      Node node = nodes.get(i);
      if (node.start) {
        if (c == -1) {
          c = node.id;
          result[node.id] = 'C';
        } else if (j == -1) {
          j = node.id;
          result[node.id] = 'J';
        } else {
          break;
        }
      } else {
        if (c == node.id) {
          c = -1;
        } else {
          j = -1;
        }
      }
    }

    if (i == 2 * n) {
      return new String(result);
    } else {
      return "IMPOSSIBLE";
    }
  }
}