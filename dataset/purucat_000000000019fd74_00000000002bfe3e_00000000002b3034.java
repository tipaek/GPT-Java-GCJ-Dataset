import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      String[] ps = new String[N];
      for (int j = 1; j <= N; j++) {
        String p = sc.next();
        p = p.replace("**", "*");
        p = p.replace("*", ".*");
        ps[j - 1] = p;
      }
      PriorityQueue<String> ans = new PriorityQueue<>(Comparator.comparingInt(String::length));
      Arrays.sort(ps, Comparator.reverseOrder());
      String p1 = ps[0];
      for (int k = 1; k < N; k++) {
        String p2 = ps[k];
        // (!p2.matches(p1)) is sufficient?
        if (!p1.matches(p2) && !p2.matches(p1)) {
          ans.add("*");
          break;
        }
        String pp1 = p1.replace(".", "");
        String pp2 = p2.replace(".", "");
        build(new StringBuilder(), pp1, pp1.length() - 1, pp2, pp2.length() - 1, ans);
      }
      String ans1 = new StringBuilder(ans.peek()).reverse().toString().replace("*", "");
      System.out.println("Case #" + t + ": " + (ans1.length() == 0 ? "*" : ans1));
    }
  }

  static void build(
      StringBuilder sb, String s1, int i, String s2, int j, PriorityQueue<String> ans) {
    if (i < 0) {
      if (j >= 0) {
        sb.append(s2, 0, j + 1);
        ans.add(sb.toString());
        sb.delete(sb.length() - j, sb.length());
      }
      return;
    }
    if (j < 0) {
      if (i >= 0) {
        sb.append(s1, 0, i + 1);
        ans.add(sb.toString());
        sb.delete(sb.length() - i, sb.length());
      }
      return;
    }
    char c1 = s1.charAt(i);
    char c2 = s2.charAt(j);
    if (c1 == c2) {
      sb.append(c1);
      build(sb, s1, i - 1, s2, j - 1, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (c1 == '*') {
      sb.append(c2);
      build(sb, s1, i, s2, j - 1, ans);
      build(sb, s1, i - 1, s2, j - 1, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (c2 == '*') {
      sb.append(c1);
      build(sb, s1, i - 1, s2, j, ans);
      build(sb, s1, i - 1, s2, j - 1, ans);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
