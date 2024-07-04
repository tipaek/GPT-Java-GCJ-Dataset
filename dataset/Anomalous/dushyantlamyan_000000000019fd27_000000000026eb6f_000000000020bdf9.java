import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int countN = scanner.nextInt();
            int[][] intervals = new int[countN][2];
            for (int j = 0; j < countN; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        int[] assigned = new int[n];
        Arrays.fill(assigned, -1);

        int cEnd = 0, jEnd = 0;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                assigned[i] = 0; // Assign to C
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                assigned[i] = 1; // Assign to J
                jEnd = intervals[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(assigned[i] == 0 ? 'C' : 'J');
        }
        return result.toString();
    }
}