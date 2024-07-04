import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int a = Integer.parseInt(sc.nextLine());
            int[][] intervals = new int[a][3];
            for (int j = 0; j < a; j++) {
                String[] input = sc.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
                intervals[j][2] = 0;
            }

            System.out.println("Case #" + i + ": " + findSchedule(intervals));
        }
    }

    private static String findSchedule(int[][] intervals) {
        StringBuilder schedule = new StringBuilder();
        for (int i = 0; i < intervals.length; i++) {
            int conflictIndex = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (isOverlapping(intervals[i], intervals[j])) {
                    if (conflictIndex == -1) {
                        conflictIndex = j;
                    } else if (isOverlapping(intervals[conflictIndex], intervals[j])) {
                        return "IMPOSSIBLE";
                    }
                    conflictIndex = j;
                    intervals[conflictIndex][2] = intervals[i][2] == 0 ? 1 : 0;
                }
            }
        }

        for (int[] interval : intervals) {
            schedule.append(interval[2] == 0 ? "J" : "C");
        }
        return schedule.toString();
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[0] < interval2[1] && interval1[1] > interval2[0]);
    }
}