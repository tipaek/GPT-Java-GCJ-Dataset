import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            processCase(t, activityCount, startTimes, endTimes);
        }
    }

    private static void processCase(int caseNumber, int activityCount, int[] startTimes, int[] endTimes) {
        int[] cSchedule = new int[1441];
        int[] jSchedule = new int[1441];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < activityCount; i++) {
            int start = startTimes[i];
            int end = endTimes[i];
            boolean cConflict = false;
            boolean jConflict = false;

            for (int time = start + 1; time <= end; time++) {
                if (cSchedule[time] != 0) cConflict = true;
                if (jSchedule[time] != 0) jConflict = true;
            }

            if (cConflict && jConflict) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            } else {
                if (!cConflict) {
                    for (int time = start; time <= end; time++) {
                        cSchedule[time] = 1;
                    }
                    result.append("C");
                } else if (!jConflict) {
                    for (int time = start; time <= end; time++) {
                        jSchedule[time] = 1;
                    }
                    result.append("J");
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}