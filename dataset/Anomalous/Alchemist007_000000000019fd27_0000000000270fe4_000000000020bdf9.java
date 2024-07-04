import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            String result = getSchedule(startTimes, endTimes);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
    
    public static String getSchedule(int[] startTimes, int[] endTimes) {
        int[] sortedStartTimes = Arrays.copyOf(startTimes, startTimes.length);
        Arrays.sort(sortedStartTimes);
        
        char[] schedule = new char[startTimes.length];
        int cEnd = 0, jEnd = 0;
        
        for (int startTime : sortedStartTimes) {
            int index = getIndex(startTimes, startTime);
            
            if (cEnd <= startTime) {
                schedule[index] = 'C';
                cEnd = endTimes[index];
            } else if (jEnd <= startTime) {
                schedule[index] = 'J';
                jEnd = endTimes[index];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(schedule);
    }
    
    public static int getIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}