import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {


  public static void main(String[] args) {
    Scanner in = new Scanner(
        new BufferedReader(new InputStreamReader(System.in))
    );
    int t = in.nextInt();
    for (int a = 1; a <= t; ++a) {
      int size = in.nextInt();
      final Schedule schedule = new Schedule(t, size);
      for (int i = 0; i < size; i++) {

        final int start = in.nextInt();
        final int end = in.nextInt();
        Task task = new Task(i, start, end);
        schedule.add(task);
      }
      schedule.solve();
      Printer.print(schedule);
    }
  }
}

class Task {

  public Task(int id, int start, int end) {
    this.id = id;
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Task{" +
        "id=" + id +
        ", start=" + start +
        ", end=" + end +
        ", doer=" + doer +
        '}';
  }

  int id;
  int start;
  int end;
  Person doer;

  void assignTo(Person p) {
    this.doer = p;
    p.availableFrom = this.end;
  }
}

class Schedule {

  int id;
  int size;
  private PriorityQueue<Task> tasksQueue;
  Task[] tasks;


  public Schedule(int id, int size) {
    this.id = id;
    this.size = size;
    this.tasks = new Task[size];
    this.tasksQueue = new PriorityQueue<>(Comparator.comparing(task -> task.start));
  }

  void add(Task task) {
    tasksQueue.add(task);
    tasks[task.id] = task;
  }

  void solve() {
    solve(this.tasksQueue);
    Person.reset();
  }

  void solve(PriorityQueue<Task> taskQueue) {
    if (taskQueue.isEmpty()) {
      return;
    }
    final Task poll = taskQueue.poll();
    for (Person p : Person.values()) {
      if (p.canDo(poll)) {
        final int availableFrom = p.availableFrom;
        poll.assignTo(p);
        solve(taskQueue);
        if (taskQueue.isEmpty()) {
          return;
        } else {
          p.availableFrom = availableFrom;
        }
      }
    }
    taskQueue.add(poll);
    return;
  }


  public String toString() {
    if (tasksQueue.isEmpty()) {
      return
          Arrays.stream(tasks)
              .map(it -> it.doer.name).collect(Collectors.joining());
    } else {
      return "IMPOSSIBLE";
    }
  }


}

enum Person {

  C("C"), J("J");


  Person(String name) {
    this.name = name;
  }

  public String name;
  int availableFrom = 0;

  public boolean canDo(Task task) {
    return task.start >= availableFrom;
  }

  static void reset() {
    C.availableFrom = 0;
    J.availableFrom = 0;
  }
}


class Printer {


  static void print(Schedule d) {
    System.out.println("Case #" + d.id + ": " + d.toString());
  }


}

