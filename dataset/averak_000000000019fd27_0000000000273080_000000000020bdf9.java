import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

// #3
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int countTest = in.nextInt();
    for (int i = 1; i <= countTest; i++) {
      if (in.hasNext()) {
        int size = in.nextInt();
        boolean[] cm = new boolean[1441];
        boolean[] jm = new boolean[1441];

        StringBuilder s = new StringBuilder();
        for (int j = 0; j < size; j++) {
          int left = in.nextInt(), right = in.nextInt() - 1;
          if (!cm[left] && !cm[right]) {
            s.append("C");
            addInterval(cm, left, right);
          } else if(!jm[left] && !jm[right]) {
            s.append("J");
            addInterval(jm, left, right);
          } else {
            System.out.println("Case #" + i + ": IMPOSSIBLE");
            break;
          }

        }
        System.out.println("Case #" + i + ": " + s.toString());
      }
    }
  }

  private static void addInterval(boolean[] m, int left, int right) {
    for (int i = left; i <= right; i++) {
      m[i] = true;
    }
  }
}
    