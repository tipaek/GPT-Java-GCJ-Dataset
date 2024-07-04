package com.ocdejam.nested_depth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    for (int t = 1; t < Integer.parseInt(line) + 1; t++) {
      String s = br.readLine();
      solve(s, t);
    }
  }

  public static void solve(String s, int t) {
    int depth = 0;
    StringBuilder result = new StringBuilder();
      String OPEN = "(";
      String CLOSE = ")";
      String RESULT_FORMAT = "Case #%depth: %s";

    for (char c : s.toCharArray()) {
      int currentNumber = c - '0';
      if (currentNumber > depth) {
        while (currentNumber > depth) {
          result.append(OPEN);
          depth++;
        }
      }
      if (currentNumber < depth) {
        while (currentNumber < depth) {
          result.append(CLOSE);
          depth--;
        }
      }
      result.append(c);
    }
    while (depth > 0) {
      result.append(CLOSE);
      depth--;
    }

    System.out.println(String.format(RESULT_FORMAT, t, result.toString()));
  }
}
