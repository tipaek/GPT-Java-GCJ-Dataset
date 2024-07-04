  import java.util.*;
    import java.io.*;
    public class Solution {
    
    static class Node implements Comparable<Node> {
    int s;
    int e;

    public Node(int s, int e) {
      this.s = s;
      this.e = e;
    }

    @Override
    public int compareTo(Node o) {
      return this.s - o.s;
    }

  }
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int size = in.nextInt();
      Node[] arr = new Node[size];
      for (int j = 0; j < size; j++) {
        int s = in.nextInt();
        int e = in.nextInt();
        arr[j] = new Node(s, e);
      }
      Arrays.sort(arr);
      int cEnd = 0, JEnd = 0;
      boolean isPossible = true;
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < size; j++) {
        Node node = arr[j];
        if (Math.min(cEnd, JEnd) > node.s) {
          isPossible = false;
          break;
        }
        if (cEnd <= node.s) {
          sb.append("C");
          cEnd = node.e;
        } else {
          sb.append("J");
          JEnd = node.e;
        }
      }
      if (isPossible) {
        System.out.println("Case #" + i + ": " + sb.toString());
      } else {
        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
    }
      }
    }