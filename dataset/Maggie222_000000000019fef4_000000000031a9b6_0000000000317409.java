import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    // Scanner has functions to read ints, longs, strings, chars, etc.
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int caseNum = input.nextInt();
    input.nextLine();

    for (int i = 1; i <= caseNum; i++) {
      int targetX = input.nextInt();
      int targetY = input.nextInt();
      char[] steps = input.next().toCharArray();
      String result = solve(targetX, targetY, steps);
      out.println("Case #" + i + ": " + result);
    }
  }

  private static String solve(int east, int north, char[] steps) {
    int[][] pos = new int[steps.length + 1][2];
    pos[0] = new int[]{east, north};

    for(int i = 0; i < steps.length; i ++) {
      switch(steps[i]) {
        case 'E': east ++; break;
        case 'W': east --; break;
        case 'N': north ++; break;
        case 'S': north --; break;
        default: break;

      }
      pos[i + 1] = new int[] {east, north};
    }

    for(int i = 0; i < pos.length; i ++) {
      boolean canMet = canMet(pos[i], i);
      if(canMet) return i + "";
    }
    return "IMPOSSIBLE";
  }
  
  private static boolean canMet(int[] pos, int mins) {
    int eDistance = Math.abs(pos[0]);
    int nDistance = Math.abs(pos[1]);
    return eDistance + nDistance <= mins;
  }

}