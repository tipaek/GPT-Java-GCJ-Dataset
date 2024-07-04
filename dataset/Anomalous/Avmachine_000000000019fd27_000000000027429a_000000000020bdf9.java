import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            String result = assignActivities(n, startTimes, endTimes);
            System.out.println("Case #" + x + ": " + result);
        }
    }

    private static String assignActivities(int n, int[] startTimes, int[] endTimes) {
        int cStart = -1, cEnd = -1, jStart = -1, jEnd = -1;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (cEnd <= startTimes[i] || cStart >= endTimes[i]) {
                schedule.append("C");
                cStart = (cStart == -1) ? startTimes[i] : Math.min(cStart, startTimes[i]);
                cEnd = (cEnd == -1) ? endTimes[i] : Math.max(cEnd, endTimes[i]);
            } else if (jEnd <= startTimes[i] || jStart >= endTimes[i]) {
                schedule.append("J");
                jStart = (jStart == -1) ? startTimes[i] : Math.min(jStart, startTimes[i]);
                jEnd = (jEnd == -1) ? endTimes[i] : Math.max(jEnd, endTimes[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}