import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int tasks = Integer.parseInt(reader.readLine());
            List<Task> schedule = new ArrayList<>(tasks);

            for (int i = 0; i < tasks; i++) {
                String[] timeSlots = reader.readLine().split(" ");
                schedule.add(new Task(Integer.parseInt(timeSlots[0]), Integer.parseInt(timeSlots[1]), i));
            }

            Collections.sort(schedule);

            int cEndTime = Integer.MIN_VALUE;
            int jEndTime = Integer.MIN_VALUE;
            boolean isImpossible = false;

            for (Task task : schedule) {
                if (cEndTime <= task.start) {
                    task.assignedTo = 'C';
                    cEndTime = task.end;
                } else if (jEndTime <= task.start) {
                    task.assignedTo = 'J';
                    jEndTime = task.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder(tasks);
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                Collections.sort(schedule, Comparator.comparingInt(task -> task.index));
                for (Task task : schedule) {
                    result.append(task.assignedTo);
                }
            }

            System.out.printf("Case #%d: %s%n", caseIndex + 1, result);
        }
    }

    static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;
        char assignedTo;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            int startDifference = this.start - other.start;
            return startDifference != 0 ? startDifference : this.end - other.end;
        }

        @Override
        public String toString() {
            return start + ", " + end;
        }
    }
}