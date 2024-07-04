import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 0; i < t; ++i) {
            int numberOfSchedules = scan.nextInt();
            int[][] schedules = new int[numberOfSchedules][2];
            int[][] originalSchedules = new int[numberOfSchedules][2];

            for (int j = 0; j < numberOfSchedules; ++j) {
                schedules[j][0] = scan.nextInt();
                schedules[j][1] = scan.nextInt();
                originalSchedules[j][0] = schedules[j][0];
                originalSchedules[j][1] = schedules[j][1];
            }

            Arrays.sort(schedules, Comparator.comparingInt(a -> a[0]));

            int cEndTime = 0, jEndTime = 0;
            StringBuilder output = new StringBuilder();

            for (int[] schedule : schedules) {
                if (cEndTime <= schedule[0]) {
                    output.append("C");
                    cEndTime = schedule[1];
                } else if (jEndTime <= schedule[0]) {
                    output.append("J");
                    jEndTime = schedule[1];
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}