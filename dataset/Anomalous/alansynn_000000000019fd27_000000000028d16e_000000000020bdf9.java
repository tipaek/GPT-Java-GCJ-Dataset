import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][3];
            
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int[] schedule = new int[1440];
            char[] result = new char[activityCount];
            boolean impossible = false;
            
            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];
                int index = activity[2];
                
                boolean cameronAvailable = isAvailable(schedule, start, end, 1);
                boolean jamieAvailable = isAvailable(schedule, start, end, 2);
                
                if (cameronAvailable) {
                    fillSchedule(schedule, start, end, 1);
                    result[index] = 'C';
                } else if (jamieAvailable) {
                    fillSchedule(schedule, start, end, 2);
                    result[index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + (impossible ? "IMPOSSIBLE" : new String(result)));
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end, int person) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == person) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[] schedule, int start, int end, int person) {
        for (int i = start; i < end; i++) {
            schedule[i] = person;
        }
    }
}