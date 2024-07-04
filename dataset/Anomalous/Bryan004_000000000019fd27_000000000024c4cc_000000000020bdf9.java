import java.util.Arrays;
import java.util.Scanner;

public class Solution {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            String result = assignTasks(intervals);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
        
        scanner.close();
    }
    
    private static String assignTasks(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        StringBuilder schedule = new StringBuilder();
        
        int[] cameronTask = null;
        int[] jamieTask = null;
        boolean isImpossible = false;
        
        for (int[] interval : intervals) {
            if (cameronTask == null || interval[0] >= cameronTask[1]) {
                cameronTask = interval;
                schedule.append("C");
            } else if (jamieTask == null || interval[0] >= jamieTask[1]) {
                jamieTask = interval;
                schedule.append("J");
            } else {
                isImpossible = true;
                break;
            }
        }
        
        return isImpossible ? "IMPOSSIBLE" : schedule.toString();
    }
}