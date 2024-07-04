
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
      String result = solveNext(ks, in);
      System.out.println("Case #"+ks+": " + result);
    }
  }
  
  public static String solveNext(int ks, Scanner in) {
    StringBuilder result = new StringBuilder();
    int N = Integer.parseInt(in.nextLine());
    List<Interval> intervals = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String[] activity = in.nextLine().split(" ");
      intervals.add(new Interval(i, Integer.parseInt(activity[0]), Integer.parseInt(activity[1])));
    }

    ArrayDeque<String> workerPool = new ArrayDeque<>();
    workerPool.add("C");
    workerPool.add("J");
    
    ArrayDeque<Work> finishedWork = new ArrayDeque<>();
    List<Work> activeWork = new ArrayList<>();
    for (int time = 0; time <= 1440; time++) {
      // first remove finished work and return workers to pool
      for (Work cur: activeWork) {
        if (cur.payload.end == time) {
          finishedWork.push(cur);
        }
      }
      while (!finishedWork.isEmpty()) {
        Work cur = finishedWork.pop();
        activeWork.remove(cur);
        workerPool.add(cur.worker);
      }

      // then check if any interval starts at this minute
      for (Interval i : intervals) {
        if (i.start == time) {
          if (workerPool.size() == 0) {
            return "IMPOSSIBLE";
          } else {
            Work job = new Work(workerPool.pop(), i);
            activeWork.add(job);
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

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Work work = (Work) o;
      return Objects.equals(worker, work.worker) &&
          Objects.equals(payload, work.payload);
    }

    @Override
    public int hashCode() {
      return Objects.hash(worker, payload);
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

    public int getIndex() {
      return index;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Interval interval = (Interval) o;
      return index == interval.index &&
          start == interval.start &&
          end == interval.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(index, start, end);
    }

    @Override
    public String toString() {
      return '{' + index + ", " + start + ", " + end + '}';
    }
  }
}
