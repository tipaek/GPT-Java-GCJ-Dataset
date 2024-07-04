import java.util.ArrayList;
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
      Q3 solver = new Q3();
      solver.read(in, i+1);
      System.out.println("Case #" + (i+1) + ": " + solver.call());
    }
  }
}

class Q3 implements Callable<String> {
  int n;
  List<Activity> a = new ArrayList<>();
  class Activity {
    int index;
    int start;
    int end;
    char p;
    public Activity(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }
  }
  void read(Scanner in, int kase) {
    n = in.nextInt();
    for (int i=0; i<n; i++) {
      a.add(new Activity(i,in.nextInt(), in.nextInt()));
    }
  }

  @Override
  public String call() throws Exception {
    a.sort(Comparator.comparingInt((Activity l) -> l.start).thenComparingInt(l -> l.end));
    int end[] = {0, 0};
    char[] p = {'C', 'J'};
    int index = 0;
    boolean found = true;
    for (Activity ac : a) {
      if (ac.start >= end[index]) {
        ac.p = p[index];
        end[index] = ac.end;
      } else {
        index = (index+1)%2;
        if (ac.start >= end[index]) {
          ac.p = p[index];
          end[index] = ac.end;
        } else {
          found = false;
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    if (found) {
      a.sort(Comparator.comparingInt(l -> l.index));
      for (Activity ac : a)  {
        sb.append(ac.p);
      }
    } else {
      sb.append("IMPOSSIBLE");
    }
    return sb.toString();
  }
}
