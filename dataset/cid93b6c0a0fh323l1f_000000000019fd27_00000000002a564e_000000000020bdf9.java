import java.io.*;
import java.util.*;
import java.lang.Math.*;

class parent {
  public static void main( String[] args ) {
    Scanner stdin = new Scanner(System.in);

    int t = stdin.nextInt();

    for (int c = 0; c < t; c++) {

      int amountActivities = stdin.nextInt();

      int[][] activity = new int[amountActivities][3];

      for (int i = 0; i < amountActivities; i++) {
        activity[i] = new int[]{stdin.nextInt(), stdin.nextInt(), i};
      }

      Arrays.sort(activity, new java.util.Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
      });

      int C = 0;
      int J = 0;
      boolean impossible = false;
      char[] result = new char[amountActivities];
      for (int i = 0; i < amountActivities; i++) {
        if (C <= activity[i][0]) {
          C = activity[i][1];
          result[activity[i][2]] = 'C';
        } else if (J <= activity[i][0]) {
          J = activity[i][1];
          result[activity[i][2]] = 'J';
        } else {
          impossible = true;
        }
      }

      if (impossible) {
        System.out.println("Case #" + (c + 1) + ": IMPOSSIBLE");
      } else {
        System.out.print("Case #" + (c + 1) + ": ");
        for (char p : result) {
          System.out.print(p);
        }
        System.out.println();
      }
    }
  }
}