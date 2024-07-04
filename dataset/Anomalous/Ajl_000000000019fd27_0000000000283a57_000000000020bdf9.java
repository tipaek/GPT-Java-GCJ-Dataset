import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            String schedule = determineSchedule(numActivities, scanner);
            System.out.println("Case #" + testCase + ": " + schedule);
        }
        
        scanner.close();
    }

    private static String determineSchedule(int numActivities, Scanner scanner) {
        int[][] activities = new int[numActivities][3];
        
        for (int i = 0; i < numActivities; i++) {
            activities[i][0] = scanner.nextInt();
            activities[i][1] = scanner.nextInt();
            activities[i][2] = i;
        }
        
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        
        int cEndTime = -1;
        int jEndTime = -1;
        char[] scheduleBuilder = new char[numActivities];
        
        for (int[] activity : activities) {
            int startTime = activity[0];
            int endTime = activity[1];
            int originalIndex = activity[2];
            
            if (cEndTime <= startTime) {
                cEndTime = endTime;
                scheduleBuilder[originalIndex] = 'C';
            } else if (jEndTime <= startTime) {
                jEndTime = endTime;
                scheduleBuilder[originalIndex] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(scheduleBuilder);
    }
}