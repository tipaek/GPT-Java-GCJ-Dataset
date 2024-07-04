import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    int testCases = sc.nextInt();
    for (int testCase = 1; testCase <= testCases; testCase++) {
      int n = sc.nextInt();

      int[] schedules = new int[24 * 60];
      StringBuilder val = new StringBuilder();
      boolean impossible = false;

      for (int i = 0; i < n; i++) {
        int s = sc.nextInt();
        int e = sc.nextInt();
        
        if(impossible)
          continue;
        // try assigning C == 1
        boolean cexist = false;
        boolean jexist = false;
        for (int j1 = s; j1 < e; j1++) {
          if (schedules[j1] == 1 || schedules[j1] == 3) {
            cexist = true;
            break;
          }
        }

        if (cexist) {
          // try assigning J == 2
          for (int j1 = s; j1 < e; j1++) {
            if (schedules[j1] == 2 || schedules[j1] == 3) {
              jexist = true;
              break;
            }
          }

        }

        if (!cexist) {
          val.append("C");
        } else if (!jexist) {
          val.append("J");
        } else {
          impossible = true;
          continue;
        }

        for (int j = s; j < e; j++) {
          if (!cexist) {
            schedules[j] += 1;
          } else if (!jexist) {
            schedules[j] += 2;
          }
        }
        // System.out.println(Arrays.toString(schedules));
      }
      if (impossible)
        val = new StringBuilder("IMPOSSIBLE");

      pw.printf("Case #" + testCase + ": %s\n", val.toString());
      pw.flush();

    }
    pw.close();
    sc.close();
  } // main
} // class
