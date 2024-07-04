import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int x = 1; x <= t; x++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int cameronStart = -1, cameronEnd = -1;
            int jamieStart = -1, jamieEnd = -1;
            StringBuilder schedule = new StringBuilder();

            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                if (cameronEnd <= startTimes[i] || cameronStart >= endTimes[i]) {
                    schedule.append("C");
                    cameronStart = (cameronStart == -1) ? startTimes[i] : Math.min(cameronStart, startTimes[i]);
                    cameronEnd = Math.max(cameronEnd, endTimes[i]);
                } else if (jamieEnd <= startTimes[i] || jamieStart >= endTimes[i]) {
                    schedule.append("J");
                    jamieStart = (jamieStart == -1) ? startTimes[i] : Math.min(jamieStart, startTimes[i]);
                    jamieEnd = Math.max(jamieEnd, endTimes[i]);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            result.append("Case #").append(x).append(": ").append(schedule);
            if (x != t) {
                result.append("\n");
            }
        }

        System.out.print(result.toString());
        scanner.close();
    }
}