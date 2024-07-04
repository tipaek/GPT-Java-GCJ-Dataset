/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: 1b
 * Problem: Problem A (Expogo)
 * Year: 2020
 */
public class Solution {

  enum Dir {
    N,
    E,
    W,
    S
  }

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String RESPONSE_IMPOSSIBLE = "IMPOSSIBLE";
  private static final int MAX = 11;

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt(), SYS_IN.nextInt()));
      SYS_IN.nextLine();
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _X_, final int _Y_) {
    try {
      StringBuffer tempResult = new StringBuffer();
      tempResult.append("------------------------------------------------");
      String result = null;
      result = jump(tempResult, (_X_ > 0 ? Dir.E : Dir.W), 0, 1, _X_, _Y_, 0, 0);
      if (result == null) {
        result = jump(tempResult, (_X_ < 0 ? Dir.E : Dir.W), 0, 1, _X_, _Y_, 0, 0);
      }
      if (result == null) {
        result = jump(tempResult, (_Y_ > 0 ? Dir.N : Dir.S), 0, 1, _X_, _Y_, 0, 0);
      }
      if (result == null) {
        result = jump(tempResult, (_Y_ < 0 ? Dir.N : Dir.S), 0, 1, _X_, _Y_, 0, 0);
      }
      if (result != null) {
        return String.format("Case #%d: %s", t, result);
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, RESPONSE_IMPOSSIBLE);
  }

  private static String jump(StringBuffer steps, final Dir dir, int turn, int jump, final int tarX, final int tarY,
      final int curX, final int curY) {
    try {
      steps.setCharAt(turn, dir.name().charAt(0));
      int newX = curX;
      int newY = curY;
      switch (dir) {
        case E:
          newX += jump;
          break;
        case W:
          newX -= jump;
          break;
        case N:
          newY += jump;
          break;
        case S:
          newY -= jump;
          break;
      }
      turn++;
      if (newX == tarX && newY == tarY) {
        return steps.substring(0, turn);
      }
      if (turn > MAX) {
        return null;
      }
      jump *= 2;
      String result = jump(steps, (tarX > newX ? Dir.E : Dir.W), turn, jump, tarX, tarY, newX, newY);
      if (result == null) {
        result = jump(steps, (tarX < newX ? Dir.E : Dir.W), turn, jump, tarX, tarY, newX, newY);
      }
      if (result == null) {
        result = jump(steps, (tarY > newY ? Dir.N : Dir.S), turn, jump, tarX, tarY, newX, newY);
      }
      if (result == null) {
        result = jump(steps, (tarY < newY ? Dir.N : Dir.S), turn, jump, tarX, tarY, newX, newY);
      }
      return result;
    } catch (Exception e) {
    }
    return null;
  }

}
