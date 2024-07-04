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
      Q2 solver = new Q2();
      solver.read(in, i+1);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class Q2 implements Callable<String> {
  String s;
  void read(Scanner in, int kase) {
    s = in.next();
  }

  @Override
  public String call() throws Exception {
    StringBuilder sb = new StringBuilder();
    int cur = 0;
    for (char c : s.toCharArray()) {
      for(;cur<c-'0'; cur++) {
        sb.append('(');
      }
      for(;cur>c-'0'; cur--) {
        sb.append(')');
      }
      sb.append(c);
    }
    for(;cur>0; cur--) {
      sb.append(')');
    }
    return sb.toString();
  }
}