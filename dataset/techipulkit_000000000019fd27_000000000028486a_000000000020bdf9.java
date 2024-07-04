  import java.util.*;
    import java.io.*;
    public class Solution {
    
    static class Node implements Comparable<Node> {
    int i;
    int s;
    int e;

    public Node(int i, int s, int e) {
      this.i = i;
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
        arr[j] = new Node(j, s, e);
      }
      Arrays.sort(arr);
      int cEnd = 0, JEnd = 0;
      boolean isPossible = true;
      char[] output = new char[size];
      for (int j = 0; j < size; j++) {
        Node node = arr[j];
        if (Math.min(cEnd, JEnd) > node.s) {
          isPossible = false;
          break;
        }
        if (cEnd <= node.s) {
          output[node.i] = 'C';
          cEnd = node.e;
        } else {
          output[node.i] = 'J';
          JEnd = node.e;
        }
      }
      if (isPossible) {
        System.out.println("Case #" + i + ": " + String.copyValueOf(output));
      } else {
        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
    }
  }
  
  
    }