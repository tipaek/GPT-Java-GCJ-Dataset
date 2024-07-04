

import java.io.BufferedInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static class TaskSchedule {
        int start, end, pos;
        String assignee;

        public TaskSchedule(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        public int getStart() {
            return start;
        }

        public int getPos() {
            return pos;
        }

        public String getAssignee() {
            return assignee;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            final int numTasks = scanner.nextInt();

            final List<TaskSchedule> schedules = new ArrayList<>();
            for (int j = 0; j < numTasks; j++) {
                schedules.add(new TaskSchedule(scanner.nextInt(), scanner.nextInt(), j));
            }

            Collections.sort(schedules, Comparator.comparing(TaskSchedule::getStart));
            TaskSchedule cameron = null;
            TaskSchedule jamie = null;
            boolean impossible = false;
            for (TaskSchedule taskSchedule : schedules) {
                boolean scheduled = false;
                if (!scheduled && cameron == null) {
                    cameron = taskSchedule;
                    taskSchedule.assignee = "C";
                    scheduled = true;
                }

                if (!scheduled && cameron.end <= taskSchedule.start) {
                    cameron = taskSchedule;
                    taskSchedule.assignee = "C";
                    scheduled = true;
                }

                if (!scheduled && jamie == null) {
                    jamie = taskSchedule;
                    taskSchedule.assignee = "J";
                    scheduled = true;
                }

                if (!scheduled && jamie.end <= taskSchedule.start) {
                    jamie = taskSchedule;
                    taskSchedule.assignee = "J";
                    scheduled = true;
                }

                if (!scheduled) {
                    impossible = true;
                    break;
                }
            }

            System.out.println(String.format("Case #%d: %s", i, impossible ? "IMPOSSIBLE" : schedules.stream()
                    .sorted(Comparator.comparing(TaskSchedule::getPos))
                    .map(TaskSchedule::getAssignee)
                    .collect(Collectors.joining(""))));
        }

        scanner.close();
    }

}
