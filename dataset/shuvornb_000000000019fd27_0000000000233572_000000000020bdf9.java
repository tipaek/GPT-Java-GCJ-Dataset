import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        int i;
        int j;
        int tasks;
        int[][] timing;
        StringBuilder result;
        List<Task> taskJ;
        List<Task> taskC;
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(i = 1; i<=testCases; i++) {
            tasks = scanner.nextInt();
            timing = new int[tasks][2];
            result = new StringBuilder();
            taskJ = new ArrayList<>();
            taskC = new ArrayList<>();

            for(j=0; j<tasks; j++) {
                timing[j][0] = scanner.nextInt();
                timing[j][1] = scanner.nextInt();
            }
            Boolean flag = true;

            for(j=0; j<tasks; j++) {
                Task currentTask = new Task(timing[j][0], timing[j][1]);
                char candidate = getCandidate(currentTask, taskJ, taskC);
                if(candidate == 'I'){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    flag = false;
                    break;
                }
                else {
                    result.append(candidate);
                    if(candidate == 'J') {
                        taskJ.add(currentTask);
                    }
                    if(candidate == 'C') {
                        taskC.add(currentTask);
                    }
                }
            }

            if(flag) System.out.println("Case #" + i + ": " + result);
        }
    }

    private static char getCandidate(Task currentTask, List<Task> taskJ, List<Task> taskC) {
        Boolean flag = true;
        for(Task task: taskJ) {
            if(currentTask.startTime >= task.startTime && currentTask.startTime < task.endTime) flag = false;
            else if(currentTask.endTime > task.startTime && currentTask.endTime <= task.endTime) flag = false;
            else if(currentTask.startTime <= task.startTime && currentTask.endTime >= task.endTime) flag = false;
        }
        if(flag) return 'J';
        else {
            flag = true;
            for(Task task: taskC) {
                if(currentTask.startTime >= task.startTime && currentTask.startTime < task.endTime) flag = false;
                else if(currentTask.endTime > task.startTime && currentTask.endTime <= task.endTime) flag = false;
                else if(currentTask.startTime <= task.startTime && currentTask.endTime >= task.endTime) flag = false;
            }
            if(flag) return 'C';
        }
        return 'I';
    }

    private static class Task {
        int startTime;
        int endTime;

        Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
