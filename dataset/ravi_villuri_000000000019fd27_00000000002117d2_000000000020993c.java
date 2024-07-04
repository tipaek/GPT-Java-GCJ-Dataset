import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;

public class Solution {
  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    /*
    List<Future<Integer>> result = new ArrayList<>();
    ExecutorService executorService = Executors.newFixedThreadPool(100);
    for (int i=0; i<T; i++) {
      R1A_A solver = new R1A_A();
      solver.read(in, i+1);
      result.add(executorService.submit(solver));
    }
    for (int i=1; i<=T; i++) {
      System.out.println("Case #" + i + ": " + result.get(i-1).get());
    }
    executorService.shutdown();

     */
    for (int i=0; i<T; i++) {
      Q1 solver = new Q1();
      solver.read(in, i+1);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class Q1 implements Callable<String> {
  int n;
  int[][] g;
  void read(Scanner in, int kase) {
    n = in.nextInt();
    g = new int[n][n];
    for (int i=0; i<n; i++) {
      for (int j =0; j<n; j++) {
        g[i][j] = in.nextInt();
      }
    }
  }

  @Override
  public String call() throws Exception {
    int k=0, r=0, c=0;
    for (int i=0; i<n; i++) {
      Set<Integer> rows = new HashSet<>();
      Set<Integer> cols = new HashSet<>();
      for (int j=0; j<n; j++) {
        if (i==j) {
          k += g[i][j];
        }
        rows.add(g[i][j]);
        cols.add(g[j][i]);
      }
      if (rows.size() != n) {
        r++;
      }
      if (cols.size() != n) {
        c++;
      }
    }
    return k + " " + r + " " + c;
  }
}
