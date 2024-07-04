import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        int caseNumber = 1;

        while (in.hasNextLine()) {
            boolean feasible = true;
            List<Task> camTasks = new ArrayList<>();
            List<Task> jamTasks = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            int N = in.nextInt();
            in.nextLine();

            while (N > 0) {
                String currentTask = in.nextLine();
                Scanner taskScanner = new Scanner(currentTask);
                Task task = new Task(taskScanner.nextInt(), taskScanner.nextInt());
                N--;

                boolean assigned = false;

                if (canAssignTask(camTasks, task)) {
                    camTasks.add(task);
                    schedule.append("C");
                    assigned = true;
                } else if (canAssignTask(jamTasks, task)) {
                    jamTasks.add(task);
                    schedule.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    feasible = false;
                }
            }

            if (!feasible) {
                System.out.println("Case #" + caseNumber++ + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber++ + ": " + schedule);
            }

            camTasks.clear();
            jamTasks.clear();
        }
    }

    private static boolean canAssignTask(List<Task> tasks, Task newTask) {
        for (Task task : tasks) {
            if (task.conflicts(newTask)) {
                return false;
            }
        }
        return true;
    }

    public static class Task {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean conflicts(Task other) {
            return !(this.end <= other.start || this.start >= other.end);
        }

        @Override
        public String toString() {
            return "Start: " + start + " End: " + end;
        }
    }
}