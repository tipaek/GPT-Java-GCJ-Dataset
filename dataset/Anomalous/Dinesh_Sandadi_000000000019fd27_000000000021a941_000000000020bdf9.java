import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private void printCaseResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static class Task implements Comparable<Task> {
        int startTime;
        int endTime;
        int index;

        public Task(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }

    private String determineSchedule(List<Task> tasks) {
        Collections.sort(tasks);

        boolean isCameronAvailable = true, isJamieAvailable = true;
        int cameronEndTime = 0, jamieEndTime = 0;
        char[] schedule = new char[tasks.size()];

        for (Task task : tasks) {
            if (task.startTime >= cameronEndTime) {
                isCameronAvailable = true;
            }
            if (task.startTime >= jamieEndTime) {
                isJamieAvailable = true;
            }

            if (isCameronAvailable) {
                schedule[task.index] = 'C';
                cameronEndTime = task.endTime;
                isCameronAvailable = false;
            } else if (isJamieAvailable) {
                schedule[task.index] = 'J';
                jamieEndTime = task.endTime;
                isJamieAvailable = false;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        Solution solution = new Solution();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfTasks = scanner.nextInt();
            List<Task> tasks = new ArrayList<>(numberOfTasks);
            for (int i = 0; i < numberOfTasks; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                tasks.add(new Task(startTime, endTime, i));
            }

            String result = solution.determineSchedule(tasks);
            solution.printCaseResult(caseNumber, result);
        }
    }
}