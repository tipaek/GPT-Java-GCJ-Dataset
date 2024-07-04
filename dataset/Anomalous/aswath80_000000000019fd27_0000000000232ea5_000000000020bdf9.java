import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            processTestCase(t, intervals);
        }
    }

    private static void processTestCase(int testCaseNumber, int[][] intervals) {
        Map<Integer, Character> assignmentMap = new HashMap<>();
        assignIntervals(intervals, assignmentMap, 'C');
        assignIntervals(intervals, assignmentMap, 'J');
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < intervals.length; i++) {
            if (assignmentMap.containsKey(i)) {
                result.append(assignmentMap.get(i));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", testCaseNumber));
                return;
            }
        }
        
        System.out.println(String.format("Case #%d: %s", testCaseNumber, result.toString()));
    }

    private static void assignIntervals(int[][] intervals, Map<Integer, Character> assignmentMap, char person) {
        int maxEndTime = 0;
        boolean canAssignMore = true;
        
        while (canAssignMore) {
            int minGap = Integer.MAX_VALUE;
            int minGapIndex = -1;
            
            for (int i = 0; i < intervals.length; i++) {
                if (!assignmentMap.containsKey(i)) {
                    int startTime = intervals[i][0];
                    if (startTime >= maxEndTime && (startTime - maxEndTime) < minGap) {
                        minGap = startTime - maxEndTime;
                        minGapIndex = i;
                    }
                }
            }
            
            if (minGapIndex != -1) {
                assignmentMap.put(minGapIndex, person);
                maxEndTime = intervals[minGapIndex][1];
            } else {
                canAssignMore = false;
            }
        }
    }
}