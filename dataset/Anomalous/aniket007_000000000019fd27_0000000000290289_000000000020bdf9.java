import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int[][] intervals = new int[2][n];
            int[][] cameron = new int[2][n];
            int[][] jamie = new int[2][n];
            int cameronCount = 0, jamieCount = 0;
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                intervals[0][j] = sc.nextInt();
                intervals[1][j] = sc.nextInt();
            }

            sortIntervals(intervals);

            outer:
            for (int j = 0; j < n; j++) {
                int start = intervals[0][j];
                int end = intervals[1][j];
                boolean assigned = false;

                if (canAssign(cameron, cameronCount, start, end)) {
                    cameron[0][cameronCount] = start;
                    cameron[1][cameronCount] = end;
                    schedule.append("C");
                    cameronCount++;
                    assigned = true;
                }

                if (!assigned && canAssign(jamie, jamieCount, start, end)) {
                    jamie[0][jamieCount] = start;
                    jamie[1][jamieCount] = end;
                    schedule.append("J");
                    jamieCount++;
                    assigned = true;
                }

                if (!assigned) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break outer;
                }
            }

            if (!impossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
        sc.close();
    }

    static void sortIntervals(int[][] intervals) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[0][j] > intervals[0][j + 1]) {
                    swap(intervals, j, j + 1);
                }
            }
        }
    }

    static void swap(int[][] intervals, int i, int j) {
        int tempStart = intervals[0][i];
        int tempEnd = intervals[1][i];
        intervals[0][i] = intervals[0][j];
        intervals[1][i] = intervals[1][j];
        intervals[0][j] = tempStart;
        intervals[1][j] = tempEnd;
    }

    static boolean canAssign(int[][] person, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if ((start >= person[0][i] && start < person[1][i]) || (end > person[0][i] && end <= person[1][i])) {
                return false;
            }
        }
        return true;
    }
}