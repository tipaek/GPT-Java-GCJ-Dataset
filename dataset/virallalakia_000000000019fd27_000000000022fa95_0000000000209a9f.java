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
 * Problem: Problem B (Nesting Depth)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    SYS_IN.nextLine();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextLine()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final String _S_) {
    StringBuffer sb = new StringBuffer();
    try {
      int openParen = 0;
      for (int i = 0; i < _S_.length(); i++) {
        int digit = Integer.valueOf(_S_.substring(i, i + 1), 10);
        while (openParen < digit) {
          sb.append("(");
          openParen++;
        }
        while (openParen > digit) {
          sb.append(")");
          openParen--;
        }
        sb.append(digit);
      }
      while (openParen > 0) {
        sb.append(")");
        openParen--;
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, sb.toString());
  }

}
