import java.util.*;

class Criteria implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        
        for (int z = 1; z <= t1; z++) {
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            int cEnd = 0, jEnd = 0;
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }
            
            Arrays.sort(intervals, new Criteria());
            
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                
                if (cEnd <= start) {
                    schedule.append('C');
                    cEnd = end;
                } else if (jEnd <= start) {
                    schedule.append('J');
                    jEnd = end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + z + ": " + (possible ? schedule.toString() : "IMPOSSIBLE"));
        }
        
        sc.close();
    }
}