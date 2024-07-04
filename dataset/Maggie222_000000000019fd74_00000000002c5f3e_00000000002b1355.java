import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    // Scanner has functions to read ints, longs, strings, chars, etc.
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int caseNum = input.nextInt();
    input.nextLine();

    for(int i = 1; i <= caseNum; i ++) {
      int size = Integer.valueOf(input.nextLine());
      int[][] floor = new int[size][size];
      for(int j = 0; j < size; j ++) {
        for(int k = 0; k < size; k ++) {
          floor[j][k] = input.nextInt();
        }
        input.nextLine();
      }

      int result = solve(floor);
      out.println("Case #" + i + ": " + result);
    }
  }

  private static int solve(int[][] floor) {
    int sum = 0;
    for(int i = 0; i < floor.length; i ++) {
      for(int j = 0; j < floor.length; j ++) {
        sum += floor[i][j];
      }
    }
    int[] level = new int[1];
    level[0] = sum;

    boolean keepGoing = true;
    while(keepGoing) {
      keepGoing = compete(floor, level, new int[floor.length][floor.length]);
    }
    return level[0];
  }

  private static boolean compete(int[][] floor, int[] level, int[][] dead) {
    int[][] next = new int[floor.length][floor.length];
    boolean end = true;
    for(int i = 0; i < floor.length; i ++) {
      for(int j = 0; j < floor.length; j ++) {
        if(dead[i][j] != 1) {
          int sumN = 0;
          int count = 0;
          if(i - 1 >= 0 && dead[i - 1][j] != 1) {
            sumN += floor[i -1][j];
            count++;
          }
          if(i + 1 < floor.length && dead[i + 1][j] != 1) {
            sumN += floor[i + 1][j];
            count++;
          }
          if(j - 1 >= 0 && dead[i][j - 1] != 1) {
            sumN += floor[i][j -1];
            count++;
          }
          if(j + 1 < floor.length && dead[i][j + 1] != 1) {
            sumN += floor[i][j + 1];
            count++;
          }
          if(sumN/count > floor[i][j]) {
            next[i][j] = 1;
            end = false;
          }
        }

      }




    }

    if(end) return end;
    int sum = 0;

    for(int i = 0; i < floor.length; i ++) {
      for (int j = 0; j < floor.length; j++) {

        if(next[i][j] == 1) {
          dead[i][j] = 1;
        } else {
          sum += floor[i][j];
        }
      }
    }
    
    level[0] = sum;



    return false;

  }

}