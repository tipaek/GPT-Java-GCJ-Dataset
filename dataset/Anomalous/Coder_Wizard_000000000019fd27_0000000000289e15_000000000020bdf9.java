import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 0; i < t; ++i) {
            StringBuilder output = new StringBuilder();
            int numberOfSchedules = scan.nextInt();
            int[][] schedules = new int[numberOfSchedules][2];

            for (int j = 0; j < numberOfSchedules; ++j) {
                schedules[j][0] = scan.nextInt();
                schedules[j][1] = scan.nextInt();
            }

            int cEndTime = 0, jEndTime = 0, cStartTime = schedules[0][0], jStartTime = 0;
            boolean isPossible = true;

            for (int j = 0; j < numberOfSchedules; ++j) {
                if (cEndTime <= schedules[j][0]) {
                    output.append("C");
                    cEndTime = schedules[j][1];
                } else if (cStartTime >= schedules[j][1]) {
                    output.append("C");
                    cStartTime = schedules[j][1];
                } else if (jEndTime <= schedules[j][0]) {
                    output.append("J");
                    jEndTime = schedules[j][1];
                    jStartTime = schedules[j][0];
                } else if (jStartTime >= schedules[j][1]) {
                    output.append("J");
                    jStartTime = schedules[j][1];
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                output = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}