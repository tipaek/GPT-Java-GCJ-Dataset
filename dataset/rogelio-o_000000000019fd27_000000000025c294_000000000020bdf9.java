import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static final int MINUTES_IN_THE_DAY = 24 * 60 * 60;

  private final Scanner in;

  public Solution(final Scanner in) {
    this.in = in;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final Solution solution = new Solution(in);
    int t = in.nextInt();

    for (int i = 1; i <= t; ++i) {
      System.out.println(solution.solve(i));
    }
  }

  public String solve(final int caseNum) {
    final int numTasks = in.nextInt();
    final List<Task> tasks = new ArrayList<>();

    for (int i = 0; i < numTasks; i++) {
      final int startTime = in.nextInt();
      final int endTime = in.nextInt();

      tasks.add(new Task(startTime, endTime));
    }

    return String.format("Case #%d: %s", caseNum, solve(tasks));
  }

  private String solve(final List<Task> tasks) {
    final Person cameron = new Person("C");
    final Person jamie = new Person("J");
    boolean result = solve(0, tasks, Arrays.asList(cameron, jamie));

    if (result) {
      return parseOutput(tasks);
    } else {
      return "IMPOSSIBLE";
    }
  }

  private boolean solve(final int index, final List<Task> tasks, final List<Person> personList) {
    if (index >= tasks.size()) {
      return true;
    }

    final Task nextTask = tasks.get(index);

    for (final Person person : personList) {
      if (person.canBeOwnerOf(nextTask)) {
        nextTask.setOwner(person.getCode());
        person.addTask(nextTask);
        if (solve(index + 1, tasks, personList)) {
          return true;
        }
        nextTask.setOwner(null);
        person.removeTask(nextTask);
      }
    }

    return false;
  }

  private String parseOutput(final List<Task> tasks) {
    final StringBuilder builder = new StringBuilder();

    for (final Task task : tasks) {
      builder.append(task.getOwner());
    }

    return builder.toString();
  }

  public static class Person {

    private final boolean[] busy = new boolean[MINUTES_IN_THE_DAY];

    private final String code;

    public Person(final String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }

    public void addTask(final Task task) {
      for (int i = task.getStartTime(); i < task.getEndTime(); i++) {
        busy[i] = true;
      }
    }

    public void removeTask(final Task task) {
      for (int i = task.getStartTime(); i < task.getEndTime(); i++) {
        busy[i] = false;
      }
    }

    public boolean canBeOwnerOf(final Task task) {
      for (int i = task.getStartTime(); i <= task.getEndTime(); i++) {
        if (busy[i]) {
          return false;
        }
      }

      return true;
    }

  }

  public static class Task {

    private final int startTime;

    private final int endTime;

    private String owner;

    public Task(final int startTime, final int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public int getStartTime() {
      return startTime;
    }

    public int getEndTime() {
      return endTime;
    }

    public void setOwner(final String owner) {
      this.owner = owner;
    }

    public String getOwner() {
      return this.owner;
    }

  }

}