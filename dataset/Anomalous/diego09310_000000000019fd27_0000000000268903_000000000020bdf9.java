import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int numTasks = scanner.nextInt();
            List<TimeFrame> tasks = new ArrayList<>();

            for (int j = 0; j < numTasks; j++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();
                tasks.add(new TimeFrame(start, finish, j));
            }

            Collections.sort(tasks);

            Parent cameron = new Parent('C');
            Parent jamie = new Parent('J');
            char[] taskAssignments = new char[numTasks];
            boolean possible = true;

            for (TimeFrame task : tasks) {
                if (cameron.canTakeTask(task)) {
                    cameron.addTask(task);
                    taskAssignments[task.order] = cameron.name;
                } else if (jamie.canTakeTask(task)) {
                    jamie.addTask(task);
                    taskAssignments[task.order] = jamie.name;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + new String(taskAssignments));
            }
        }

        scanner.close();
    }

    private static class Parent {
        private final List<TimeFrame> tasks;
        private final char name;

        public Parent(char name) {
            this.name = name;
            this.tasks = new ArrayList<>();
        }

        public void addTask(TimeFrame task) {
            tasks.add(task);
        }

        public boolean canTakeTask(TimeFrame task) {
            for (TimeFrame t : tasks) {
                if (task.overlapsWith(t)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class TimeFrame implements Comparable<TimeFrame> {
        private final int start;
        private final int finish;
        private final int order;

        public TimeFrame(int start, int finish, int order) {
            this.start = start;
            this.finish = finish;
            this.order = order;
        }

        public boolean overlapsWith(TimeFrame other) {
            return (this.start < other.finish && this.finish > other.start);
        }

        @Override
        public int compareTo(TimeFrame other) {
            return Integer.compare(this.start, other.start);
        }
    }
}