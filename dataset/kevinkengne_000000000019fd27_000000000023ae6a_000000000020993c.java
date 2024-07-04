import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int caseNum = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ks = 1; ks <= caseNum; ++ks) {
      List<String> ans = solve(in);
      System.out.println("Case #" + ks + ": " + ans.get(0) + " " + ans.get(1) + " " + ans.get(2));
    }
  }

  public static List<String> solve(Scanner in) {
      List<String> ans = new ArrayList<>();
      int N = in.nextInt();
      int[][] grid = new int[N][N];
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              grid[i][j] = in.nextInt();
          }
      }
      ans.add(solveTrace(grid));
      ans.add(solveRows(grid));
      ans.add(solveCols(grid));
      return ans;
  }
  
  public static String solveRows(int[][] grid) {
    int count = 0;
     for (int i = 0; i < grid.length; i++) {
         Set<Integer> check = new HashSet<>();
         for (int j = 0; j < grid[0].length; j++) {
            if (!check.add(grid[i][j])) {
                count++;
                break;
            }
         }
     }
    return String.valueOf(count);
  }

  public static String solveCols(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
        Set<Integer> check = new HashSet<>();
        for (int j = 0; j< grid.length; j++) {
            if (!check.add(grid[j][i])) {
                count++;
                break;
            }
        }
    }
    return String.valueOf(count);
  }

  public static String solveTrace(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (i == j) count += grid[i][j];
        }
    } 
    return String.valueOf(count);
  }


  
  
}