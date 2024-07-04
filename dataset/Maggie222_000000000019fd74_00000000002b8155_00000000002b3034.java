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
      int patternNum = input.nextInt();
      input.nextLine();
      List<String> patterns = new ArrayList<>();
      while(patternNum > 0) {
        patterns.add(input.nextLine());
        patternNum --;
      }
      String result = solve(patterns);
      out.println("Case #" + i + ": " + result);
    }
  }

  private static String solve(List<String> patterns) {
    String prefix = "";
    String suffix = "";
    StringBuilder mid = new StringBuilder();
    String prefixCandidate = "";
    String suffixCandidate = "";

    for(String pattern : patterns) {
      boolean hasPrefix = false;
      boolean hasSuffix = false;
      String[] elements = pattern.split("\\*", -1);
      if(!pattern.startsWith("*")) {
        String currentPrefix = elements[0];
        if(currentPrefix.startsWith(prefixCandidate) || prefixCandidate.startsWith(currentPrefix)) {
          prefixCandidate = currentPrefix.length() > prefixCandidate.length() ? currentPrefix : prefixCandidate;
          hasPrefix = true;
        } else {
          return "*";
        }
      }

      if(!pattern.endsWith("*")) {
        String currentSuffix = elements[elements.length - 1];
        if(currentSuffix.endsWith(suffixCandidate) || suffixCandidate.endsWith(currentSuffix)) {
          suffixCandidate = currentSuffix.length() > suffixCandidate.length() ? currentSuffix : suffixCandidate;
          hasSuffix = true;
        } else {
          return "*";
        }
      }

      for(int i = 0; i < elements.length; i ++) {
        if(hasPrefix && i == 0 || hasSuffix && i == elements.length - 1) {
          continue;
        }
        mid.append(elements[i]);
      }
    }
    prefix = prefixCandidate;
    suffix = suffixCandidate;

    return prefix + mid.toString() + suffix;
  }
}