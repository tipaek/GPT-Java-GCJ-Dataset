import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        StringBuilder schedule = new StringBuilder();
        int[] endTime = new int[2]; // endTime[0] for 'C', endTime[1] for 'J'
        
        for (int[] interval : intervals) {
            if (interval[0] >= endTime[0]) {
                schedule.append('C');
                endTime[0] = interval[1];
            } else if (interval[0] >= endTime[1]) {
                schedule.append('J');
                endTime[1] = interval[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }
}