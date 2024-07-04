import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            
            StringBuilder result = new StringBuilder();
            Map<Character, Integer> endTimes = new HashMap<>();
            endTimes.put('C', 0);
            endTimes.put('J', 0);
            
            boolean isPossible = true;
            
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                
                if (start >= endTimes.get('C')) {
                    result.append('C');
                    endTimes.put('C', end);
                } else if (start >= endTimes.get('J')) {
                    result.append('J');
                    endTimes.put('J', end);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
        
        scanner.close();
    }
}