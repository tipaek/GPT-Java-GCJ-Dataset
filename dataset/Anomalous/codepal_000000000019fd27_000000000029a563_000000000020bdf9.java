import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static String result = "";
    static boolean isSolved = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            result = "";
            isSolved = false;
            findSchedule(intervals, "C", 0, -1, 1);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    public static void findSchedule(int[][] intervals, String schedule, int cIndex, int jIndex, int nextIndex) {
        if (nextIndex == intervals.length) {
            result = schedule;
            isSolved = true;
            return;
        }

        if (!isSolved) {
            if (jIndex > 0 && overlaps(intervals[cIndex], intervals[nextIndex]) && overlaps(intervals[jIndex], intervals[nextIndex])) {
                result = "IMPOSSIBLE";
                return;
            }

            if (jIndex == -1) {
                if (overlaps(intervals[cIndex], intervals[nextIndex])) {
                    findSchedule(intervals, schedule + "J", cIndex, nextIndex, nextIndex + 1);
                } else {
                    findSchedule(intervals, schedule + "C", nextIndex, nextIndex, nextIndex + 1);
                    if (!isSolved) {
                        findSchedule(intervals, schedule + "J", cIndex, nextIndex, nextIndex + 1);
                    }
                }
            } else {
                if (overlaps(intervals[cIndex], intervals[nextIndex])) {
                    findSchedule(intervals, schedule + "J", cIndex, nextIndex, nextIndex + 1);
                } else if (overlaps(intervals[jIndex], intervals[nextIndex])) {
                    findSchedule(intervals, schedule + "C", nextIndex, jIndex, nextIndex + 1);
                } else {
                    findSchedule(intervals, schedule + "C", nextIndex, nextIndex, nextIndex + 1);
                    if (!isSolved) {
                        findSchedule(intervals, schedule + "J", cIndex, nextIndex, nextIndex + 1);
                    }
                }
            }
        }
    }

    public static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval1[1] > interval2[0];
    }
}