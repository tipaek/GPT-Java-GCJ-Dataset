import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int taskCount = Integer.parseInt(reader.readLine());
            List<Task> tasks = new ArrayList<>(taskCount);

            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                String[] timeRange = reader.readLine().split(" ");
                tasks.add(new Task(Integer.parseInt(timeRange[0]), Integer.parseInt(timeRange[1])));
            }

            StringBuilder result = new StringBuilder(taskCount);
            int cameronEndTime = Integer.MIN_VALUE;
            int jamieEndTime = Integer.MIN_VALUE;

            for (Task task : tasks) {
                if (cameronEndTime <= task.startTime) {
                    result.append('C');
                    cameronEndTime = task.endTime;
                } else if (jamieEndTime <= task.startTime) {
                    result.append('J');
                    jamieEndTime = task.endTime;
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", caseIndex + 1, result);
        }
    }

    static class Task implements Comparable<Task> {
        int startTime;
        int endTime;

        Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Task other) {
            int startTimeDifference = this.startTime - other.startTime;
            return startTimeDifference != 0 ? startTimeDifference : this.endTime - other.endTime;
        }

        @Override
        public String toString() {
            return startTime + ", " + endTime;
        }
    }
}