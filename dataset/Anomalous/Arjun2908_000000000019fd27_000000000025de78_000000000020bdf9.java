import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalStartTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                originalStartTimes[i] = startTimes[i];
            }

            int c1 = -1, c2 = -1;
            char[] schedule = new char[n];
            Arrays.fill(schedule, ' ');

            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = startTimes[i];
                intervals[i][1] = endTimes[i];
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (c1 == -1 || intervals[i][0] >= intervals[c1][1]) {
                    c1 = i;
                    schedule[intervals[i][2]] = 'C';
                } else if (c2 == -1 || intervals[i][0] >= intervals[c2][1]) {
                    c2 = i;
                    schedule[intervals[i][2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}