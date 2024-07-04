import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            
            solve(intervals, n, t);
        }
    }

    private static void sortByColumn(int[][] array, int column) {
        Arrays.sort(array, Comparator.comparingInt(entry -> entry[column]));
    }

    private static void solve(int[][] intervals, int n, int caseNumber) {
        int cEnd = 0, jEnd = 0;
        StringBuilder schedule = new StringBuilder("C");
        
        sortByColumn(intervals, 0);
        cEnd = intervals[0][1];
        
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                schedule.append("C");
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                schedule.append("J");
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[intervals[i][2]] = schedule.charAt(i);
        }

        System.out.println("Case #" + caseNumber + ": " + new String(result));
    }
}