import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int[][] timeSlots = new int[scanner.nextInt()][3];
            for (int j = 0; j < timeSlots.length; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt();
            }

            String solution = "";
            int[] cameron = new int[1440];
            int[] jaime = new int[1440];

            for (int[] times : timeSlots) {
                int startTime = times[0];
                int endTime = times[1];

                if (isSafe(cameron, startTime, endTime)) {
                    fill(cameron, startTime, endTime);
                    solution += "C";
                } else if (isSafe(jaime, startTime, endTime)) {
                    fill(jaime, startTime, endTime);
                    solution += "J";
                } else {
                    solution = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    public static boolean isSafe(int[] min, int start, int end) {
        for (int i = start; i < end; i++) {
            if (min[i] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void fill(int[] min, int start, int end) {
        for (int i = start; i < end; i++) {
            min[i] = 1;
        }
    }
}