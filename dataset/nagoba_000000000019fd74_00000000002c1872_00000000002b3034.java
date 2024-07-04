import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCases;
    testCases = Integer.parseInt(sc.next());
    for (int i = 0; i < testCases; i++) {
      int N = sc.nextInt();
      List<String> names1 = new ArrayList<>();
      List<String> names2 = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        String input = sc.next();
        if (input.charAt(0) == '*') {
          names2.add(input);
        } else {
          names1.add(input);
        }
      }
      List<String> names3 = new ArrayList<>();
      names3.addAll(names2);
      names3.addAll(names1);
      solve(i + 1, N, names3, names1.size() != 0);
    }
  }

  private static void solve(int caseCount, int N, List<String> names, boolean two) {

    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        Integer s1i = s1.indexOf('*');
        Integer s2i = s2.indexOf('*');
        if (s1i == 0 && s2i == 0) {
          Integer s1L = s1.length();
          Integer s2L = s2.length();
          return s2L.compareTo(s1L);
        } else if (s1i == 0 && s2i != 0) {
          return 1;
        } else if (s1i != 0 && s2i == 0) {
          return -1;
        } else {
          Integer s1L = s1.length();
          Integer s2L = s2.length();
          return s1L.compareTo(s2L);
        }
      }
    });
    //names.stream().forEach(System.out::println);

    boolean result = true;
    String full = names.get(0);
    if (two) {
      String first = names.get(0);
      String second = names.get(1);
      if (first.charAt(0) == '*') {
        full = second.concat(first);
      } else {
        full = first.concat(second);
      }
    }
    ///System.out.println(full);
    for (int i = 1; i < N; i++) {
      if (!hasSubsequence(full, names.get(i))) {
        result = false;
        break;
      }
    }

    if (result) {
      String r = full.replaceAll("\\*", "");
      System.out.println("Case #" + caseCount + ": " + r);
    } else {
      System.out.println("Case #" + caseCount + ": *");
    }
  }

  private static boolean hasSubsequence(String full, String newStr) {
    String[] parts = newStr.split("\\*");

    int lastIndex = 0;
    for (String prt : parts) {
      if (!prt.equals((""))) {
        int currentIndex = full.lastIndexOf(prt);
        if (currentIndex == -1 || currentIndex < lastIndex) {
          return false;
        }
        lastIndex = currentIndex;
      }
    }
    if ((lastIndex + parts[parts.length - 1].length()) == full.length()) {
      return true;
    }

    return false;
  }

}
