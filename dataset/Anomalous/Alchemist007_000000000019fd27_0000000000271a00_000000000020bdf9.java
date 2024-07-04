import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            
            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            String schedule = determineSchedule(startTimes, endTimes);
            System.out.println("Case #" + t + ": " + schedule);
        }
    }
    
    private static String determineSchedule(int[] startTimes, int[] endTimes) {
        int[] sortedStartTimes = Arrays.copyOf(startTimes, startTimes.length);
        Arrays.sort(sortedStartTimes);
        
        char[] result = new char[startTimes.length];
        int cameronEndTime = 0, jamieEndTime = 0;
        
        for (int startTime : sortedStartTimes) {
            int index = findIndex(startTimes, startTime);
            if (cameronEndTime <= startTime) {
                result[index] = 'C';
                cameronEndTime = endTimes[index];
            } else if (jamieEndTime <= startTime) {
                result[index] = 'J';
                jamieEndTime = endTimes[index];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(result);
    }
    
    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}