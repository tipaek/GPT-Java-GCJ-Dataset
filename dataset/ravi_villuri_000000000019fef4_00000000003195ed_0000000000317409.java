import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
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
      C1 solver = new C1();
      solver.read(in);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class C1 implements Callable<String> {
  int x, y;
  String r1;
  void read(Scanner in) {
    x = in.nextInt();
    y = in.nextInt();
    r1 = in.next();
  }
  @Override
  public String call() throws Exception {
    char[] r = r1.toCharArray();
    String ret = "IMPOSSIBLE";

    for (int i=0; i<r1.length(); i++) {
      if(r[i] == 'E') {
        x++;
      }
      else if(r[i] == 'W') {
        x--;
      }
      else if(r[i] == 'N') {
        y++;
      }
      else {
        y--;
      }
      if(Math.abs(x)+Math.abs(y) <= i+1) {
        ret = Integer.toString(i+1);
        break;
      }
    }
    return ret;
  }
}