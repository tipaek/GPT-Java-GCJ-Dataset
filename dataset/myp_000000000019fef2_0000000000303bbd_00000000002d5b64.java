import java.util.*;
import java.io.*;

public class Solution {

  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int R = s.nextInt(), S = s.nextInt();
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < S; i++) {
        for (int j = 0; j < R; j++) {
          list.add(j);
        }
      }
      ans = null;
      dfs(list, new LinkedList<>());
      dfsAll(list, new LinkedList<>());
      System.out.println(String.format("Case #%d: %s", t, ans.size()));
      for (String str : ans) {
        System.out.println(str);
      }
    }
  }

  private static void dfsAll(List<Integer> list, LinkedList<String> path) {
    if (ans != null && path.size() > ans.size()) {
      return;
    }
    int max = getMaxCliff(list);
    if (max == 0) {
      if (ans == null || ans.size() > path.size()) {
        // System.out.println(list);
        ans = new ArrayList<>(path);
      }
    } else {
      int end = list.size() - 2;
      for (int i = 0; i < end; i++) {
        int val = list.get(i);
        for (int j = i + 1; j <= end; j++) {
          int a = i + 1, b = j - i;
          path.add(a + " " + b);
          dfs(swap(a, b, list), path);
          path.removeLast();
        }
      }
    }
  }



  private static void dfs(List<Integer> list, LinkedList<String> path) {
    if (ans != null && path.size() > ans.size()) {
      return;
    }
    int max = getMaxCliff(list);
    if (max == 0) {
      if (ans == null || ans.size() > path.size()) {
        // System.out.println(list);
        ans = new ArrayList<>(path);
      }
    } else {
      int end = list.size() - 1;
      while (list.get(end) >= max) {
        end--;
      }

      for (int i = 0; i < list.size() - 1; i++) {
        int val = list.get(i);
        if (val == max && val > list.get(i + 1)) {
          int a = i + 1, b = end - i;
          path.add(a + " " + b);
          dfs(swap(a, b, list), path);
          path.removeLast();
        }
      }
    }
  }

  private static List<Integer> swap(int a, int b, List<Integer> list) {
    List<Integer> newList = new ArrayList<Integer>();
    newList.addAll(list.subList(a, a + b));
    newList.addAll(list.subList(0, a));
    newList.addAll(list.subList(a + b, list.size()));
    return newList;
  }

  private static int getMaxCliff(List<Integer> list) {
    int prev = 0, max = 0;
    for (int num : list) {
      if (prev > num) {
        max = Math.max(max, prev);
      }
      prev = num;
    }
    return max;
  }

  private static List<String> ans;
}
