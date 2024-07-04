import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            int[][] overlaps = new int[n * n][2];
            int overlapCount = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isOverlapping(intervals[i], intervals[j])) {
                        overlaps[overlapCount][0] = i;
                        overlaps[overlapCount][1] = j;
                        overlapCount++;
                    }
                }
            }
            
            char[] assignments = new char[n];
            for (int i = 0; i < n; i++) {
                assignments[i] = 'C';
            }
            
            boolean conflict = false;
            for (int i = 0; i < overlapCount; i++) {
                int a = overlaps[i][0];
                int b = overlaps[i][1];
                
                if (assignments[a] == assignments[b]) {
                    if (assignments[a] == 'C') {
                        assignments[b] = 'J';
                    } else {
                        assignments[b] = 'C';
                        conflict = true;
                    }
                }
            }
            
            String result = new String(assignments);
            if (conflict) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (testCase + 1) + ": " + result);
            }
        }
        
        scanner.close();
    }
    
    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[1] > interval2[0] && interval1[1] < interval2[1]) ||
               (interval2[1] > interval1[0] && interval1[0] > interval2[0]) ||
               (interval2[1] <= interval1[1] && interval2[0] >= interval1[0]) ||
               (interval2[1] >= interval1[1] && interval2[0] <= interval1[0]);
    }
}