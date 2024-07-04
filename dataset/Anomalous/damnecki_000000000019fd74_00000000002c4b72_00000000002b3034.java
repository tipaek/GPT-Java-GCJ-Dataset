import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

  private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUTPUT = System.out;

  public static void main(String[] args) {
    int testCases = SCANNER.nextInt();
    
    for (int t = 1; t <= testCases; t++) {
      int patternsCount = SCANNER.nextInt();
      List<List<String>> patterns = new ArrayList<>();
      
      for (int i = 0; i < patternsCount; i++) {
        String pattern = SCANNER.next();
        String[] splitPattern = pattern.split("\\*");
        
        for (int j = 0; j < splitPattern.length; j++) {
          if (patterns.size() == j) {
            patterns.add(new ArrayList<>());
          }
          patterns.get(j).add(splitPattern[j]);
        }
        
        if (pattern.endsWith("*") && patterns.size() == splitPattern.length) {
          patterns.add(new ArrayList<>());
          patterns.get(patterns.size() - 1).add("");
        }
      }
      
      for (List<String> patternList : patterns) {
        patternList.sort(new LengthComparator());
      }
      
      String result = determinePattern(patterns);
      OUTPUT.println("Case #" + t + ": " + result);
    }
  }

  private static String determinePattern(List<List<String>> patterns) {
    if (patterns.size() == 2) {
      if (patterns.get(0).get(0).isEmpty()) {
        return checkSuffixPattern(patterns.get(1));
      } else {
        String prefixPattern = checkPrefixPattern(patterns.get(0));
        if (!prefixPattern.equals("*")) {
          String suffixPattern = checkSuffixPattern(patterns.get(1));
          if (!suffixPattern.equals("*")) {
            return prefixPattern + suffixPattern;
          }
        }
      }
    }
    return "*";
  }

  private static String checkPrefixPattern(List<String> prefixPatterns) {
    String prefix = prefixPatterns.get(0);
    for (int i = 1; i < prefixPatterns.size(); i++) {
      if (!prefix.startsWith(prefixPatterns.get(i))) {
        return "*";
      }
    }
    return prefix;
  }

  private static String checkSuffixPattern(List<String> suffixPatterns) {
    String suffix = suffixPatterns.get(0);
    for (int i = 1; i < suffixPatterns.size(); i++) {
      if (!suffix.endsWith(suffixPatterns.get(i))) {
        return "*";
      }
    }
    return suffix;
  }

  static class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return Integer.compare(s2.length(), s1.length());
    }
  }
}