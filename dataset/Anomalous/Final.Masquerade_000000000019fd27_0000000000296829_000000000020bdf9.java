import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        TaskSolver solver = new TaskSolver();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader);
        }
    }

    static class TaskSolver {

        public void solve(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cameronTasks = new ArrayList<>();
            ArrayList<Interval> jamieTasks = new ArrayList<>();
            int taskCount = Integer.parseInt(reader.readLine());
            boolean isCameronBusy = false;
            boolean isImpossible = false;

            ArrayList<Interval> tasks = new ArrayList<>();
            ArrayList<Interval> originalTasks = new ArrayList<>();
            for (int i = 0; i < taskCount; i++) {
                Interval task = new Interval(reader.readLine().split(" "));
                tasks.add(task);
                originalTasks.add(task);
            }
            tasks.sort(Comparator.comparingInt(task -> task.end));

            for (int i = 0; i < taskCount; i++) {
                Interval currentTask = tasks.get(i);
                if (!isImpossible) {
                    for (Interval task : cameronTasks) {
                        if (task.isOverlapping(currentTask)) {
                            isCameronBusy = true;
                            break;
                        }
                    }

                    if (isCameronBusy) {
                        for (Interval task : jamieTasks) {
                            if (task.isOverlapping(currentTask)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jamieTasks.add(currentTask);
                            updateOriginalTask(originalTasks, currentTask, "J");
                        }
                    } else {
                        cameronTasks.add(currentTask);
                        updateOriginalTask(originalTasks, currentTask, "C");
                    }

                    isCameronBusy = false;
                }
            }

            if (!isImpossible) {
                for (Interval task : originalTasks) {
                    result.append(task.assignedTo);
                }
                System.out.println("Case #" + testCaseNumber + ": " + result);
            }
        }

        private void updateOriginalTask(ArrayList<Interval> originalTasks, Interval currentTask, String assignedTo) {
            for (Interval task : originalTasks) {
                if (task.start == currentTask.start && task.end == currentTask.end && task.assignedTo.equals("X")) {
                    task.assignedTo = assignedTo;
                    break;
                }
            }
        }
    }
}

class Interval {
    int start;
    int end;
    String assignedTo = "X";

    public Interval(String[] times) {
        start = Integer.parseInt(times[0]);
        end = Integer.parseInt(times[1]);
    }

    boolean isOverlapping(Interval other) {
        return !(end <= other.start || start >= other.end);
    }
}