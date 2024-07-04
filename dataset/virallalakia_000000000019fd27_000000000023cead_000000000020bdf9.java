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
 * Round: Qualification
 * Problem: Problem C (Parenting Partnering Returns)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String RESULT_IMPOSSIBLE = "IMPOSSIBLE";
  private static final char CHAR_C = 'C';
  private static final char CHAR_J = 'J';

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _N_) {
    int[] IP_tasks = new int[2 * _N_];
    char[] OP_assignedTasks = new char[_N_];
    try {
      SYS_IN.nextLine();
      IP_tasks[0] = SYS_IN.nextInt();
      IP_tasks[1] = SYS_IN.nextInt();
      SYS_IN.nextLine();
      OP_assignedTasks[0] = CHAR_C;

      for (int i = 1; i < _N_; i++) {
        int a = IP_tasks[2 * i] = SYS_IN.nextInt();
        int b = IP_tasks[(2 * i) + 1] = SYS_IN.nextInt();
        SYS_IN.nextLine();
        boolean cFlag = true;
        boolean jFlag = true;
        for (int j = 0; j < i; j++) {
          if (OP_assignedTasks[j] == CHAR_C && cFlag) {
            if (!((a < IP_tasks[2 * j] && b <= IP_tasks[2 * j]) ||
                (a >= IP_tasks[(2 * j) + 1] && b > IP_tasks[(2 * j) + 1]))) {
              cFlag = false;
            }
          }
          if (OP_assignedTasks[j] == CHAR_J && jFlag) {
            if (!((a < IP_tasks[2 * j] && b <= IP_tasks[2 * j]) ||
                (a >= IP_tasks[(2 * j) + 1] && b > IP_tasks[(2 * j) + 1]))) {
              jFlag = false;
            }
          }
        }
        if (cFlag) {
          OP_assignedTasks[i] = CHAR_C;
        } else if (jFlag) {
          OP_assignedTasks[i] = CHAR_J;
        } else {
          return String.format("Case #%d: %s", t, RESULT_IMPOSSIBLE);
        }
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, new String(OP_assignedTasks));
  }

}
