import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][3];
            
            for (int i = 0; i < taskCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
                tasks[i][2] = i;
            }
            
            Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));
            
            char[] schedule = new char[taskCount];
            boolean feasible = true;
            int cEndTime = 0;
            int jEndTime = 0;
            
            for (int[] task : tasks) {
                int startTime = task[0];
                int endTime = task[1];
                int index = task[2];
                
                if (startTime >= cEndTime) {
                    cEndTime = endTime;
                    schedule[index] = 'C';
                } else if (startTime >= jEndTime) {
                    jEndTime = endTime;
                    schedule[index] = 'J';
                } else {
                    feasible = false;
                    break;
                }
            }
            
            String result = feasible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}