import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder();
            schedule.append('j');
            int conflictCount = 0;

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] < intervals[i - 1][1]) {
                    if (schedule.charAt(schedule.length() - 1) == 'c') {
                        schedule.append('j');
                    } else {
                        schedule.append('c');
                    }
                    conflictCount++;
                } else {
                    schedule.append(schedule.charAt(schedule.length() - 1));
                }
            }

            if (schedule.length() == 0 || conflictCount == n - 1) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + schedule);
        }
    }
}