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
    for (int i=0; i<T; i++) {
      B1 solver = new B1();
      solver.read(in);
      System.out.println("Case #" + (i+1) + ": \n" + solver.call());
    }
  }
}

class B3 implements Callable<String> {
  void read(Scanner in) {

  }
  @Override
  public String call() throws Exception {
    return null;
  }
}

class B2 implements Callable<String> {
  void read(Scanner in) {

  }
  @Override
  public String call() throws Exception {
    return null;
  }
}

class B1 implements Callable<String> {
  long x, y;
  String result;
  void read(Scanner in) {
    x = in.nextInt();
    y = in.nextInt();
  }
  @Override
  public String call() throws Exception {
    f(0,0, 1, new StringBuilder(""));
    if (result == null) {
      return "IMPOSSIBLE";
    }
    return result;
  }

  void f(long x, long y, long jump, StringBuilder sb) {
    if (Math.abs(x) > 2*Math.abs(this.x) || Math.abs(y) >2* Math.abs(this.y)) {
      return;
    }
    if (x == this.x && y==this.y) {
      if(result == null || result.length() > sb.length()) {
        result = sb.toString();
      }
      return;
    }
    if ((this.x-x)%jump!=0 && (this.y-y)%jump!=0) {
      return;
    }
    long newJump = jump*2;
    f(x + jump, y, newJump, sb.append("E"));
    sb.deleteCharAt(sb.length() - 1);
    f(x - jump, y, newJump, sb.append("W"));
    sb.deleteCharAt(sb.length() - 1);
    f(x, y + jump, newJump, sb.append("N"));
    sb.deleteCharAt(sb.length() - 1);
    f(x, y - jump, newJump, sb.append("S"));
    sb.deleteCharAt(sb.length() - 1);
  }
}