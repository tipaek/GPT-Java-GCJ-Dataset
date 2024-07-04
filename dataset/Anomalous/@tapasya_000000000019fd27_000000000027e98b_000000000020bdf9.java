import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[] indices = new int[n];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                indices[j] = j + 1;
            }

            sortIntervals(intervals, indices);

            char[] schedule = new char[n];
            int C = -1, J = -1;

            if (!assignTasks(intervals, schedule, C, J)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }

            reorderSchedule(indices, schedule);
            System.out.println("Case #" + (i + 1) + ": " + new String(schedule));
        }
    }

    private static void sortIntervals(int[][] intervals, int[] indices) {
        for (int j = 0; j < intervals.length - 1; j++) {
            for (int k = j + 1; k < intervals.length; k++) {
                if (intervals[j][0] > intervals[k][0]) {
                    swap(intervals, j, k);
                    swap(indices, j, k);
                }
            }
        }
    }

    private static void swap(int[][] intervals, int j, int k) {
        int temp0 = intervals[j][0];
        int temp1 = intervals[j][1];
        intervals[j][0] = intervals[k][0];
        intervals[j][1] = intervals[k][1];
        intervals[k][0] = temp0;
        intervals[k][1] = temp1;
    }

    private static void swap(int[] indices, int j, int k) {
        int temp = indices[j];
        indices[j] = indices[k];
        indices[k] = temp;
    }

    private static boolean assignTasks(int[][] intervals, char[] schedule, int C, int J) {
        for (int k = 0; k < intervals.length; k++) {
            if (intervals[k][0] >= C) {
                schedule[k] = 'C';
                C = intervals[k][1];
            } else if (intervals[k][0] >= J) {
                schedule[k] = 'J';
                J = intervals[k][1];
            } else {
                return false;
            }
        }
        return true;
    }

    private static void reorderSchedule(int[] indices, char[] schedule) {
        for (int j = 0; j < indices.length - 1; j++) {
            for (int k = j + 1; k < indices.length; k++) {
                if (indices[j] > indices[k]) {
                    swap(indices, j, k);
                    char temp = schedule[j];
                    schedule[j] = schedule[k];
                    schedule[k] = temp;
                }
            }
        }
    }
}