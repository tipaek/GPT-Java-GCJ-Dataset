import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int runs = Integer.parseInt(sc.nextLine().trim());
    for (int run = 1; run <= runs; run++) {
      char[] S = sc.nextLine().trim().toCharArray();
      String[] parens = new String[S.length + 1];
      for (int i = 0; i < parens.length; i++) {
        parens[i] = "";
      }

      for (char depth = '1'; depth <= '9'; depth++) {
        boolean found = false;

        for (int i = 0; i < S.length; i++) {
          if (S[i] >= depth && !found) {
            parens[i] += "(";
            found = true;
          } else if (S[i] < depth && found) {
            parens[i] = ")" + parens[i];
            found = false;
          }
        }
        if (found) {
          parens[S.length] += ")";
        }
      }

      String parenS = parens[0];
      for (int i = 0; i < S.length; i++) {
        parenS += S[i] + parens[i + 1];
      }

      System.out.printf("Case #%d: %s\n", run, parenS);
    }
  }
}