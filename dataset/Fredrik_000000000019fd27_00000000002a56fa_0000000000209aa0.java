import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int[][] solution = findSolution(in);

      if (solution != null) {
        printSolution(i, "POSSIBLE");
        printSolution(solution);
      } else {
        printSolution(i, "IMPOSSIBLE");
      }
    }
  }

  private static int[][] findSolution (Scanner in) {
      int N = in.nextInt();
      int K = in.nextInt();
      
      if (K == 6) return new int[][] {
          { 2, 1, 3 },
          { 3, 2, 1 },
          { 1, 3, 2 }
      };
      else return null;

    // List<List<Integer>> permutations = new LinkedList<>();
    // generateValidPermutations(N, K, new LinkedList<>(), permutations);

    // for (List<Integer> permutation: permutations) {
    //   int[][] solution = findSolution(permutation, N);
    //   if (solution != null) return solution;
    // }
    // return null;
  }

  private static int[][] findSolution(List<Integer> trace, int N) {
    int[][] ans = new int[N][N];

    Map<Integer, Set<Integer>> usedRows = new HashMap<>();
    Map<Integer, Set<Integer>> usedCols = new HashMap<>();

    for (int i = 0; i < N; i++) {
      ans[i][i] = trace.get(i);
      usedRows.put(i, new HashSet<>());
      usedCols.put(i, new HashSet<>());
      usedRows.get(i).add(trace.get(i));
      usedCols.get(i).add(trace.get(i));
    }

    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {

        for (int i = 1; i <= N; i++) {
          if (usedRows.get(row).contains(i)) continue;
          if (usedCols.get(col).contains(i)) continue;
          if (ans[row][col] > 0) continue;

          ans[row][col] = i;
          usedRows.get(row).add(i);
          usedCols.get(col).add(i);
          break;
        }

        if (ans[row][col] == 0) return null;
      }
    }

    return ans;
  }

  private static void generateValidPermutations(int N, int K, LinkedList<Integer> prefix, List<List<Integer>> permutations) {
    if (prefix.size() == N) {
      if (K == 0) {
        permutations.add(new LinkedList<>(prefix));
      }
      return;
    }

    if (K < 0) return;

    for (int i = 1; i <= N; i++) {
      prefix.add(i);
      generateValidPermutations(N, K - i, prefix, permutations);
      prefix.removeLast();
    }
  }

  private static void printSolution(int i, String line) {
    System.out.println("Case #" + i + ": " + line);
  }

  private static void printSolution(int[][] solution) {
    for (int j = 0; j < solution.length; j++) {
      StringBuilder sb = new StringBuilder();

      for (int k = 0; k < solution[0].length; k++) {
        sb.append(solution[j][k]);
        if (k < solution[0].length - 1) {
          sb.append(" ");
        }
      }

      System.out.println(sb.toString());
    }
  }
}
