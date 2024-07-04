import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            char[] assignments = new char[n];
            Arrays.fill(assignments, ' ');
            
            boolean isPossible = assignTasks(intervals, assignments);
            
            if (isPossible) {
                System.out.print("Case #" + caseNum + ": ");
                System.out.println(assignments);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
    
    private static boolean assignTasks(int[][] intervals, char[] assignments) {
        TreeMap<Integer, Integer> events = new TreeMap<>();
        
        for (int i = 0; i < intervals.length; i++) {
            events.put(intervals[i][0], events.getOrDefault(intervals[i][0], 0) + 1);
            events.put(intervals[i][1], events.getOrDefault(intervals[i][1], 0) - 1);
        }
        
        int ongoingTasks = 0;
        for (int event : events.values()) {
            ongoingTasks += event;
            if (ongoingTasks > 2) {
                return false;
            }
        }
        
        int C = -1, J = -1;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            boolean assigned = false;
            if (C == -1 || end <= intervals[C][0] || start >= intervals[C][1]) {
                assignments[i] = 'C';
                C = i;
                assigned = true;
            } else if (J == -1 || end <= intervals[J][0] || start >= intervals[J][1]) {
                assignments[i] = 'J';
                J = i;
                assigned = true;
            }
            
            if (!assigned) {
                return false;
            }
        }
        
        return true;
    }
}