import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int i = 0; i < n; i++) {
                startTimes[i] = intervals[i][0];
                endTimes[i] = intervals[i][1];
            }
            
            int ongoingTasks = 0;
            int startIndex = 0;
            int endIndex = 0;
            StringBuilder schedule = new StringBuilder();
            
            while (startIndex < n && endIndex < n) {
                if (startTimes[startIndex] < endTimes[endIndex]) {
                    ongoingTasks++;
                    startIndex++;
                    
                    if (ongoingTasks == 1 && schedule.length() < n) {
                        schedule.append("C");
                    } else if (ongoingTasks == 2 && schedule.length() < n) {
                        schedule.append("J");
                    }
                } else {
                    ongoingTasks--;
                    endIndex++;
                }
            }
            
            if (ongoingTasks > 2) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + testCase + ": " + schedule.toString());
        }
        
        scanner.close();
    }
}