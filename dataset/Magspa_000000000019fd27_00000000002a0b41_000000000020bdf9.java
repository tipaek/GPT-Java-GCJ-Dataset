
import java.io.*;
import java.util.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    solve(in);
  }

  public static void solve(Scanner in) {
    int T = Integer.parseInt(in.nextLine()); // numTests
    for(int ks = 1; ks <= T; ks++) {
      int N = Integer.parseInt(in.nextLine());
      List<Interval> intervals = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        String[] activity = in.nextLine().split(" ");
        intervals.add(new Interval(i, Integer.parseInt(activity[0]), Integer.parseInt(activity[1])));
      }

      String result = solveNext(ks, intervals);
      System.out.println("Case #"+ks+": " + result);
    }
  }

  public static String solveNext(int ks, List<Interval> intervals) {

    Deque<String> workers = new ArrayDeque<>();
    workers.addAll(Arrays.asList("C", "J"));
    Deque<Interval> active = new ArrayDeque<>();
    
    for (int time = 0; time <= 1440; time++) {
      // first remove finished work and return workers to pool
      for (Interval cur: active) {
        if (cur.end == time) {
          workers.push(cur.worker);
          active.remove(cur);
        }
      }
      
      // then check if any interval starts at this minute
      for (Interval i : intervals) {
        if (i.start == time) {
          if (workers.isEmpty()) {
            return "IMPOSSIBLE";
          } else {
            i.worker = workers.pop();
            active.add(i);
          }
        }
      }
    }

    StringBuilder result = new StringBuilder();
    for (Interval i: intervals) {
      result.append(i.worker);
    }
    return result.toString();
  }

  private static class Interval {
    final int index;
    final int start;
    final int end;
    
    String worker;

    public Interval(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }
  }
}
