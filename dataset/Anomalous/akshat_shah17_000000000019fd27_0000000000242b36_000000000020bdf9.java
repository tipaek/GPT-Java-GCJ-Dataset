import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i][0] = start;
                intervals[i][1] = end;
                originalIntervals[i][0] = start;
                originalIntervals[i][1] = end;
            }
            
            Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            
            char[] schedule = new char[n];
            int lastCameronEnd = 0;
            int lastJamieEnd = 0;
            boolean isPossible = true;
            
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                
                if (start >= lastCameronEnd) {
                    lastCameronEnd = end;
                    schedule[findOriginalIndex(originalIntervals, start, end)] = 'C';
                } else if (start >= lastJamieEnd) {
                    lastJamieEnd = end;
                    schedule[findOriginalIndex(originalIntervals, start, end)] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
    
    private static int findOriginalIndex(int[][] originalIntervals, int start, int end) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (originalIntervals[i][0] == start && originalIntervals[i][1] == end) {
                originalIntervals[i][0] = -1; // Mark as used
                originalIntervals[i][1] = -1; // Mark as used
                return i;
            }
        }
        return -1; // This should never happen
    }
}