import java.util.*;
import java.io.*;

class Solution {

  public static void main(final String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    for (int i = 1; i <= rr; i++) {
      int r = in.nextInt();
      StringBuilder start = new StringBuilder("");
      StringBuilder end = new StringBuilder("");
      StringBuilder mid = new StringBuilder("");
      in.nextLine();
      boolean broke = false;
      for (int ii = 0; ii < r; ii++) {
        char[] line = in.nextLine().toCharArray();
        int q = 0, p = 0;
        for (int j = 0; j < line.length; j++) {
          if (line[j] == '*') {
            q = j;
            break;
          }
          if (j == start.length()) {
            start.append(line[j]);
          } else if (start.charAt(j) != line[j]) {
            broke = true;
            break;
          }
        }
        if (!broke) {
          for (int j = line.length - 1; j >= 0; j--) {
            int hmm = (line.length - 1 - j);
            if (line[j] == '*') {
              p = j;
              break;
            }
            if (hmm == end.length()){
              end.append(line[j]);
            }
            else if (end.charAt(hmm) != line[j]) {
              broke = true;
              break;
            }
          }
        }
        if (!broke) {
          for (int l = q; l < p; l++) {
            if (line[l] != '*') {
              mid.append(line[l]);
            }
          }
        }
      }
      System.out.printf("Case #%d: ", i);
      if (!broke) {
        System.out.println(start.toString() + mid + end.reverse());
      } else
        System.out.println("*");
    }
  }
}