import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        int i;
        int j;
        int tasks;
        StringBuilder result;
        List<Task> taskJ;
        List<Task> taskC;
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(i = 1; i<=testCases; i++) {
            tasks = scanner.nextInt();
            result = new StringBuilder();
            taskJ = new ArrayList<>();
            taskC = new ArrayList<>();

            Boolean flag = true;
            for(j=0; j<tasks; j++) {

                Task currentTask = new Task(scanner.nextInt(), scanner.nextInt());
                String candidate = getCandidate(currentTask, taskJ, taskC);

                if(candidate.equals("I")){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    flag = false;
                    break;
                }
                else {
                    result.append(candidate);
                    if(candidate.equals("J")) {
                        taskJ.add(currentTask);
                    }
                    if(candidate.equals("C")) {
                        taskC.add(currentTask);
                    }
                }
            }

            if(flag) System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String getCandidate(Task currentTask, List<Task> taskJ, List<Task> taskC) {
        Boolean flag = true;
        for(Task task: taskJ) {
            if(currentTask.startTime >= task.startTime && currentTask.startTime < task.endTime) flag = false;
            else if(currentTask.endTime > task.startTime && currentTask.endTime <= task.endTime) flag = false;
            else if(currentTask.startTime <= task.startTime && currentTask.endTime >= task.endTime) flag = false;
        }
        if(flag) return "J";
        else {
            flag = true;
            for(Task task: taskC) {
                if(currentTask.startTime >= task.startTime && currentTask.startTime < task.endTime) flag = false;
                else if(currentTask.endTime > task.startTime && currentTask.endTime <= task.endTime) flag = false;
                else if(currentTask.startTime <= task.startTime && currentTask.endTime >= task.endTime) flag = false;
            }
            if(flag) return "C";
            else return "I";
        }
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
