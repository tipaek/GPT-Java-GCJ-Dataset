import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Solution {

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
    Optional<String> result = solve(0, tasks, Arrays.asList(cameron, jamie), "");

    return result.orElse("IMPOSSIBLE");
  }

  private Optional<String> solve(final int index, final List<Task> tasks, final List<Person> personList, final String partial) {
    if (index >= tasks.size()) {
      return Optional.of(partial);
    }

    final Task nextTask = tasks.get(index);

    for (final Person person : personList) {
      if (person.canBeOwnerOf(nextTask)) {
        final String newPartial = partial + person.getCode();
        person.addTask(nextTask);
        final Optional<String> personResult = solve(index + 1, tasks, personList, newPartial);
        if (personResult.isPresent()) {
          return personResult;
        }
        person.undoneAddTask();
      }
    }

    return Optional.empty();
  }

  public static class Person {

    private final LinkedList<Task> tasks = new LinkedList<>();

    private final String code;

    public Person(final String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }

    public void addTask(final Task task) {
      tasks.add(task);
    }

    public void undoneAddTask() {
      tasks.removeLast();
    }

    public boolean canBeOwnerOf(final Task task) {
      for (final Task otherTask : tasks) {
        if (otherTask.isOverlapped(task)) {
          return false;
        }
      }

      return true;
    }

  }

  public static class Task {

    private final int startTime;

    private final int endTime;

    public Task(final int startTime, final int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public boolean isOverlapped(final Task otherTask) {
      return isDuring(otherTask) || otherTask.isDuring(this);
    }

    private boolean isDuring(final Task otherTask) {
      return (this.startTime < otherTask.endTime && otherTask.startTime <= this.startTime);
    }

  }

}