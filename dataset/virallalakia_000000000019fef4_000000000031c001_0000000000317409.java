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
 * Round: 1c
 * Problem: Problem A (Overexcited Fan)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String RESPONSE_IMPOSSIBLE = "IMPOSSIBLE";

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt(), SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, int _X_, int _Y_) {
    try {
      char[] path = SYS_IN.nextLine().toCharArray();
      short count = 0;
      for (char c : path) {
        switch (c) {
          case 'N':
            ++_Y_;
            ++count;
            break;
          case 'S':
            --_Y_;
            ++count;
            break;
          case 'E':
            ++_X_;
            ++count;
            break;
          case 'W':
            --_X_;
            ++count;
            break;
        }
        if (Math.abs(_X_) + Math.abs(_Y_) <= count) {
          return String.format("Case #%d: %d", t, count);
        }
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, RESPONSE_IMPOSSIBLE);
  }

}
