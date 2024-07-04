import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] intervals = new int[l][2];
            boolean[] cameronSchedule = new boolean[1442];
            boolean[] jamieSchedule = new boolean[1442];
            StringBuilder output = new StringBuilder();

            for (int k = 0; k < l; k++) {
                String[] times = br.readLine().split(" ");
                intervals[k][0] = Integer.parseInt(times[0]);
                intervals[k][1] = Integer.parseInt(times[1]);
            }

            boolean possible = true;
            for (int k = 0; k < intervals.length; k++) {
                int start = intervals[k][0];
                int end = intervals[k][1];

                if (isAvailable(cameronSchedule, start, end)) {
                    output.append("C");
                    markSchedule(cameronSchedule, start, end);
                } else if (isAvailable(jamieSchedule, start, end)) {
                    output.append("J");
                    markSchedule(jamieSchedule, start, end);
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + output.toString());
            }
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }
}