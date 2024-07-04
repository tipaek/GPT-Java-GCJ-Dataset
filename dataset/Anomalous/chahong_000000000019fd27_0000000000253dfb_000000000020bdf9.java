import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] schedule = new int[t][2];
            int[] startTimes = new int[t];
            int maxEndTime = 0;

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                startTimes[j] = schedule[j][0];
                maxEndTime = Math.max(maxEndTime, schedule[j][1]);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] assignments = new char[t];
            assignments[findIndex(startTimes, schedule[0][0])] = 'C';

            int cEndTime = schedule[0][1];
            int jEndTime = 0;
            boolean cAvailable = false;
            boolean jAvailable = true;
            boolean possible = true;
            int position = 1;

            for (int time = schedule[1][0]; time < maxEndTime; time++) {
                if (cEndTime == time) cAvailable = true;
                if (jEndTime == time) jAvailable = true;

                if (schedule[position][0] == time) {
                    if (!cAvailable) {
                        if (!jAvailable) {
                            possible = false;
                            break;
                        } else {
                            jAvailable = false;
                            jEndTime = schedule[position][1];
                            assignments[findIndex(startTimes, schedule[position][0])] = 'J';
                        }
                    } else {
                        cAvailable = false;
                        cEndTime = schedule[position][1];
                        assignments[findIndex(startTimes, schedule[position][0])] = 'C';
                    }
                    position++;
                    if (position == t) break;
                }
            }

            String result = possible ? new String(assignments) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -1; // Should never reach here if input is correct
    }
}