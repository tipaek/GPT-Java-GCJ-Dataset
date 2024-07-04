import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<TaskTimes> tasks = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                String[] line = scanner.nextLine().split(" ");
                tasks.add(new TaskTimes(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }
            Collections.sort(tasks);
            int jamieEnd = 0;
            int cameronEnd = 0;
            StringBuilder str = new StringBuilder();
            for (TaskTimes task: tasks) {
                if (jamieEnd <= task.start) {
                    jamieEnd = task.end;
                    str.append("J");
                } else if (cameronEnd <= task.start) {
                    cameronEnd = task.end;
                    str.append("C");
                } else {
                    str.delete(0, str.length());
                    str.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, str.toString()));
        }
    }

        private static class TaskTimes implements Comparable {
        private int start;
        private int end;

        public TaskTimes(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            TaskTimes that = (TaskTimes)o;
            return this.start > that.start ? 1 : this.start < that.start ? -1 : this.end > that.end ? 1 : -1;
        }
    }
}