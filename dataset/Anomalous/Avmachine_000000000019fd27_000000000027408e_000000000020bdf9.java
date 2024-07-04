import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            String result = assignActivities(n, startTimes, endTimes);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignActivities(int n, int[] startTimes, int[] endTimes) {
        StringBuilder schedule = new StringBuilder();
        int cameronEnd = -1, jamieEnd = -1;

        for (int i = 0; i < n; i++) {
            if (cameronEnd <= startTimes[i]) {
                schedule.append('C');
                cameronEnd = endTimes[i];
            } else if (jamieEnd <= startTimes[i]) {
                schedule.append('J');
                jamieEnd = endTimes[i];
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}