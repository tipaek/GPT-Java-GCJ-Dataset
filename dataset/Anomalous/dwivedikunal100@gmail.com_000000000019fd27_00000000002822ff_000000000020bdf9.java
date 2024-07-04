import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            char[] result = new char[n];

            int cAvailableTime = 0, jAvailableTime = 0;
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (cAvailableTime <= start) {
                    result[intervals[i][2]] = 'C';
                    cAvailableTime = end;
                } else if (jAvailableTime <= start) {
                    result[intervals[i][2]] = 'J';
                    jAvailableTime = end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                System.out.printf("Case #%d: %s\n", testCase, new String(result));
            }
        }
    }
}