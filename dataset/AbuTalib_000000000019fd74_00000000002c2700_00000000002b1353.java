import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
  int r, c;
  long val;

  public Node(int row, int col, long value) {
    r = row;
    c = col;
    val = value;

  }

  public int compareTo(Node o) {
    return Long.compare(val, o.val);
  }
}

class Solution {

  public static ArrayList<Node> al = new ArrayList<>();

  public static void main(final String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();// in.nextInt();
    final int MAGIC_NUMBER = 32;
    long[][] triangle = new long[MAGIC_NUMBER][MAGIC_NUMBER];
    boolean[][] visited = new boolean[MAGIC_NUMBER][MAGIC_NUMBER];
    triangle[0][0] = 1;
    for (int i = 0; i < triangle.length; i++) {
      for (int j = 0; j < triangle[0].length; j++) {
        if (j == 0) {
          triangle[i][j] = 1;
        } else if (j > i) {
          break;
        } else {
          triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
        }
      }
    }
    // long[] sums = new long[triangle.length];
    // for (int i = 0; i < triangle.length; i++) {
    //   sums[i] = (int) Math.pow(2, i) + i;
    // }
    // System.out.println(Arrays.toString(sums));

    // for (long[] arr : triangle) {
    // System.out.println(Arrays.toString(arr));
    // }
    for (int i = 1; i <= rr; i++) {
      System.out.printf("Case #%d:%n", i);
      // if 1 <= n <= 500
      int hmm = in.nextInt();
      al = new ArrayList<>();
      visited = new boolean[MAGIC_NUMBER][MAGIC_NUMBER];
      al = func500(triangle, visited, al, 1, 1, hmm);
      for (Node n : al) {
        System.out.println((n.r+1) + " " + (n.c+1));
      }

    }
  }

  public static ArrayList<Node> func500(long[][] tri, boolean[][] vis, ArrayList<Node> all, int r, int c, long leftover) {
    if (leftover < 0)
      return null;
    int[] d_r = { -1, -1, 0, 0, 1, 1 };
    int[] d_c = { -1, 0, -1, 1, 1, 0 };
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 0; i < d_r.length; i++) {
      int new_r = r + d_r[i];
      int new_c = c + d_c[i];
      if (new_r < 0 || new_c < 0 || new_r >= tri.length || new_c >= tri[0].length || vis[new_r][new_c] || tri[new_r][new_c]==0) {
        continue;
      }
      Node n = new Node(new_r, new_c, tri[new_r][new_c]);
      pq.add(n);
    }
    while (!pq.isEmpty()) {
      Node pos = pq.poll();
      if (leftover - pos.val < 0)
        continue;
      else if (leftover - pos.val ==0 ){
        al.add(pos);
        return al;
      }
      al.add(pos);
      vis[pos.r][pos.c]=true;
      ArrayList<Node> temp = func500(tri, vis, all, pos.r, pos.c, leftover - pos.val);
      if (temp != null)
        return temp;
    }

    return null;
  }

}