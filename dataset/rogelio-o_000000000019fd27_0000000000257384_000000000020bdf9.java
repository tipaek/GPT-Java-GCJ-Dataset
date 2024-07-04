import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

  private static final String CAMERON = "C";

  private static final String JAMIE = "J";

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

      tasks.add(new Task(i, startTime, endTime));
    }

    return String.format("Case #%d: %s", caseNum, solve(tasks));
  }

  private String solve(final List<Task> tasks) {
    tasks.sort(Comparator.comparingInt(Task::getStartTime));

    boolean result = solve(0, tasks, null, null);

    if (result) {
      return parseOutput(tasks);
    } else {
      return "IMPOSSIBLE";
    }
  }

  private boolean solve(final int index, final List<Task> tasks, final Task prevTaskOfCameron, final Task prevTaskOfJamie) {
    if (index >= tasks.size()) {
      return true;
    }

    final Task nextTask = tasks.get(index);

    if (prevTaskOfCameron == null || !prevTaskOfCameron.isOverlapped(nextTask)) {
      nextTask.setOwner(CAMERON);
      if (solve(index + 1, tasks, nextTask, prevTaskOfJamie)) {
        return true;
      }
      nextTask.setOwner(null);
    }

    if (prevTaskOfJamie == null || !prevTaskOfJamie.isOverlapped(nextTask)) {
      nextTask.setOwner(JAMIE);
      if (solve(index + 1, tasks, prevTaskOfCameron, nextTask)) {
        return true;
      }
      nextTask.setOwner(null);
    }

    return false;
  }

  private String parseOutput(final List<Task> tasks) {
    return tasks.stream()
      .sorted(Comparator.comparingInt(Task::getId))
      .map(Task::getOwner)
      .collect(Collectors.joining());
  }

  public static class Task {

    private final int id;

    private final int startTime;

    private final int endTime;

    private String owner;

    public Task(final int id, final int startTime, final int endTime) {
      this.id = id;
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public boolean isOverlapped(final Task otherTask) {
      return isDuring(otherTask) || otherTask.isDuring(this);
    }

    private boolean isDuring(final Task otherTask) {
      return (this.startTime < otherTask.endTime && otherTask.startTime <= this.startTime);
    }

    public int getId() {
      return this.id;
    }

    public int getStartTime() {
      return startTime;
    }

    public void setOwner(final String owner) {
      this.owner = owner;
    }

    public String getOwner() {
      return this.owner;
    }

  }
  
}