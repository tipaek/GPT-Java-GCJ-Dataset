import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[j][0] = start;
                intervals[j][1] = end;
                originalIntervals[j][0] = start;
                originalIntervals[j][1] = end;
            }
            
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            
            char[] result = new char[n];
            char lastAssigned = 'C';
            boolean isPossible = true;
            
            for (int j = 0; j < n; j++) {
                int index = findOriginalIndex(intervals[j], originalIntervals);
                if (j == 0) {
                    result[index] = 'C';
                } else {
                    if (lastAssigned == 'C') {
                        if (intervals[j][0] >= intervals[j - 1][1]) {
                            result[index] = 'C';
                        } else {
                            result[index] = 'J';
                            lastAssigned = 'J';
                        }
                    } else {
                        if (j > 1 && intervals[j][0] >= intervals[j - 2][1]) {
                            result[index] = 'C';
                            lastAssigned = 'C';
                        } else if (intervals[j][0] >= intervals[j - 1][1]) {
                            result[index] = 'J';
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + i + ": " + new String(result));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        sc.close();
    }
    
    private static int findOriginalIndex(int[] interval, int[][] originalIntervals) {
        for (int k = 0; k < originalIntervals.length; k++) {
            if (originalIntervals[k][0] == interval[0] && originalIntervals[k][1] == interval[1]) {
                originalIntervals[k][0] = -1; // Mark as visited
                originalIntervals[k][1] = -1; // Mark as visited
                return k;
            }
        }
        return -1; // Should never reach here if input is valid
    }
}