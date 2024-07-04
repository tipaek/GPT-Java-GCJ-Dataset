import java.util.Scanner;

public class Solution {

    static void arrangeSchedule(int[][] intervals, int caseNumber) {
        int[][] cameronSchedule = new int[intervals.length][2];
        int[][] jamieSchedule = new int[intervals.length][2];
        int cameronCount = 0, jamieCount = 0;
        StringBuilder result = new StringBuilder();

        for (int[] interval : intervals) {
            boolean cameronConflict = false, jamieConflict = false;

            for (int i = 0; i < cameronCount; i++) {
                if (isOverlapping(interval[0], interval[1], cameronSchedule[i][0], cameronSchedule[i][1])) {
                    cameronConflict = true;
                    break;
                }
            }

            if (cameronConflict) {
                for (int i = 0; i < jamieCount; i++) {
                    if (isOverlapping(interval[0], interval[1], jamieSchedule[i][0], jamieSchedule[i][1])) {
                        jamieConflict = true;
                        break;
                    }
                }
            }

            if (cameronConflict && jamieConflict) {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            } else {
                if (!cameronConflict) {
                    result.append("C");
                    cameronSchedule[cameronCount++] = interval;
                } else {
                    result.append("J");
                    jamieSchedule[jamieCount++] = interval;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }

    static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];

            for (int j = 0; j < activities; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            arrangeSchedule(intervals, i);
        }

        scanner.close();
    }
}