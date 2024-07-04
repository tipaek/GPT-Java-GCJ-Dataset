import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            int[][] activities = new int[numberOfActivities][2];
            
            for (int i = 0; i < numberOfActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            String schedule = findSchedule(activities);
            System.out.printf("Case #%d: %s%n", testCase, schedule);
        }
    }

    private static String findSchedule(int[][] activities) {
        byte[] cameronSchedule = new byte[1441];
        byte[] jamesSchedule = new byte[1441];
        StringBuilder scheduleBuilder = new StringBuilder();
        
        for (int[] activity : activities) {
            if (assignActivity(cameronSchedule, activity[0], activity[1])) {
                scheduleBuilder.append('C');
            } else if (assignActivity(jamesSchedule, activity[0], activity[1])) {
                scheduleBuilder.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return scheduleBuilder.toString();
    }

    private static boolean assignActivity(byte[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] != 0) {
                return false;
            }
        }
        
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
        
        return true;
    }
}