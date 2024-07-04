import java.util.Scanner;

public class Solution {
    static int t, n;
    static int[][] intervals;
    static int[] cSchedule, jSchedule;
    static String[] result;
    static boolean impossible;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            n = input.nextInt();
            intervals = new int[n][2];
            result = new String[n];
            impossible = false;

            for (int i = 0; i < n; i++) {
                intervals[i][0] = input.nextInt();
                intervals[i][1] = input.nextInt();
            }

            System.out.print("Case #" + testCase + ": ");
            cSchedule = new int[1440];
            jSchedule = new int[1440];

            for (int i = 0; i < n; i++) {
                if (assignToC(intervals[i][0], intervals[i][1])) {
                    result[i] = "C";
                } else if (assignToJ(intervals[i][0], intervals[i][1])) {
                    result[i] = "J";
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (String res : result) {
                    System.out.print(res);
                }
            }
            System.out.println();
        }
    }

    static boolean assignToC(int start, int end) {
        for (int i = start; i < end; i++) {
            cSchedule[i]++;
            if (cSchedule[i] >= 2) {
                for (int j = i; j >= start; j--) {
                    cSchedule[j]--;
                }
                return false;
            }
        }
        return true;
    }

    static boolean assignToJ(int start, int end) {
        for (int i = start; i < end; i++) {
            jSchedule[i]++;
            if (jSchedule[i] >= 2) {
                for (int j = i; j >= start; j--) {
                    jSchedule[j]--;
                }
                return false;
            }
        }
        return true;
    }
}