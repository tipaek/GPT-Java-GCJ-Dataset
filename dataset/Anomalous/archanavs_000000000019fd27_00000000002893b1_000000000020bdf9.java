import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        int[] cameronSchedule = new int[1441];
        int[] jamieSchedule = new int[1441];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < activityCount; i++) {
            int start = startTimes[i];
            int end = endTimes[i];
            boolean cameronAvailable = true;
            boolean jamieAvailable = true;

            for (int j = start; j < end; j++) {
                if (cameronSchedule[j] != 0) cameronAvailable = false;
                if (jamieSchedule[j] != 0) jamieAvailable = false;
            }

            if (!cameronAvailable && !jamieAvailable) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            } else if (cameronAvailable) {
                for (int j = start; j < end; j++) {
                    cameronSchedule[j] = 1;
                }
                result.append("C");
            } else {
                for (int j = start; j < end; j++) {
                    jamieSchedule[j] = 1;
                }
                result.append("J");
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}