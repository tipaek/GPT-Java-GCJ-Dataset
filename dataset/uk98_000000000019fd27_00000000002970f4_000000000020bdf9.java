import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String ans = new String();
      int N = in.nextInt();
      int start[] = new int[N];
      int end[] = new int[N];
      int cStart[] = new int[N];
      int cEnd[] = new int[N];
      int jStart[] = new int[N];
      int jEnd[] = new int[N];
      
      for (int j = 0; j < N; j++) {
        start[j] = in.nextInt();
        end[j] = in.nextInt();
      }
      for (int j2 = 0; j2 < N; j2++) {
        boolean C = false;
        boolean J = false;
        int j = 0;
        for (j = 0; j < N; j++) {
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
          for (j = 0; j < N; j++) {
            if (jStart[j] != 0 || jEnd[j] != 0) {
              if (((jStart[j] <= start[j2]) && (start[j2] < jEnd[j])) || ((jStart[j] < end[j2]) && (end[j2] <= jEnd[j]))) {
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