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
      A1 solver = new A1();
      solver.read(in);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class A1 implements Callable<String> {
  int n;
  List<String> p = new ArrayList<>();
  void read(Scanner in) {
    n = in.nextInt();
    for (int i=0; i<n; i++) {
      p.add(in.next());
    }
  }

  @Override
  public String call() throws Exception {
    String prefix = "";
    String suffix = "";
    StringBuilder result = new StringBuilder();
    for (int i=0; i<n; i++) {
      int s = -1;
      int e = -1;
      char[] str = p.get(i).toCharArray();
      for (int j=0; j<str.length; j++) {
        if(s == -1 && str[j] == '*') {
          s = j;
        }
        if (e == -1 && str[str.length-1-j] == '*') {
          e = str.length-1-j;
        }
      }
      for (int j=s+1; j<e; j++) {
        if (str[j] != '*') {
          result.append(str[j]);
        }
      }
      String pr = p.get(i).substring(0, s);
      if (pr.length() > prefix.length()) {
        if (pr.startsWith(prefix)) {
          prefix = pr;
        } else  {
          result = new StringBuilder("*");
          break;
        }
      } else {
        if (!prefix.startsWith(pr)) {
          result = new StringBuilder("*");
          break;
        }
      }

      String su = p.get(i).substring(e+1, str.length);
      if (su.length() > suffix.length()) {
        if (su.endsWith(suffix)) {
          suffix = su;
        } else  {
          result = new StringBuilder("*");
          break;
        }
      } else {
        if (!suffix.endsWith(su)) {
          result = new StringBuilder("*");
          break;
        }
      }
    }
    if (!result.toString().equals("*")) {
      StringBuilder sb = new StringBuilder(prefix);
      sb.append(result);
      sb.append(suffix);
      return sb.toString();
    }
    return result.toString();
  }
}