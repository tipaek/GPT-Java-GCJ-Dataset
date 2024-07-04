import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();
            int activitiesCount = scanner.nextInt();
            
            int[][] intervals = new int[activitiesCount][2];
            int[][] originalIntervals = new int[activitiesCount][2];
            
            for (int i = 0; i < activitiesCount; i++) {
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                    originalIntervals[i][j] = intervals[i][j];
                }
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            
            int[] assignments = new int[activitiesCount];
            assignments[0] = 0;
            
            for (int i = 1; i < activitiesCount; i++) {
                int parentIndex = -1;
                int parentCount = 0;
                
                for (int j = 0; j < i; j++) {
                    if (intervals[i][0] >= intervals[j][0] && intervals[i][0] < intervals[j][1]) {
                        parentCount++;
                        parentIndex = assignments[j];
                    }
                }
                
                if (parentCount == 0) {
                    assignments[i] = 0;
                } else if (parentCount == 1) {
                    assignments[i] = 1 - parentIndex;
                } else {
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                for (int i = 0; i < activitiesCount; i++) {
                    int start = originalIntervals[i][0];
                    int end = originalIntervals[i][1];
                    
                    for (int j = 0; j < activitiesCount; j++) {
                        if (intervals[j][0] == start && intervals[j][1] == end) {
                            result.append(assignments[j] == 0 ? "J" : "C");
                            break;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}