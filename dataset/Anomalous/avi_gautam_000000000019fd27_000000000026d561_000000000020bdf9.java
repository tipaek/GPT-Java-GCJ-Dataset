import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            
            scanner.nextLine();
            for (int j = 0; j < numActivities; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities[j][0] = Integer.parseInt(times[0]);
                activities[j][1] = Integer.parseInt(times[1]);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            String result = scheduleActivities(activities, numActivities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String scheduleActivities(int[][] activities, int numActivities) {
        int cEndTime = 0, jEndTime = 0;
        StringBuilder schedule = new StringBuilder();
        char[] assigned = new char[numActivities];
        
        for (int i = 0; i < numActivities; i++) {
            if (activities[i][0] >= cEndTime) {
                cEndTime = activities[i][1];
                assigned[i] = 'C';
            } else if (activities[i][0] >= jEndTime) {
                jEndTime = activities[i][1];
                assigned[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        for (char c : assigned) {
            schedule.append(c);
        }
        
        return schedule.toString();
    }
}