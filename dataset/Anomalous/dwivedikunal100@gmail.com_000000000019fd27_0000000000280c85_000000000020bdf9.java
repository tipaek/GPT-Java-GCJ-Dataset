import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            
            int cEndTime = 0, jEndTime = 0;
            
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                
                if (cEndTime <= start) {
                    schedule.append("C");
                    cEndTime = end;
                } else if (jEndTime <= start) {
                    schedule.append("J");
                    jEndTime = end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
            } else {
                System.out.printf("Case #%d: %s\n", caseNumber, schedule.toString());
            }
        }
        
        scanner.close();
    }
}