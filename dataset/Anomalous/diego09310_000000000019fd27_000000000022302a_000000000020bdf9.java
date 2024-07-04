import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int numTasks = scanner.nextInt();

            List<TimeFrame> tasks = new ArrayList<>();
            for (int j = 0; j < numTasks; j++) {
                tasks.add(new TimeFrame(scanner.nextInt(), scanner.nextInt()));
            }

            Parent cameron = new Parent('C');
            Parent jamie = new Parent('J');

            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            for (TimeFrame task : tasks) {
                if (cameron.canTakeTask(task)) {
                    cameron.assignTask(task);
                    schedule.append(cameron.getName());
                } else if (jamie.canTakeTask(task)) {
                    jamie.assignTask(task);
                    schedule.append(jamie.getName());
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (t + 1) + ": " + schedule.toString());
        }

        scanner.close();
    }

    private static class Parent {
        private List<TimeFrame> assignedTasks;
        private char name;

        public Parent(char name) {
            this.name = name;
            this.assignedTasks = new ArrayList<>();
        }

        public char getName() {
            return name;
        }

        public void assignTask(TimeFrame task) {
            assignedTasks.add(task);
        }

        public boolean canTakeTask(TimeFrame task) {
            for (TimeFrame assignedTask : assignedTasks) {
                if (task.overlapsWith(assignedTask)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class TimeFrame {
        private int start;
        private int end;

        public TimeFrame(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(TimeFrame other) {
            return (this.start < other.end && this.end > other.start);
        }
    }
}