import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= tc; t++) {
      int n = in.nextInt();
      int[][] grid = new int[n][2];
      for (int i = 0; i < n; i++) {
        grid[i][0] = in.nextInt();
        grid[i][1] = in.nextInt();
      }
      solve(t, grid);
    }
  }

  static class Node {

    int start;
    int finish;
    Node next;

    Node(int start, int finish) {
      this.start = start;
      this.finish = finish;
    }
  }

  static class Status {

    boolean added;
    Node root;

    Status(boolean added, Node root) {
      this.added = added;
      this.root = root;
    }
  }

  private static Status insertNode(Node root, int start, int finish) {
    if (root == null) {
      root = new Node(start, finish);
      return new Status(true, root);
    }
    if (finish <= root.start) {
      Node n = new Node(start, finish);
      n.next = root;
      return new Status(true, n);
    }
    Node n = root;
    while (n.next != null) {
      if (n.finish <= start && n.next.start >= finish) {
        Node tmp = n.next;
        n.next = new Node(start, finish);
        n.next.next = tmp;
        return new Status(true, root);
      }
      n = n.next;
    }
    if (n.finish <= start) {
      n.next = new Node(start, finish);
      return new Status(true, root);
    }
    return new Status(false, root);
  }

  private static void solve(int t, int[][] grid) {
    StringBuffer sb = new StringBuffer();
    Node cRoot = null, jRoot = null;
    for (int i = 0; i < grid.length; i++) {
      Status s = insertNode(cRoot, grid[i][0], grid[i][1]);
      if(s.added) {
        sb.append("C");
        cRoot = s.root;
      } else {
        s = insertNode(jRoot, grid[i][0], grid[i][1]);
        if(s.added) {
          sb.append("J");
          jRoot = s.root;
        } else {
          System.out.println(String.format("Case #%s: %s", t, "IMPOSSIBLE"));
          return;
        }
      }
    }
    System.out.println(String.format("Case #%s: %s", t, sb.toString()));
  }
}