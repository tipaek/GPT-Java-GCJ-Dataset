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
 * This is a solution for on of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: Qualification
 * Problem: Problem A (Vestigium)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _N_) {
    int OP_dSum_ = 0;
    int OP_rCount_ = 0;
    int OP_cCount_ = 0;
    try {
      int[][] arr = new int[_N_][_N_];
      boolean[][] arrColFlags = new boolean[_N_ + 1][_N_ + 1];
      int[] cFlagsCount = new int[_N_ + 1];
      for (int i = 0; i < _N_; i++) {
        boolean[] arrSingleRowFlags = new boolean[_N_ + 1];
        int rFlagCount = 0;
        for (int j = 0; j < _N_; j++) {
          arr[i][j] = SYS_IN.nextInt();
          if (!arrSingleRowFlags[arr[i][j]]) {
            arrSingleRowFlags[arr[i][j]] = true;
            rFlagCount++;
          }
          if (!arrColFlags[j][arr[i][j]]) {
            arrColFlags[j][arr[i][j]] = true;
            cFlagsCount[j]++;
          }
        }
        OP_dSum_ += arr[i][i];
        if (rFlagCount != _N_) {
          OP_rCount_++;
        }
        SYS_IN.nextLine();
      }
      for (int j = 0; j < _N_; j++) {
        if (cFlagsCount[j] != _N_) {
          OP_cCount_++;
        }
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %d %d %d", t, OP_dSum_, OP_rCount_, OP_cCount_);
  }

}
