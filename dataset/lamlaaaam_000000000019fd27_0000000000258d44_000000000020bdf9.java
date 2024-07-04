import java.util.*;
import java.io.*;

public class Solution {
  static class Task implements Comparable<Task> {
    int start, end;
    char taken = '0';
    public Task(int s, int e) {
      start = s;
      end = e;
    }
    public int compareTo(Task o) {
      return this.start - o.start;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int k = 1; k <= t; ++k) {
      PriorityQueue<Task> q = new PriorityQueue<>();
      StringBuilder res = new StringBuilder();
      List<Task> C = new ArrayList<>();
      List<Task> J = new ArrayList<>();
      int tasks = in.nextInt();
      boolean impossible = false;
      Task[] taskArr = new Task[tasks];
      for (int i = 0; i < tasks; ++i) {
        Task task = new Task(in.nextInt(), in.nextInt());
        q.add(task);
        taskArr[i] = task;
      }
      while (!q.isEmpty()) {
        Task task = q.poll();
        int start = task.start;
        int end = task.end;
        if (impossible) continue;
        boolean cCanTake = true;
        boolean jCanTake = true;
        for (Task pair : J) {
          if (start < pair.end && pair.start < end) {
                jCanTake = false;
                break;
          }
        }
        if (jCanTake) {
          J.add(task);
          task.taken = 'J';
          continue;
        } else {
          for (Task pair : C) {
            if (start < pair.end && pair.start < end) {
              cCanTake = false;
              break;
            }
          }
          if (cCanTake) {
            C.add(task);
            task.taken = 'C';
            continue;
          } else {
            impossible = true;
            continue;
          }
        }
      }
      for (int p = 0; p < taskArr.length; ++p) {
        res.append(taskArr[p].taken);
      }
      if (impossible) System.out.println("Case #" + k + ": IMPOSSIBLE");
      else System.out.println("Case #" + k + ": " + res.toString());
    }
  }
}