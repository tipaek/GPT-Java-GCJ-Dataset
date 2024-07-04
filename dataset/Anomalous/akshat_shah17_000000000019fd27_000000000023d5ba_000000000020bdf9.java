import java.util.Scanner;

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
            
            Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            
            char[] schedule = new char[n];
            char lastAssigned = 'C';
            boolean isPossible = true;
            
            for (int j = 0; j < n; j++) {
                int idx = findIndex(intervals[j], originalIntervals);
                
                if (j == 0) {
                    schedule[idx] = 'C';
                } else {
                    if (lastAssigned == 'C') {
                        if (intervals[j][0] >= intervals[j - 1][1]) {
                            schedule[idx] = 'C';
                        } else {
                            schedule[idx] = 'J';
                            lastAssigned = 'J';
                        }
                    } else {
                        if (intervals[j][0] >= intervals[j - 2][1]) {
                            schedule[idx] = 'C';
                            lastAssigned = 'C';
                        } else if (intervals[j][0] >= intervals[j - 1][1]) {
                            schedule[idx] = 'J';
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + i + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
    
    private static int findIndex(int[] interval, int[][] originalIntervals) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (interval[0] == originalIntervals[i][0] && interval[1] == originalIntervals[i][1]) {
                return i;
            }
        }
        return -1;
    }
}