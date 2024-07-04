import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            StringBuilder schedule = new StringBuilder();
            Set<Interval> cameronTasks = new HashSet<>();
            Set<Interval> jamieTasks = new HashSet<>();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval currentTask = new Interval(start, end);

                if (canAddTask(cameronTasks, currentTask)) {
                    cameronTasks.add(currentTask);
                    schedule.append('C');
                } else if (canAddTask(jamieTasks, currentTask)) {
                    jamieTasks.add(currentTask);
                    schedule.append('J');
                } else {
                    System.out.println("Case #" + testcase + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testcase + ": " + schedule.toString());
            }
        }

        sc.close();
    }

    private static boolean canAddTask(Set<Interval> tasks, Interval newTask) {
        for (Interval task : tasks) {
            if (task.overlaps(newTask)) {
                return false;
            }
        }
        return true;
    }

    private static class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval other) {
            return (this.start < other.end && this.end > other.start);
        }
    }
}