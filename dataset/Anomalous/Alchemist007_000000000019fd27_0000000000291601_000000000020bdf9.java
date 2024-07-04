import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            String result = scheduleActivities(startTimes, endTimes);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }

    public static String scheduleActivities(int[] startTimes, int[] endTimes) {
        int[] sortedStartTimes = Arrays.copyOf(startTimes, startTimes.length);
        Arrays.sort(sortedStartTimes);
        
        char[] schedule = new char[startTimes.length];
        int cEndTime = 0, jEndTime = 0;
        
        for (int i = 0; i < sortedStartTimes.length; i++) {
            int currentStartTime = sortedStartTimes[i];
            int index = findIndex(startTimes, currentStartTime, i > 0 && sortedStartTimes[i] == sortedStartTimes[i - 1] ? 2 : 1);
            
            if (cEndTime <= currentStartTime) {
                schedule[index] = 'C';
                cEndTime = endTimes[index];
            } else if (jEndTime <= currentStartTime) {
                schedule[index] = 'J';
                jEndTime = endTimes[index];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(schedule);
    }

    public static int findIndex(int[] array, int value, int occurrence) {
        int count = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
            if (count == occurrence) {
                return i;
            }
        }
        
        return -1;
    }
}