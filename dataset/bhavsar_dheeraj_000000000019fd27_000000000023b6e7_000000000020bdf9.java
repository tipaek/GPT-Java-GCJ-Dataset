import java.util.ArrayList;
import java.util.Scanner;

class Task {
  int startTime;
  int endTime;

  Task(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }
}

class Kid {
  String name;

  private ArrayList<Task> activeTasks = new ArrayList<>();

  Kid(String name) {
    this.name = name;
  }

  boolean canDoTask(Task task) {
    for (Task activeTask : this.activeTasks) {
      if (!((task.startTime <= activeTask.startTime && task.endTime <= activeTask.startTime)
          || (task.startTime >= activeTask.endTime && task.endTime >= activeTask.endTime))) {
        return false;
      }
    }
    return true;
  }

  void doTask(Task task) {
    this.activeTasks.add(task);
  }

}

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int testCases = scan.nextInt();

    String[] answers = new String[testCases];

    for (int testCase = 0; testCase < testCases; testCase++) {

      int taskCount = scan.nextInt();
      Task[] tasks = new Task[taskCount];

      Kid c = new Kid("C");
      Kid j = new Kid("J");

      String ans = "";

      for (int i = 0; i < taskCount; i++) {
        int start = scan.nextInt();
        int end = scan.nextInt();
        Task task = new Task(start, end);
        tasks[i] = task;
      }

      for (Task task : tasks) {
        if (c.canDoTask(task)) {
          c.doTask(task);
          ans += c.name;
        } else if (j.canDoTask(task)) {
          j.doTask(task);
          ans += j.name;
        } else {
          ans = "IMPOSSIBLE";
          break;
        }
      }

      answers[testCase] = ans;

    }

    for (int i = 1; i <= testCases; i++) {
      System.out.println("Case #" + i + ": " + answers[i - 1]);
    }

    scan.close();
  }
}