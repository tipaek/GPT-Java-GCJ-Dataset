import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int z = 1; z <= t; z++) {
            int n = in.nextInt();
            boolean isImpossible = false;
            char[] schedule = new char[n];
            int[][] intervals = new int[n][3];
            int cAvailable = 0, jAvailable = 0;
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
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
                
                if (cAvailable <= start) {
                    schedule[intervals[i][2]] = 'C';
                    cAvailable = end;
                } else if (jAvailable <= start) {
                    schedule[intervals[i][2]] = 'J';
                    jAvailable = end;
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

        in.close();
    }
}