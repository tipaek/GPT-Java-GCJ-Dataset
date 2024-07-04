import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String result = "IMPOSSIBLE";
    private static boolean foundSolution = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt(); // Start time
                intervals[i][1] = scanner.nextInt(); // End time
            }

            result = "IMPOSSIBLE";
            foundSolution = false;
            findSchedule(intervals, "", -1, -1, 0);
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static void findSchedule(int[][] intervals, String schedule, int lastC, int lastJ, int index) {
        if (index == intervals.length) {
            result = schedule;
            foundSolution = true;
            return;
        }

        if (foundSolution) return;

        if (canAssign(intervals, schedule, 'C', lastC, index)) {
            findSchedule(intervals, schedule + "C", index, lastJ, index + 1);
        }

        if (canAssign(intervals, schedule, 'J', lastJ, index)) {
            findSchedule(intervals, schedule + "J", lastC, index, index + 1);
        }
    }

    private static boolean canAssign(int[][] intervals, String schedule, char person, int last, int index) {
        while (last >= 0) {
            if (schedule.charAt(last) == person && intervals[index][0] < intervals[last][1]) {
                return false;
            }
            last--;
        }
        return true;
    }
}