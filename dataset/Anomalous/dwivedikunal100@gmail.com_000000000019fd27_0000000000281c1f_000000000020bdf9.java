import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            char[] schedule = new char[n];
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

            int cEnd = 0, jEnd = 0;

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int index = intervals[i][2];

                if (cEnd <= start) {
                    schedule[index] = 'C';
                    cEnd = end;
                } else if (jEnd <= start) {
                    schedule[index] = 'J';
                    jEnd = end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                System.out.printf("Case #%d: %s\n", testCase, new String(schedule));
            }
        }
    }
}