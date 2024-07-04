import java.util.*;

public class Solution {

  static class Interval {
    int low = 0, high = 0;
  }

  static class ITNode {
    Interval i;
    int max = -1;
    ITNode left, right;
  }

  static ITNode rootC;
  static ITNode rootJ;

  static ITNode insert(ITNode root, Interval i) {
    if (root == null) {
      ITNode current = new ITNode();
      current.max = i.high;
      current.i = i;
      root = current;
      return root;
    }

    int l = root.i.low;

    if (i.low < l) root.left = insert(root.left, i);
    else root.right = insert(root.right, i);

    if (root.max < i.high) root.max = i.high;

    return root;
  }

  static boolean doOVerlap(Interval i1, Interval i2) {
    if (i1.low <= i2.high && i2.low < i1.high) return true;
    return false;
  }

  static Interval overlapSearch(ITNode root, Interval i) {
    if (root == null) return null;

    if (doOVerlap((root.i), i)) return root.i;

    if (root.left != null && root.left.max >= i.low) return overlapSearch(root.left, i);

    return overlapSearch(root.right, i);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tc = sc.nextInt();
    int tcn = 1;

    while (tc-- != 0) {
      int n = sc.nextInt();

      rootC = null;
      rootJ = null;
      int inter[][] = new int[n][2];
      for (int i = 0; i < n; i++) {
        inter[i][0] = sc.nextInt();
        inter[i][1] = sc.nextInt();
      }

      String answer = "C";
      Interval it = new Interval();
      it.low = inter[0][0];
      it.high = inter[0][1];
      rootC = insert(rootC, it);

      for (int i = 1; i < n; i++) {
        Interval iz = new Interval();
        iz.low = inter[i][0];
        iz.high = inter[i][1];
        Interval io = overlapSearch(rootC, iz);
        if (io == null) {
          insert(rootC, iz);
          answer = answer + "C";
        } else {
          if (rootJ == null) {
            rootJ = insert(rootJ, iz);
            answer = answer + "J";
          } else {
            Interval oj = overlapSearch(rootJ, iz);
            if (oj == null) {
              insert(rootJ, iz);
              answer = answer + "J";
            } else {
              answer = "IMPOSSIBLE";
              break;
            }
          }
        }
      }

      System.out.println("Case #" + tcn + ": " + answer);
      tcn++;
    }
  }
}
