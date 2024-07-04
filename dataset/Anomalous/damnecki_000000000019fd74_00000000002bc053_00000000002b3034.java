import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

  private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
  private static final PrintStream OUTPUT = System.out;

  public static void main(String[] args) {
    int testCases = SCANNER.nextInt();

    for (int t = 1; t <= testCases; t++) {
      int numPatterns = SCANNER.nextInt();
      List<List<String>> patterns = new ArrayList<>();
      String result = "";

      for (int i = 0; i < numPatterns; i++) {
        String pattern = SCANNER.next();
        String[] splitPattern = pattern.split("\\*");

        for (int j = 0; j < splitPattern.length; j++) {
          if (patterns.size() == j) {
            patterns.add(new ArrayList<>());
          }
          patterns.get(j).add(splitPattern[j]);
        }

        if (pattern.endsWith("*")) {
          if (patterns.size() == splitPattern.length) {
            patterns.add(new ArrayList<>());
          }
          patterns.get(patterns.size() - 1).add("");
        }
      }

      for (List<String> patternList : patterns) {
        patternList.sort(new LengthComparator());
      }

      String prefix = patterns.get(0).get(0);
      if (!prefix.isEmpty()) {
        for (int i = 1; i < patterns.get(0).size(); i++) {
          if (!prefix.endsWith(patterns.get(0).get(i))) {
            result = "*";
            break;
          }
        }
        if (!result.equals("*")) {
          result = prefix;
        }
      }

      for (int i = 1; i < patterns.size() - 1 && !result.equals("*"); i++) {
        String middle = patterns.get(i).get(0);
        for (String part : patterns.get(i)) {
          if (!middle.contains(part)) {
            result = "*";
            break;
          }
        }
        if (!result.equals("*")) {
          result += middle;
        }
      }

      if (!result.equals("*")) {
        String suffix = patterns.get(patterns.size() - 1).get(0);
        if (!suffix.isEmpty()) {
          for (int i = 1; i < patterns.get(patterns.size() - 1).size(); i++) {
            if (!suffix.startsWith(patterns.get(patterns.size() - 1).get(i))) {
              result = "*";
              break;
            }
          }
          if (!result.equals("*")) {
            result += suffix;
          }
        }
      }

      OUTPUT.println("Case #" + t + ": " + result);
    }
  }

  static class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return Integer.compare(s2.length(), s1.length());
    }
  }
}