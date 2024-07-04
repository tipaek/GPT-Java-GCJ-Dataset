

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 4/10/20.
 */
public class Solution {
  private static final class Node {
    char c;
    Node child;
    Node(char c) {
      this.c = c;
    }
    Node add(char d) {
      if (this.child != null) {
        if (this.child.c == d) {
          return this.child;
        } else {
          return null;
        }
      }
      this.child = new Node(d);
      return this.child;
    }

    String con() {
      if (child == null) {
        return Character.toString(c);
      } else {
        return c + child.con();
      }

    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      int N = getInt(reader);
      Node leftRoot = new Node('-');
      Node rightRoot = new Node('-');
      StringBuilder sb = new StringBuilder();
      boolean failed = false;
      for (int i = 0; i<N; i++) {
        String line = reader.readLine().trim();
        if (failed) {
          continue;
        }
        String left, right;
        int k = 0;
        while (line.charAt(k) != '*') k++;

        int p = line.length()-1;
        while (line.charAt(p) != '*') p--;
        left = line.substring(0, k);
        right = line.substring(p+1, line.length());
        for (int x = k; x <= p; x++) {
          if (line.charAt(x) != '*') sb.append(line.charAt(x));
        }

        if (!left.isEmpty()) {
          k = 0;
          Node node = leftRoot;
          while (k < left.length()) {
            node = node.add(left.charAt(k));
            if (node == null) {
              break;
            }
            k++;
          }

          if (k < left.length()) {
            failed = true;
            continue;
          }
        }

        if (!right.isEmpty()) {
          k = right.length() - 1;
          Node node = rightRoot;
          while (k >= 0) {
            node = node.add(right.charAt(k));
            if (node == null) {
              break;
            }
            k--;
          }
          if (k>=0) {
            failed = true;
          }
        }
      }
      String ret;
      if (failed) {
        ret = "*";
      } else {
        String leftRet = leftRoot.con();
        if (leftRet.length() != 1) {
          ret = leftRet.substring(1);
        } else {
          ret = "";
        }

        if (sb.length() != 0) {
          ret += sb.toString();
        }

        String rightRet = rightRoot.con();
        if (rightRet.length() != 1) {
          ret += new StringBuilder().append(rightRet.substring(1)).reverse().toString();
        }

      }
      System.out.println("Case #" + t + ": " + ret);
    }
  }

  private static String[] getTokens(BufferedReader reader) throws IOException {
    return reader.readLine().trim().split(" ");
  }

  private static int getInt(BufferedReader reader) throws IOException {
    return Integer.parseInt(reader.readLine().trim());
  }
}
