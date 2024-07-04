
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
    StringBuilder result = new StringBuilder();

    Deque<String> workerPool = new ArrayDeque<>();
    workerPool.add("C");
    workerPool.add("J");

    Deque<Work> finishedWork = new ArrayDeque<>();
    List<Work> activeJobs = new ArrayList<>();
    for (int time = 0; time <= 1440; time++) {
      // first remove finished work and return workers to pool
      for (Work cur: activeJobs) {
        if (cur.payload.end == time) {
          finishedWork.push(cur);
        }
      }
      while (!finishedWork.isEmpty()) {
        Work cur = finishedWork.pop();
        workerPool.offer(cur.worker);
        activeJobs.remove(cur);
      }

      // then check if any interval starts at this minute
      for (Interval i : intervals) {
        if (i.start == time) {
          if (workerPool.isEmpty()) {
            return "IMPOSSIBLE";
          } else {
            Work job = new Work(workerPool.poll(), i);
            activeJobs.add(job);
            result.append(job.worker);
          }
        }
      }
    }
    return result.toString();
  }

  private static class Work {
    final String worker;
    final Interval payload;

    public Work(String worker, Interval payload) {
      this.worker = worker;
      this.payload = payload;
    }
  }

  private static class Interval {
    final int index;
    final int start;
    final int end;

    public Interval(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }
  }
}
