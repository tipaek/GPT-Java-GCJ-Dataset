import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int casen = 1; casen <= T; casen++) {
      int x = in.nextInt();
      int y = in.nextInt();
      boolean reverseX = false;
      boolean reverseY = false;
      boolean poss = true;
      if (x < 0) {
        x = -x;
        reverseX = true;
      }
      if (y < 0) {
        y = -y;
        reverseY = true;
      }
      StringBuilder ans = new StringBuilder(32);
      for (int pos = 1; pos <= 32; pos++) {
        if (((int)Math.pow(2, pos-1) > x) && ((int)Math.pow(2, pos-1) > y)) {
          break;
        }
        if (((x & (int)Math.pow(2, pos-1)) ^ (y & (int)Math.pow(2, pos-1))) == 0) {
          poss = false;
          System.out.println("Case #" + String.valueOf(casen) + ": IMPOSSIBLE");
          break;
        }
        else {
          // If x has the one:
          if ((x & (int)Math.pow(2, pos-1)) != 0) {
            // We want to go either east or west.
            if ((((x & (int)Math.pow(2, pos)) ^ (y & (int)Math.pow(2, pos))) != 0) || (((int)Math.pow(2, pos) > x) && ((int)Math.pow(2, pos) > y))) {
              // go east (maybe reversed)
              if (reverseX) {
                ans.append('W');
              }
              else {
                ans.append('E');
              }
            }
            else {
              // We wnat to go west (maybe reversed), then north (maybe reversed) as much as possible, then east (maybe reversed)
              if (reverseX) {
                ans.append('E');
              }
              else {
                ans.append('W');
              }
              for (pos++; (((x & (int)Math.pow(2, pos-1)) != 0) && ((y & (int)Math.pow(2, pos-1)) != 0)); pos++) {
                if (reverseY) {
                  ans.append('S');
                }
                else {
                  ans.append('N');
                }
              }
              if (((x & (int)Math.pow(2, pos-1)) != 0) || ((y & (int)Math.pow(2, pos-1)) != 0)) {
                poss = false;
                System.out.println("Case #" + String.valueOf(casen) + ": IMPOSSIBLE");
                break;
              }
              else {
                if (reverseX) {
                  ans.append('W');
                }
                else {
                  ans.append('E');
                }
              }
            }
          }
          // If y has the one:
          else {
            if ((((x & (int)Math.pow(2, pos)) ^ (y & (int)Math.pow(2, pos))) != 0) || (((int)Math.pow(2, pos) > x) && ((int)Math.pow(2, pos) > y))) {
              if (reverseY) {
                ans.append('S');
              }
              else {
                ans.append('N');
              }
            }
            else {
              if (reverseY) {
                ans.append('N');
              }
              else {
                ans.append('S');
              }
              for (pos++; (((x & (int)Math.pow(2, pos-1)) != 0) && ((y & (int)Math.pow(2, pos-1)) != 0)); pos++) {
                if (reverseX) {
                  ans.append('W');
                }
                else {
                  ans.append('E');
                }
              }
              if (((x & (int)Math.pow(2, pos-1)) != 0) || ((y & (int)Math.pow(2, pos-1)) != 0)) {
                poss = false;
                System.out.println("Case #" + String.valueOf(casen) + ": IMPOSSIBLE");
                break;
              }
              else {
                if (reverseY) {
                  ans.append('S');
                }
                else {
                  ans.append('N');
                }
              }
            }
          }
        }
      }
      if (poss) {
        System.out.println("Case #" + String.valueOf(casen) + ": " + ans.toString());
      }
    }
  }
}
