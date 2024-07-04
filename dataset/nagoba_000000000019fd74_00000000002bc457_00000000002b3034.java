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
      List<String> names = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        names.add(sc.next());
      }
      solve(i + 1, N, names);
    }
  }

  private static void solve(int caseCount, int N, List<String> names) {

    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        Integer s1L = s1.length();
        Integer s2L = s2.length();
        return s2L.compareTo(s1L);
      }
    });
    //names.stream().forEach(System.out::println);

    boolean result = true;
    for (int i = 1; i < N; i++) {
      if (!hasSubsequence(names.get(0), names.get(i))) {
        result = false;
        break;
      }
    }

    if (result) {
      String[] split = names.get(0).split("\\*");
      if (split[0].equals("")) {
        System.out.println("Case #" + caseCount + ": " + split[1]);
      } else {
        System.out.println("Case #" + caseCount + ": " + split[0]);
      }
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
    if((lastIndex + parts[parts.length-1].length()) == full.length()) {
      return true;
    }

    return false;
  }

}
