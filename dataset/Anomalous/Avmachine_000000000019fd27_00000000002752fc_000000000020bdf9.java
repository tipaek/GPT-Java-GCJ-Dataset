import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder ans = new StringBuilder();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            String result = scheduleActivities(startTimes, endTimes, n);

            ans.append("Case #").append(x).append(": ").append(result);
            if (x != t) {
                ans.append("\n");
            }
        }

        System.out.print(ans.toString());
        sc.close();
    }

    private static String scheduleActivities(int[] startTimes, int[] endTimes, int n) {
        StringBuilder schedule = new StringBuilder();
        int cameronEnd = -1, jamieEnd = -1;

        for (int i = 0; i < n; i++) {
            if (cameronEnd <= startTimes[i]) {
                schedule.append("C");
                cameronEnd = endTimes[i];
            } else if (jamieEnd <= startTimes[i]) {
                schedule.append("J");
                jamieEnd = endTimes[i];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}