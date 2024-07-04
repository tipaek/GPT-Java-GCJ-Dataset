import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String ans = new String();
      int n = in.nextInt();
      int start[] = new int[n];
      int end[] = new int[n];
      int cStart[] = new int[n];
      int cEnd[] = new int[n];
      int jStart[] = new int[n];
      int jEnd[] = new int[n];
      
      for (int j = 0; j < n; j++) {
        start[j] = in.nextInt();
        end[j] = in.nextInt();
      }
      for (int j2 = 0; j2 < n; j2++) {
        boolean C = false;
        boolean J = false;
        int j = 0;
        for (j = 0; j < n; j++) {
          if (cStart[j] != 0 || cEnd[j] != 0) {
            if (((cStart[j] <= start[j2]) && (start[j2] < cEnd[j])) || ((cStart[j] < end[j2]) && (end[j2] <= cEnd[j]))) {
              C = true;
            }
          } else {
            break;
          }
        }
        if (C == false) {
          cStart[j] = start[j2];
          cEnd[j] = end[j2];
          ans += "C";
        } else if(C == true) {
          for (j = 0; j < n; j++) {
            if (jStart[j] != 0 || jEnd[j] != 0) {
              if (((jStart[j] <= start[j2]) && (start[j2] < jEnd[j])) || ((jStart[j] < end[j2]) && (end[j2] <= jEnd[j]))) {
                System.out.println("jStart" + jStart[j]);
                System.out.println("jEnd" + jEnd[j]);
                System.out.println("start" + start[j2]);
                System.out.println("end" + end[j2]);
                J = true;
              }
            } else {
              break;
            }
          }
          if (J == false) {
            jStart[j] = start[j2];
            jEnd[j] = end[j2];
            ans += "J";
          } else if(J == true) {
            ans = "IMPOSSIBLE";
            break;
          }
        }
      }
      System.out.println("Case #" + i + ": " + ans);
    }
  }
}
