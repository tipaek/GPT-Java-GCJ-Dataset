import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            
            StringBuilder result = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean impossible = false;
            
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                
                if (start >= cEnd) {
                    result.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = end;
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}