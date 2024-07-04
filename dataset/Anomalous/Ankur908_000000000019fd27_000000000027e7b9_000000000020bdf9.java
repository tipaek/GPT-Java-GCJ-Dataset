import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            boolean[] job1 = new boolean[1441];
            boolean[] job2 = new boolean[1441];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n; i++) {
                boolean conflictJob1 = false;
                boolean conflictJob2 = false;

                for (int time = startTimes[i]; time < endTimes[i]; time++) {
                    if (job1[time]) {
                        conflictJob1 = true;
                    }
                    if (job2[time]) {
                        conflictJob2 = true;
                    }
                }

                if (conflictJob1 && conflictJob2) {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                } else if (!conflictJob1) {
                    for (int time = startTimes[i]; time < endTimes[i]; time++) {
                        job1[time] = true;
                    }
                    schedule.append('C');
                } else {
                    for (int time = startTimes[i]; time < endTimes[i]; time++) {
                        job2[time] = true;
                    }
                    schedule.append('J');
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + schedule);
        }

        scanner.close();
    }
}