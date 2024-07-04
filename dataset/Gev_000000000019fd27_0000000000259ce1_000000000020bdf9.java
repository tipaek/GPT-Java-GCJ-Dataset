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
                tasks.add(new TaskTimes(Integer.parseInt(line[0]), Integer.parseInt(line[1]), j));
            }
            Collections.sort(tasks);
            char[] taskPeople = new char[n];
            int jamieEnd = 0;
            int cameronEnd = 0;
            boolean impossible = false;
            for (TaskTimes task: tasks) {
                if (jamieEnd <= task.start) {
                    jamieEnd = task.end;
                    taskPeople[task.number] = 'J';
                } else if (cameronEnd <= task.start) {
                    cameronEnd = task.end;
                    taskPeople[task.number] = 'C';
                } else {
                    impossible = true;
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s", i, impossible ? "IMPOSSIBLE" : new String(taskPeople)));
        }
    }

    private static class TaskTimes implements Comparable {
        private int start;
        private int end;
        private int number;

        public TaskTimes(int start, int end, int number) {
            this.start = start;
            this.end = end;
            this.number = number;
        }

        @Override
        public int compareTo(Object o) {
            TaskTimes that = (TaskTimes)o;
            return this.start > that.start ? 1 : this.start < that.start ? -1 : this.end > that.end ? 1 : -1;
        }
    }
}