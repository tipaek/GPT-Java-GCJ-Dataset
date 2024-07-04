
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;
  boolean possible;
  int[][] oneSquare;

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int n = scanner.nextInt();
      scanner.nextLine();
      List<String> patterns = new ArrayList<String>();
      for (int j = 0; j < n; j++) {
        patterns.add(scanner.nextLine());
      }
      Solution sol = new Solution();
      String r = sol.solve(patterns);
//      
//      if (!"*".equals(r) && !check(patterns, r)) {
//        throw new RuntimeException();
//      }
      out.println("Case #" + i + ": " + r);

    }

  }

  public String solve(List<String> patterns) {
    
    List<String[]> split = patterns.stream().map(s -> s.replaceAll("\\*+", "-*-")).map(s -> s.split("-"))
        .collect(Collectors.toList());
    
    List<String> greed = split.stream().filter(s-> s.length==1).map(s -> s[0]).distinct().collect(Collectors.toList());
    if (greed.size()>1) {
      return "*";
    } else if (greed.size()==1) {
      String big = greed.get(0);
      if (check(patterns, big)) {
        return big;
      } else {
        return "*";
      }
    }
    int maxBegin = Integer.MIN_VALUE;
    String begin = "";
    int maxEnd = Integer.MIN_VALUE;
    String end = "";
    for (int i = 0; i < split.size(); i++) {
      String[] pat = split.get(i);
      if (!pat[0].equals("*")) {
        if (pat[0].length() > maxBegin) {
          maxBegin = pat[0].length();
          begin = pat[0];
        }

        if (!begin.contains(pat[0])) {
          return "*";
        }
      }

      String pend = pat[pat.length - 1];
      if (!pend.equals("*")) {
        if (pend.length() > maxEnd) {
          maxEnd = pend.length();
          end = pend;
        }

        if (!end.contains(pend)) {
          return "*";
        }
      }
    }

    for (String[] pat : split) {
      if (!pat[0].equals("*") && !begin.contains(pat[0])) {
        return "*";
      }
      if (!pat[pat.length - 1].equals("*") && !end.contains(pat[pat.length - 1])) {
        return "*";
      }
    }
    String r = begin;

    for (String[] pat : split) {
      for (int i = 1; i < pat.length - 1; i++) {
        String p = pat[i];
        if (!"*".equals(p)) {
          r += p;
        }
      }
    }

    r += end;
    return r;
  }

  public static boolean check(List<String> patterns, String name) {
    for (String pat : patterns) {
      String p2 = pat.replaceAll("\\*+", ".*");
      if (!name.matches(p2)) {
        return false;
      }
    }

    return true;
  }
}