import java.util.*;
import java.io.*;

class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();

    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");

      int N = Integer.parseInt(in.readLine());
      String[][] psm = new String[N][3];
      int maxPrefixIndex = 0, maxSuffixIndex = 0;
      int maxPrefixLength = 0, maxSuffixLength = 0;

      for (int i = 0; i < N; i++) {
        char[] pattern = in.readLine().toCharArray();
        int l = pattern.length;

        String tmp = "";
        int j = 0;
        for (; j < l; j++) {
          if (pattern[j] == '*') {
            if (j > maxPrefixLength) {
              maxPrefixIndex = i;
              maxPrefixLength = j;
            }
            break;
          } else {
            tmp += pattern[j];
          }
        }
        if (j != 0) {
          psm[i][0] = tmp;
        }
        
        tmp = "";
        int k = l - 1;
        for (; k >= 0; k--) {
          if (pattern[k] == '*') {
            if (l - k - 1 > maxSuffixLength) {
              maxSuffixIndex = i;
              maxSuffixLength = l - k - 1;
            }
            break;
          } else {
            tmp = pattern[k] + tmp;
          }
        }
        if (k != l - 1) {
          psm[i][2] = tmp;
        }

        tmp = "";
        for (int m = j + 1; m < k; m++) {
          if (pattern[m] != '*') {
            tmp += pattern[m];
          }
        }
        psm[i][1] = tmp;
      }

      boolean possible = true;
      for (int i = 0; i < N; i++) {
        if (maxPrefixLength != 0 && psm[i][0] != null) {
          if (!psm[maxPrefixIndex][0].substring(0, psm[i][0].length()).equals(psm[i][0])) {
            possible = false;
            break;
          }
        }
        
        if (maxSuffixLength != 0 && psm[i][2] != null) {
          int l = psm[i][2].length();
          if (!psm[maxSuffixIndex][2].substring(maxSuffixLength - l).equals(psm[i][2])) {
            possible = false;
            break;
          }
        }
      }

      if (!possible) {
        output.append('*');
      } else {
        if (maxPrefixLength != 0) {
          output.append(psm[maxPrefixIndex][0]);
        }

        for (int i = 0; i < N; i++) {
          if (psm[i][1].length() > 0) {
            output.append(psm[i][1]);
          }
        }
        
        if (maxSuffixLength != 0) {
          output.append(psm[maxSuffixIndex][2]);
        }
      }
      
      output.append('\n');
    }

    out.print(output);

    in.close();
    out.close();
  }

}