import java.util.*;
import java.io.*;

class Solution {
  public static class Node implements Comparable<Node> {
    char ch;
    long fl;

    public Node(char ch, long fl) {
      this.ch = ch;
      this.fl = fl;
    }

    public int compareTo(Node l) {
      if (fl < l.fl) {
        return 1;
      } else if (fl == l.fl) {
        return 0;
      }
      return -1;
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //in = new Scanner(new BufferedReader(new FileReader(new File("blob.txt"))));
    int rr = in.nextInt();
    for (int t = 1; t <= rr; t++) {
      in.nextInt();
      long[] frequency = new long[26];
      boolean[] boolArr = new boolean[26];
      for (int i = 0; i < 10000; i++) {
        // System.out.println(i);
        in.nextLong();
        char[] chars = in.next().toCharArray();
        // in.nextLine();
        boolArr[chars[0] - 'A'] = true;
        for (int ii = 0; ii < chars.length; ii++)
          frequency[chars[ii] - 'A'] += Math.pow(10, chars.length - ii - 1);
      }
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      StringBuilder ans = new StringBuilder("");
      for (int i = 0; i < 26; i++) {
        if (frequency[i] != 0) {
          if (!boolArr[i])
            ans.append((char) ('A' + i));
          else {
            Node temp = new Node((char) ('A' + i), frequency[i]);
            pq.add(temp);
          }
        }
      }
      for (int i = 0; i < 9; i++)
        ans.append(pq.poll().ch);
      System.out.println("Case #" + t + ": " + ans.toString());
    }
  }
}
