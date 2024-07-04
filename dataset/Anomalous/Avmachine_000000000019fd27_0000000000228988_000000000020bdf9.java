import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            int cameronStart = 0, cameronEnd = 0;
            int jamieStart = 0, jamieEnd = 0;
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();

                if (possible) {
                    if (cameronEnd <= startTimes[i] || cameronStart >= endTimes[i]) {
                        schedule.append("C");
                        cameronStart = startTimes[i];
                        cameronEnd = endTimes[i];
                    } else if (jamieEnd <= startTimes[i] || jamieStart >= endTimes[i]) {
                        schedule.append("J");
                        jamieStart = startTimes[i];
                        jamieEnd = endTimes[i];
                    } else {
                        possible = false;
                        schedule = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            System.out.println("Case #" + x + ": " + schedule.toString());
        }

        sc.close();
    }
}