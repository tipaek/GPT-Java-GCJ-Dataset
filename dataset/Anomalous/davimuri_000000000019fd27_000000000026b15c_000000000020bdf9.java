import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfTasks = scanner.nextInt();
            Map<Integer, List<Integer>> taskMap = new HashMap<>();
            
            for (int taskIndex = 1; taskIndex <= numberOfTasks; taskIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                
                taskMap.computeIfAbsent(startTime, k -> new ArrayList<>()).add(endTime);
            }
            
            String result = solution.scheduleTasks(taskMap);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }

    public String scheduleTasks(Map<Integer, List<Integer>> taskMap) {
        int jamieEndTime = -1;
        int cameronEndTime = -1;
        StringBuilder schedule = new StringBuilder();
        
        for (int currentTime = 0; currentTime < 1441; currentTime++) {
            List<Integer> endTimes = taskMap.get(currentTime);
            
            if (endTimes != null) {
                for (int endTime : endTimes) {
                    if (jamieEndTime == -1 || jamieEndTime <= currentTime) {
                        jamieEndTime = endTime;
                        schedule.append("J");
                    } else if (cameronEndTime == -1 || cameronEndTime <= currentTime) {
                        cameronEndTime = endTime;
                        schedule.append("C");
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }
        return schedule.toString();
    }
}