import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int q = 1; q <= t; q++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            
            char[] assignments = new char[n];
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= cEnd) {
                    assignments[i] = 'C';
                    cEnd = intervals[i][1];
                } else if (intervals[i][0] >= jEnd) {
                    assignments[i] = 'J';
                    jEnd = intervals[i][1];
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                char[] finalAssignments = new char[n];
                boolean[] assigned = new boolean[n];
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (originalIntervals[i][0] == intervals[j][0] &&
                            originalIntervals[i][1] == intervals[j][1] &&
                            !assigned[j]) {
                            assigned[j] = true;
                            finalAssignments[i] = assignments[j];
                            break;
                        }
                    }
                }
                
                System.out.print("Case #" + q + ": ");
                System.out.println(finalAssignments);
            } else {
                System.out.println("Case #" + q + ": IMPOSSIBLE");
            }
        }
        
        sc.close();
    }
}