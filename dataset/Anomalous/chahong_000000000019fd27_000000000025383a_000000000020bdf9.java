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

            char[] assignment = new char[t];
            Arrays.fill(assignment, ' ');

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int[] task : schedule) {
                if (cEnd <= task[0]) {
                    cEnd = task[1];
                    assignTask(assignment, startTimes, task[0], 'C');
                } else if (jEnd <= task[0]) {
                    jEnd = task[1];
                    assignTask(assignment, startTimes, task[0], 'J');
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(assignment) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static void assignTask(char[] assignment, int[] startTimes, int startTime, char worker) {
        for (int i = 0; i < startTimes.length; i++) {
            if (startTimes[i] == startTime && assignment[i] == ' ') {
                assignment[i] = worker;
                break;
            }
        }
    }
}