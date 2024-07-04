import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            StringBuilder y = new StringBuilder();
            int cameronStart = -1, cameronEnd = -1;
            int jamieStart = -1, jamieEnd = -1;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (cameronEnd <= startTimes[i] || cameronStart >= endTimes[i]) {
                    y.append("C");
                    cameronStart = (cameronStart == -1) ? startTimes[i] : Math.min(cameronStart, startTimes[i]);
                    cameronEnd = (cameronEnd == -1) ? endTimes[i] : Math.max(cameronEnd, endTimes[i]);
                } else if (jamieEnd <= startTimes[i] || jamieStart >= endTimes[i]) {
                    y.append("J");
                    jamieStart = (jamieStart == -1) ? startTimes[i] : Math.min(jamieStart, startTimes[i]);
                    jamieEnd = (jamieEnd == -1) ? endTimes[i] : Math.max(jamieEnd, endTimes[i]);
                } else {
                    y = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            result.append("Case #").append(x).append(": ").append(y);
            if (x != t) {
                result.append("\n");
            }
        }

        System.out.print(result.toString());
        sc.close();
    }
}