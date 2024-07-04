import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 0; i < t; ++i) {
            int numberOfSchedules = scan.nextInt();
            int[][] schedules = new int[numberOfSchedules][2];

            for (int j = 0; j < numberOfSchedules; ++j) {
                schedules[j][0] = scan.nextInt();
                schedules[j][1] = scan.nextInt();
            }

            String result = assignTasks(schedules);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String assignTasks(int[][] schedules) {
        StringBuilder output = new StringBuilder();
        int cEnd = 0, jEnd = 0;

        for (int[] schedule : schedules) {
            if (schedule[0] >= cEnd) {
                output.append("C");
                cEnd = schedule[1];
            } else if (schedule[0] >= jEnd) {
                output.append("J");
                jEnd = schedule[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }
}