import java.util.*;

class Solution {
    
    /*
    1. Create 2D array (start, end, index), char array
    2. Sort by start time
    3. Evaluate, for each interval, assign its char array[index] to 'C' or 'J'
    4. Print char array or "IMPOSSIBLE"
    */
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int z = 1; z <= t; z++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            char[] schedule = new char[n];
            int cEndTime = 0, jEndTime = 0;
            
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                
                if (cEndTime <= start) {
                    schedule[intervals[i][2]] = 'C';
                    cEndTime = end;
                } else if (jEndTime <= start) {
                    schedule[intervals[i][2]] = 'J';
                    jEndTime = end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", z);
            } else {
                System.out.printf("Case #%d: %s\n", z, new String(schedule));
            }
        }
        
        scanner.close();
    }
}