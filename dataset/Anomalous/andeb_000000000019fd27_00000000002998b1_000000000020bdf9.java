import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchedulePlanner {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int tasksCount = Integer.parseInt(reader.readLine());
            List<Task> tasks = new ArrayList<>(tasksCount);

            for (int i = 0; i < tasksCount; i++) {
                String[] input = reader.readLine().split(" ");
                tasks.add(new Task(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            Collections.sort(tasks);
            StringBuilder schedule = new StringBuilder(tasksCount);
            int cameronEndTime = Integer.MIN_VALUE;
            int jamieEndTime = Integer.MIN_VALUE;

            for (Task task : tasks) {
                if (cameronEndTime <= task.start) {
                    schedule.append('C');
                    cameronEndTime = task.end;
                } else if (jamieEndTime <= task.start) {
                    schedule.append('J');
                    jamieEndTime = task.end;
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", caseIndex + 1, schedule);
        }
    }

    static class Task implements Comparable<Task> {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return start + ", " + end;
        }
    }
}