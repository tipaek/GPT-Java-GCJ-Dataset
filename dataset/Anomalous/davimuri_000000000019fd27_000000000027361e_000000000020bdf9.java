import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfTasks = scanner.nextInt();
            List<Integer>[] taskSchedules = new List[1441];
            
            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                if (taskSchedules[startTime] == null) {
                    taskSchedules[startTime] = new ArrayList<>();
                }
                taskSchedules[startTime].add(endTime);
            }
            
            String result = solution.scheduleTasks(taskSchedules);
            System.out.printf("Case #%d: %s%n", caseNumber, result);
        }
    }

    public String scheduleTasks(List<Integer>[] taskSchedules) {
        int jamieEndTime = -1;
        int cameronEndTime = -1;
        StringBuilder scheduleResult = new StringBuilder();
        
        for (int currentTime = 0; currentTime < taskSchedules.length; currentTime++) {
            List<Integer> endTimes = taskSchedules[currentTime];
            
            if (endTimes != null) {
                for (int endTime : endTimes) {
                    if (jamieEndTime <= currentTime) {
                        jamieEndTime = endTime;
                        scheduleResult.append("J");
                    } else if (cameronEndTime <= currentTime) {
                        cameronEndTime = endTime;
                        scheduleResult.append("C");
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        
        return scheduleResult.toString();
    }
}