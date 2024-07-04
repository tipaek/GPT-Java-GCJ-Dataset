/*
 ******************************************************************************
 * MIT License                                                                *
 * Copyright (c) 2020 Viral Lalakia                                           *
 ******************************************************************************
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This is a solution for one of the problems for Google Code Jam 2020.
 * Competition: Google Code Jam 2020
 * Round: 1a
 * Problem: Problem A (Pattern Matching)
 * Year: 2020
 */
public class Solution {

  private static final Scanner SYS_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  private static final String WC = "*";

  public static void main(String[] args) {
    int _T_ = SYS_IN.nextInt();
    for (int t = 0; t < _T_; t++) {
      System.out.println(evaluateCase(t + 1, SYS_IN.nextInt()));
    }
    SYS_IN.close();
  }

  private static String evaluateCase(final int t, final int _N_) {
    SYS_IN.nextLine();
    String ans = "";
    boolean startsWithWC = true;
    boolean onlyOneWC = true;
    try {
      List<String> patterns = new ArrayList<>(_N_);
      for (int i = 0; i < _N_; i++) {
        patterns.add(SYS_IN.nextLine());
        if (!patterns.get(i).startsWith(WC)) {
          startsWithWC = false;
        }
        if (patterns.get(i).replace(WC, "").length() != patterns.get(i).length() - 1) {
          onlyOneWC = false;
        }
      }
      if (onlyOneWC) {
        if (startsWithWC) {
          String longestPattern = "";
          int maxLength = -1;
          for (int i = 0; i < _N_; i++) {
            String s = patterns.get(i).substring(1);
            patterns.set(i, s);
            if (s.length() > maxLength) {
              maxLength = s.length();
              longestPattern = s;
            }
          }
          for (int i = 0; i < _N_; i++) {
            if (!longestPattern.endsWith(patterns.get(i))) {
              return String.format("Case #%d: %s", t, WC);
            }
          }
          return String.format("Case #%d: %s", t, longestPattern);
        } else {
        }
      }
    } catch (Exception e) {
    }
    return String.format("Case #%d: %s", t, WC);
  }

}
