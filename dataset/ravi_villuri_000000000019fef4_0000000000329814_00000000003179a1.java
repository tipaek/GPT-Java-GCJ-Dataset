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
      C2 solver = new C2();
      solver.read(in);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class C2 implements Callable<String> {
  int MX = 10000;
  int u;
  long[] m = new long[MX];
  String[] r = new String[MX];
  void read(Scanner in) {
    u = in.nextInt();
    for (int i=0; i<MX; i++) {
      m[i] = in.nextLong();
      r[i] = in.next();
    }
  }
  @Override
  public String call() throws Exception {
    Map<Character, Integer> cnt = new HashMap<>();
    Set<Character> s = new HashSet<>();
    for (int i=0; i<MX; i++) {
      char c = r[i].charAt(0);
      for (int j=0; j<r[i].length(); j++) {
        s.add(r[i].charAt(j));
      }
      if (!cnt.containsKey(c)) {
        cnt.put(c, 0);
      }
      cnt.put(c, cnt.get(c)+1);
    }
    StringBuilder ret = new StringBuilder();
    for (int i=0; i<cnt.size(); i++) {
      int mx = -1;
      char t='x';
      for (Map.Entry<Character, Integer> e : cnt.entrySet()) {
        if (e.getValue() > mx) {
          mx = e.getValue();
          t = e.getKey();
        }
      }
      ret = ret.append(t);
      cnt.put(t,-1);
    }
    for (char e : s) {
      if (!cnt.containsKey(e)) {
        ret.insert(0, e);
      }
    }
    return ret.toString();
  }
}