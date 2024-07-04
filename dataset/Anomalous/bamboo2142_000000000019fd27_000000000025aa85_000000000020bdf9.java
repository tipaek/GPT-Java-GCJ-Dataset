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
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            
            StringBuilder result = new StringBuilder();
            Map<Character, Integer> endTimes = new HashMap<>();
            
            endTimes.put('C', 0);
            endTimes.put('J', 0);
            
            boolean isImpossible = false;
            
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                
                if (start >= endTimes.get('C')) {
                    endTimes.put('C', end);
                    result.append('C');
                } else if (start >= endTimes.get('J')) {
                    endTimes.put('J', end);
                    result.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
        
        scanner.close();
    }
}