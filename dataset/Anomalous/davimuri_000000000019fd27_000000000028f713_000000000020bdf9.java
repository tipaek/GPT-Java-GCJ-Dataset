import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfTasks = scanner.nextInt();
            List<DomesticTask>[] tasksByStartTime = new List[1440 + 1];
            DomesticTask[] tasks = new DomesticTask[numberOfTasks];

            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (tasksByStartTime[startTime] == null) {
                    tasksByStartTime[startTime] = new ArrayList<>();
                }

                DomesticTask task = new DomesticTask(startTime, endTime);
                tasksByStartTime[startTime].add(task);
                tasks[taskIndex] = task;
            }

            String result = solution.assignTasks(tasksByStartTime, tasks);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }

    public String assignTasks(List<DomesticTask>[] tasksByStartTime, DomesticTask[] tasks) {
        int jamieEndTime = -1;
        int cameronEndTime = -1;

        for (List<DomesticTask> taskList : tasksByStartTime) {
            if (taskList != null) {
                for (DomesticTask task : taskList) {
                    if (jamieEndTime <= task.start) {
                        jamieEndTime = task.end;
                        task.assignee = 'J';
                    } else if (cameronEndTime <= task.start) {
                        cameronEndTime = task.end;
                        task.assignee = 'C';
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (DomesticTask task : tasks) {
            result.append(task.assignee);
        }

        return result.toString();
    }

    static class DomesticTask {
        int start;
        int end;
        char assignee;

        DomesticTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}