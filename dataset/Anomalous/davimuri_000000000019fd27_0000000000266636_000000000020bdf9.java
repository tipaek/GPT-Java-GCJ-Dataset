import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];
            
            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                tasks[taskIndex] = new Task(startTime, endTime);
            }
            
            String result = solution.assignTasks(tasks);
            System.out.printf("Case #%d: %s%n", caseIndex, result);
        }
    }

    public String assignTasks(Task[] tasks) {
        Task[] schedule = new Task[1441];
        
        for (Task task : tasks) {
            schedule[task.startTime] = task;
        }
        
        Task jamieTask = null;
        Task cameronTask = null;
        StringBuilder assignment = new StringBuilder();
        
        for (int time = 0; time < schedule.length; time++) {
            if (schedule[time] != null) {
                if (jamieTask == null || jamieTask.endTime <= time) {
                    jamieTask = schedule[time];
                    assignment.append("J");
                } else if (cameronTask == null || cameronTask.endTime <= time) {
                    cameronTask = schedule[time];
                    assignment.append("C");
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        return assignment.toString();
    }

    static class Task {
        int startTime;
        int endTime;

        Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        static Task of(int startTime, int endTime) {
            return new Task(startTime, endTime);
        }
    }
}