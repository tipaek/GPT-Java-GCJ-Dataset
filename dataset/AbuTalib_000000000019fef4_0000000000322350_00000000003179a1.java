import java.util.*;
import java.io.*;

class Solution {
  public static class Node implements Comparable<Node> {
    char ch;
    int fl;

    public Node(char ch, int fl) {
      this.ch = ch;
      this.fl = fl;
    }

    public int compareTo(Node l) {
      if (fl < l.fl) {
        return -1;
      } else if (fl == l.fl) {
        return 0;
      }
      return 1;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    for (int t = 1; t <= rr; t++) {
      int U = in.nextInt();
      int[] frequency = new int[26];
      for (int i = 0; i < 10000; i++) {
        long num = in.nextLong();
        char[] R = in.next().toCharArray();
        in.nextLine();
        for (char ch : R) {
          frequency[ch - 'A']++;
        }
      }
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      for (int i = 0; i < 26; i++)
        if (frequency[i] != 0)
          pq.add(new Node((char) ('A' + i), frequency[i]));
      StringBuilder ans = new StringBuilder("");
      for (int i = 0; i < 9; i++)
        ans.append(pq.poll().ch);
      System.out.print("Case #" + t + ": " + pq.poll().ch + ans.toString());
    }
  }
}
