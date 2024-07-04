import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;

import static java.lang.Math.min;

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
    /*
    for (int i=0; i<100; i++) {
      for (int j=0; j<100; j++) {
        B1 solver = new B1();
        solver.x = i;
        solver.y = j;
        System.out.println(i +", "+j);
        System.out.println(solver.call());
      }
    }
     */
    for (int i=0; i<T; i++) {
      C3 solver = new C3();
      solver.read(in);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}
class C3 implements Callable<String> {
  int n,d;
  long[] a;
  void read(Scanner in) {
    n = in.nextInt();
    d = in.nextInt();
    a = new long[n];
    for (int i=0; i<n; i++) {
      a[i] = in.nextLong();
    }
  }
  @Override
  public String call() throws Exception {
    Arrays.sort(a);
    int ret = d-1;
    for (int i=0; i<n; i++) {
      int c=0;
      long rd = d-1;
      for (int j=i+1; j<n && rd>0; j++) {
        long slices = a[j]/a[i];
        if (slices <= rd) {
          if (a[j]%a[i] == 0) {
            c += slices - 1;
          } else {
            c += slices;
          }
          rd -= slices;
        } else {
          c += rd;
          rd = 0;
        }
      }
      if (rd == 0) {
        ret = Math.min(ret, c);
      }
    }
    return Integer.toString(ret);
  }
}
