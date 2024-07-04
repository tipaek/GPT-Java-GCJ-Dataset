import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

  static class Task {
    int index;
    int startTime;
    int endTime;
    String whoIsDoingIt;

    public Task(int index, int startTime, int endTime) {
      this.index = index;
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; ++i) {
      int taskCount = sc.nextInt();
      List<Task> tasks = new ArrayList<>();
      for (int j = 0; j < taskCount; ++j) {
        int s = sc.nextInt();
        int e = sc.nextInt();
        Task task = new Task(j, s, e);
        tasks.add(task);
      }
      String ans = solve(tasks);
      System.out.println("Case #" + (i + 1) + ": " + ans);
    }
  }

  private static String solve(List<Task> tasks) {
    tasks.sort(Comparator.comparingInt(o -> o.startTime));
    PriorityQueue<Task> taskPriorityQueue =
        new PriorityQueue<>((o1, o2) -> o2.endTime - o1.endTime);
    for (Task task : tasks) {
      if (taskPriorityQueue.isEmpty()) {
        task.whoIsDoingIt = "C";
        taskPriorityQueue.add(task);
      } else {
        Task poll1 = taskPriorityQueue.poll();
        if (poll1.endTime > task.startTime) {
          Task poll2 = taskPriorityQueue.poll();
          if (poll2 != null && poll2.endTime > task.startTime) {
            return "IMPOSSIBLE";
          } else {
            task.whoIsDoingIt =
                poll2 != null
                    ? poll2.whoIsDoingIt
                    : poll1.whoIsDoingIt.equalsIgnoreCase("C") ? "J" : "C";
            taskPriorityQueue.add(poll1);
            taskPriorityQueue.add(task);
          }
        } else {
          task.whoIsDoingIt = poll1.whoIsDoingIt;
          taskPriorityQueue.add(task);
        }
      }
    }
    tasks.sort(Comparator.comparingInt(o1 -> o1.index));
    StringBuilder sequence = new StringBuilder();
    for (Task t : tasks) {
      sequence.append(t.whoIsDoingIt);
    }
    return sequence.toString();
  }
}
