

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hao Wu (wuhao.02@gmail.com) on 4/3/20.
 */
public class Solution {

  private static final class Node {
    RangeNode left;
    RangeNode right;

    int index;
    Node(int index) {
      this.index = index;
    }
  }

  private static final class RangeNode {
    List<Node> nodes;
    int leftBound;
    int rightBound;
    int value;

    int bonus = 0;

    RangeNode(int leftBound, int rightBound, int value) {
      this.leftBound = leftBound;
      this.rightBound = rightBound;
      this.value = value;
    }

    String split(String dict) {
      if (value == 10) {
        return "";
      }
      if (leftBound > rightBound) {
        return "";
      }
      nodes = new ArrayList<>();
      for (int i = leftBound; i<=rightBound; i++) {
        if (dict.charAt(i) == value + 48) {
          nodes.add(new Node(i));
        }
      }

      if (nodes.isEmpty()) {
        bonus ++;
        value++;
        return "(" + split(dict) + ")";
      }

      int i = leftBound;
      int k  = 0;
      StringBuilder sb = new StringBuilder();
      sb.append("(");
      while (i<=rightBound && k<nodes.size()) {
        int j = i;
        while (j < nodes.get(k).index) j++;
        if (j > i) {
          RangeNode newRange = new RangeNode(i, j-1, value+1);
          sb.append(newRange.split(dict));
          nodes.get(k).left = newRange;
          if (k >0) {
            nodes.get(k-1).right = newRange;
          }
        }
        sb.append(value);
        i = j + 1;
        k++;
      }
      if (i <= rightBound) {
        RangeNode newRange = new RangeNode(i, rightBound, value+1);
        sb.append(newRange.split(dict));
        nodes.get(k-1).right = newRange;
      }
      sb.append(")");
      return sb.toString();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));


    int T = Integer.parseInt(reader.readLine());
    for (int t = 1; t <= T; t++) {
      String in = reader.readLine().trim();

      String res = new RangeNode(0, in.length() - 1, 0).split(in);

      System.out.println("Case #" + t + ": " + res.substring(1, res.length() - 1));
    }
  }
}
