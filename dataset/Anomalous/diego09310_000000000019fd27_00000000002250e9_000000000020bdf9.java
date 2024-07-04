import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int numTasks = scanner.nextInt();

            List<Task> taskList = new ArrayList<>();

            for (int j = 0; j < numTasks; j++) {
                taskList.add(new Task(scanner.nextInt(), scanner.nextInt(), j));
            }
            Collections.sort(taskList);

            Scheduler cameron = new Scheduler('C');
            Scheduler jamie = new Scheduler('J');

            char[] schedule = new char[numTasks];
            boolean possible = true;

            for (Task task : taskList) {
                if (cameron.canSchedule(task)) {
                    cameron.schedule(task);
                    schedule[task.index] = cameron.getName();
                } else if (jamie.canSchedule(task)) {
                    jamie.schedule(task);
                    schedule[task.index] = jamie.getName();
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (t + 1) + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    static class Scheduler {
        private List<Task> scheduledTasks;
        private char name;

        public Scheduler(char name) {
            this.name = name;
            this.scheduledTasks = new ArrayList<>();
        }

        public char getName() {
            return name;
        }

        public void schedule(Task task) {
            scheduledTasks.add(task);
        }

        public boolean canSchedule(Task task) {
            for (Task scheduledTask : scheduledTasks) {
                if (task.overlapsWith(scheduledTask)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Task implements Comparable<Task> {
        private int start;
        private int end;
        private int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public boolean overlapsWith(Task other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }
}