import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int r = in.nextInt();
      int c = in.nextInt();
      // read in array
      int [][] skills = new int [r][c];
      boolean [][] eliminated = new boolean[r][c];
      for (int j = 0; j < r; j ++) {
        for (int k = 0; k < c; k ++) {
          skills[j][k] = in.nextInt();
          eliminated[j][k] = false;
        }
      }
      boolean end = false; // end of competition
      long totalInterest = 0; // sum of all skills at all rounds
      while (!end) {
        boolean [][] newElims = new boolean[r][c];
        for (boolean [] temp : newElims) for (boolean elem : temp) elem = false;
        // now check each dancer to see whether they are eliminated
        // Note: If a dancer has no neighbor in a given direction, use the dancer's own skill
        for (int j = 0; j < r; j ++) {
          for (int k = 0; k < c; k ++) {
          if (!eliminated[j][k]) {
            int skill = skills[j][k];
            int top = skill;
            int bottom = skill;
            int left = skill;
            int right = skill;
            int l;
            for (l = j + 1; l < r; l ++) {
              if (!(eliminated[l][k])) {
                bottom = skills[l][k];
                break;
              }
            }
            for (l = j - 1; l >= 0; l --) {
              if (!(eliminated[l][k])) {
                top = skills[l][k];
                break;
              }
            }
            for (l = k + 1; l < c; l ++) {
              if (!(eliminated[j][l])) {
                right = skills[j][l];
                break;
              }
            }
            for (l = k - 1; l >= 0; l --) {
              if (!(eliminated[j][l])) {
                left = skills[j][l];
                break;
              }
            }
            if (skill * 4 < left + right + top + bottom) newElims[j][k] = true;
          }
        }
        }

        // now actually eliminate the dancers
        // also sum over the skills of those not previously eliminated
        for (int j = 0; j < r; j ++) {
          for (int k = 0; k < c; k ++) {
            if (!eliminated[j][k]) totalInterest += skills[j][k];
            eliminated[j][k] = eliminated[j][k] || newElims[j][k];
          }
        }

        end = true;
        for (boolean [] temp : newElims) for (boolean elem : temp) end = end && !elem;
      }
      System.out.println("Case #" + i + ": " + totalInterest);
    }
  }
}
