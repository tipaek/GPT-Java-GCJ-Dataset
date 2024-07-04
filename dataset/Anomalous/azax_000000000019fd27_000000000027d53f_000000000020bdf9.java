import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = Integer.parseInt(scanner.nextLine());
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numTasks = Integer.parseInt(scanner.nextLine());
            int[][] tasks = new int[numTasks][3];
            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                String[] taskTimes = scanner.nextLine().split(" ");
                tasks[taskIndex] = new int[] {
                    Integer.parseInt(taskTimes[0]),
                    Integer.parseInt(taskTimes[1]),
                    taskIndex
                };
            }
            Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1[0], task2[0]));
            System.out.println("Case #" + (caseIndex + 1) + ": " + assignTasks(tasks));
        }
        scanner.close();
    }
    
    private static String assignTasks(int[][] tasks) {
        if (tasks.length == 0) {
            return "";
        }
        
        char[] schedule = new char[tasks.length];
        int cameronEndTime = 0;
        int jamieEndTime = 0;
        
        for (int[] task : tasks) {
            if (task[0] >= cameronEndTime) {
                schedule[task[2]] = 'C';
                cameronEndTime = task[1];
            } else if (task[0] >= jamieEndTime) {
                schedule[task[2]] = 'J';
                jamieEndTime = task[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(schedule);
    }
}