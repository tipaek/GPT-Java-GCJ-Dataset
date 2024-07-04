import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
      Q5 solver = new Q5();
      solver.read(in);
      System.out.print("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class Q5 implements Callable<String> {
  int n,k;
  void read(Scanner in) {
    n = in.nextInt();
    k = in.nextInt();
  }

  @Override
  public String call() throws Exception {
    boolean pos = true;
    List<List<Integer>> ans = new ArrayList<>();
    if ((n<4 && (k%n)!=0) || k==n+1 || k==n*n-1) {
      pos = false;
    }
    if (pos) {
      int a = 0, b = 0, c = 0;
      if (n < 4) {
        a = b = c = k / n;
      } else {
        int p = k;
        for (int i = Math.max(1, k / n - 1); i <= Math.min(n, k / n - 1 + 2); i++) {
          for (int j = 1; j <= n; j++) {
            int l = k - (n - 2) * i - j;
            if (l >= 1 && l <= n && (j != i && l != i) || (i == j && j == l)) {
              a = i;
              b = j;
              c = l;
            }
          }
        }
      }
      List<Integer> first = new ArrayList<>();
      Set<Integer> s = new HashSet<>();
      s.add(a);
      s.add(b);
      s.add(c);
      first.add(a);

      if (a != b) {
        first.add(b);
      }

      for (int i = 1; i <= n; i++) {
        if (!s.contains(i)) {
          first.add(i);
        }
      }
      if (b != c) {
        first.add(c);
      }
      if (a != b) {
        if (b != c) {
          ans = rotate(first, first.size());
          ans.add(0, ans.remove(1));
        } else {
          ans = rotate(first, first.size() - 3);
          List<Integer> l = new ArrayList<>();
          l.add(first.get(1));
          for (int i=3; i<n-1; i++) {
            l.add(first.get(i));
          }
          l.add(first.get(0));
          l.add(first.get(n-1));
          l.add(first.get(2));
          ans.add(l);

          l=new ArrayList<>();
          l.add(first.get(2));
          int cs = 3;
          for(int i=0; i<n-3; i++) {
            if (i < n-4) {
              l.add(first.get(cs+1));
              l.add(first.get(cs));
              i++;
              cs += 2;
            } else {
              l.add(first.get(cs));
              cs++;
            }
          }
          l.add(first.get(1));
          l.add(first.get(0));
          ans.add(l);

          l=new ArrayList<>();
          cs = 2;
          for(int i=0; i<n-2; i++) {
            if (i < n-3) {
              l.add(first.get(cs+1));
              l.add(first.get(cs));
              i++;
              cs += 2;
            } else {
              l.add(first.get(cs));
              cs++;
            }
          }
          l.add(first.get(0));
          l.add(first.get(1));
          ans.add(l);
        }
      } else {
        ans = rotate(first, first.size());
      }
    }
    StringBuilder sb  = new StringBuilder();
    if (pos) {
      sb.append("POSSIBLE");
      sb.append("\n");
      for (List<Integer> l1 : ans) {
        for(int i1 : l1) {
          sb.append(i1 + " ");
        }
        sb.append("\n");
      }
      return sb.toString();
    }
    return "IMPOSSIBLE"+"\n";
  }
  List<List<Integer>> rotate(List<Integer> input, int n) {
    List<Integer> l = new ArrayList<>(input);
    List<List<Integer>> ans = new ArrayList<>();
    for(int i=0; i<n; i++) {
      ans.add(new ArrayList<>(l));
      l.add(0, l.remove(l.size()-1));
    }
    return ans;
  }
}