import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  private Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  private void solve() throws Exception {
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    int[] columns[] = new int[n][n];
    for (int i = 0; i < n; i++) {
      int row[] = new int[n];
      for (int j = 0; j < n; j++) {
        row[j] = sc.nextInt();
      }
      columns[i] = row;
    }
    // trace
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += columns[i][i];
    }
    int badrows = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> s = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (s.contains(columns[i][j])) {
          badrows++;
          break;
        }
        s.add(columns[i][j]);
      }
    }
    int badcols = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> s = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (s.contains(columns[j][i])) {
          badcols++;
          break;
        }
        s.add(columns[j][i]);
      }
    }
    sb.append(sum).append(" ").append(badrows).append(" ").append(badcols);
    System.out.print(sb.toString());
  }

  private void run() throws Exception {
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      System.out.print("Case #" + i + ": ");
      solve();
      System.out.println();
    }
    sc.close();
    System.out.close();
  }


  public static void main(String[] args) throws Exception {
    new Solution().run();
  }

}