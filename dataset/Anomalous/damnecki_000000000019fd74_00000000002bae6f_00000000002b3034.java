import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

  private static final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream out = System.out;

  public static void main(String[] args) {
    int testCases = scanner.nextInt();

    for (int t = 1; t <= testCases; t++) {
      int patternsCount = scanner.nextInt();
      List<List<String>> patterns = new ArrayList<>();

      for (int i = 0; i < patternsCount; i++) {
        String pattern = scanner.next();
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

      for (List<String> part : patterns) {
        part.sort(new PatternComparator());
      }

      String result = constructResult(patterns);
      out.println("Case #" + t + ": " + result);
    }
  }

  private static String constructResult(List<List<String>> patterns) {
    StringBuilder result = new StringBuilder();
    if (!patterns.isEmpty()) {
      String initialPart = patterns.get(0).get(0);

      if (!initialPart.isEmpty() && !allContain(initialPart, patterns.get(0))) {
        return "*";
      }

      result.append(initialPart);

      for (int i = 1; i < patterns.size() - 1; i++) {
        String part = patterns.get(i).get(0);
        if (!allContain(part, patterns.get(i))) {
          return "*";
        }
        result.append(part);
      }

      if (!patterns.get(patterns.size() - 1).isEmpty()) {
        String lastPart = patterns.get(patterns.size() - 1).get(0);
        if (!allContain(lastPart, patterns.get(patterns.size() - 1))) {
          return "*";
        }
        result.append(lastPart);
      }
    }
    return result.toString();
  }

  private static boolean allContain(String part, List<String> parts) {
    for (String p : parts) {
      if (!part.contains(p)) {
        return false;
      }
    }
    return true;
  }

  static class PatternComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return Integer.compare(s2.length(), s1.length());
    }
  }
}