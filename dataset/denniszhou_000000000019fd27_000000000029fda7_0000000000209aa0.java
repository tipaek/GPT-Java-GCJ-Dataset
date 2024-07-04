import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static List<List<Integer>> ans = new ArrayList<>();

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= t; ++i) {
      String[] input = in.nextLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int tr = Integer.parseInt(input[1]);
      ans = new ArrayList<>();
      helper(n, tr);
      if (ans.size() == 0) {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
        System.out.println("Case #" + i + ": POSSIBLE");
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < n; k++) {
            sb.append(ans.get(j).get(k));
            if (k == n - 1) {
              sb.append("\n");
            } else {
              sb.append(" ");
            }
          }
        }
        System.out.print(sb.toString());
      }
    }
  }

  private static void helper(int n, int tr) {
    List<List<Integer>> permutations = new ArrayList<>();
    getPermutation(n, new int[n], new ArrayList<>(), permutations);
    List<List<Integer>> res = new ArrayList<>();
    getResult(new int[permutations.size()], n, tr, permutations, res);
  }

  private static void getPermutation(int n, int[] visited, List<Integer> list, List<List<Integer>> res) {
    if (list.size() == n) {
      res.add(new ArrayList<>(list));
    } else {
      for (int i = 1; i <= n; i++) {
        if (visited[i - 1] == 0) {
          visited[i - 1] = 1;
          list.add(i);
          getPermutation(n, visited, list, res);
          visited[i - 1] = 0;
          list.remove(list.size() - 1);
        }
      }
    }
  }

  private static void getResult(int[] visited, int n, int tr, List<List<Integer>> permutations, List<List<Integer>> res) {
    if (res.size() == n) {
      if (isValid(res, n, tr)) {
        for (List<Integer> list : res) {
          ans.add(new ArrayList<>(list));
        }
      }
    } else {
      for (int i = 0; i < permutations.size() && ans.size() == 0; i++) {
        if (visited[i] == 0) {
          res.add(permutations.get(i));
          visited[i] = 1;
          getResult(visited, n, tr, permutations, res);
          res.remove(res.size() - 1);
          visited[i] = 0;
        }
      }
    }
  }

  private static boolean isValid(List<List<Integer>> res, int n, int tr) {
    int[][] cols = new int[n][n];
    int sum = 0;
    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < res.get(i).size(); j++) {
        if (i == j) {
          sum += res.get(i).get(j);
        }
        if (cols[j][res.get(i).get(j) - 1] == 1) {
          return false;
        }
        cols[j][res.get(i).get(j) - 1] = 1;
      }
    }
    return tr == sum;
  }
}
  