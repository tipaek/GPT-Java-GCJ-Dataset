package org.example;

import java.io.BufferedInputStream;
import java.util.*;

public class Solution {
    static class TaskSchedule {
        int start, end;

        public TaskSchedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            final int numTasks = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();

            final List<TaskSchedule> schedules = new ArrayList<>();
            for (int j = 0; j < numTasks; j++) {
                schedules.add(new TaskSchedule(scanner.nextInt(), scanner.nextInt()));
            }

            Collections.sort(schedules, Comparator.comparing(TaskSchedule::getStart));
            TaskSchedule cameron = null;
            TaskSchedule jamie = null;
            for (TaskSchedule taskSchedule: schedules) {
                boolean scheduled = false;
                if (!scheduled && cameron == null) {
                    cameron = taskSchedule;
                    schedule.append("C");
                    scheduled = true;
                }

                if (!scheduled && jamie == null) {
                    jamie = taskSchedule;
                    schedule.append("J");
                    scheduled = true;
                }

                if (!scheduled && cameron.end <= taskSchedule.start) {
                    cameron = taskSchedule;
                    schedule.append("C");
                    scheduled = true;
                }

                if (!scheduled && jamie.end <= taskSchedule.start) {
                    jamie = taskSchedule;
                    schedule.append("J");
                    scheduled = true;
                }

                if (!scheduled) {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println(String.format("Case #%d: %s", i, schedule.toString()));
        }

        scanner.close();
    }

}
