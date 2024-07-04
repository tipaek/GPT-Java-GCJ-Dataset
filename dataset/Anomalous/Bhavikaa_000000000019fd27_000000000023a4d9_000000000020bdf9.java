import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            
            assignActivities(intervals, t);
        }
    }

    private static void assignActivities(int[][] intervals, int caseNumber) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int cEnd = 0, jEnd = 0;
        boolean possible = true;
        
        for (int[] interval : intervals) {
            if (interval[0] >= cEnd) {
                cEnd = interval[1];
                interval[3] = 'C';
            } else if (interval[0] >= jEnd) {
                jEnd = interval[1];
                interval[3] = 'J';
            } else {
                possible = false;
                break;
            }
        }
        
        if (!possible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[2], b[2]));
            StringBuilder result = new StringBuilder("Case #").append(caseNumber).append(": ");
            for (int[] interval : intervals) {
                result.append((char) interval[3]);
            }
            System.out.println(result);
        }
    }
}