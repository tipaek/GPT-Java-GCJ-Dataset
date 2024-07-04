import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(reader.readLine());
        Scheduler scheduler = new Scheduler();
        for (int i = 1; i <= testCount; i++) {
            scheduler.processTestCase(i, reader);
        }
    }

    static class Scheduler {

        public void processTestCase(int caseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();
            int taskCount = Integer.parseInt(reader.readLine());
            boolean cameronBusy = false;
            boolean impossible = false;

            List<Task> tasks = new ArrayList<>();
            List<Task> originalTasks = new ArrayList<>();
            for (int i = 0; i < taskCount; i++) {
                Task task = new Task(reader.readLine().split(" "));
                tasks.add(task);
                originalTasks.add(task);
            }
            tasks.sort(Comparator.comparingInt(task -> task.end));

            for (Task task : tasks) {
                if (!impossible) {
                    cameronBusy = cameronTasks.stream().anyMatch(t -> t.conflictsWith(task));

                    if (cameronBusy) {
                        boolean jamieBusy = jamieTasks.stream().anyMatch(t -> t.conflictsWith(task));
                        if (jamieBusy) {
                            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                            impossible = true;
                        } else {
                            jamieTasks.add(task);
                            assignLetterToTask(originalTasks, task, "J");
                        }
                    } else {
                        cameronTasks.add(task);
                        assignLetterToTask(originalTasks, task, "C");
                    }
                }
            }

            if (!impossible) {
                for (Task task : originalTasks) {
                    result.append(task.letter);
                }
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }

        private void assignLetterToTask(List<Task> tasks, Task task, String letter) {
            for (Task originalTask : tasks) {
                if (originalTask.start == task.start && originalTask.end == task.end) {
                    originalTask.letter = letter;
                }
            }
        }
    }
}

class Task {
    int start;
    int end;
    String letter = "X";

    public Task(String[] timeRange) {
        this.start = Integer.parseInt(timeRange[0]);
        this.end = Integer.parseInt(timeRange[1]);
    }

    boolean conflictsWith(Task other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}