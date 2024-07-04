import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[] indices = new int[n];
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                indices[j] = j + 1;
            }

            sortIntervals(intervals, indices);

            char[] assignments = new char[n];
            int endC = -1, endJ = -1;

            if (!assignTasks(intervals, assignments, endC, endJ)) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                continue;
            }

            reorderAssignments(indices, assignments);
            System.out.println("Case #" + (i + 1) + ": " + new String(assignments));
        }
    }

    private static void sortIntervals(int[][] intervals, int[] indices) {
        for (int j = 0; j < intervals.length - 1; j++) {
            for (int k = j + 1; k < intervals.length; k++) {
                if (intervals[j][0] > intervals[k][0]) {
                    swap(intervals, indices, j, k);
                }
            }
        }
    }

    private static void swap(int[][] intervals, int[] indices, int j, int k) {
        int tempStart = intervals[j][0];
        int tempEnd = intervals[j][1];
        intervals[j][0] = intervals[k][0];
        intervals[j][1] = intervals[k][1];
        intervals[k][0] = tempStart;
        intervals[k][1] = tempEnd;

        int tempIndex = indices[j];
        indices[j] = indices[k];
        indices[k] = tempIndex;
    }

    private static boolean assignTasks(int[][] intervals, char[] assignments, int endC, int endJ) {
        for (int k = 0; k < intervals.length; k++) {
            if (intervals[k][0] >= endC) {
                assignments[k] = 'C';
                endC = intervals[k][1];
            } else if (intervals[k][0] >= endJ) {
                assignments[k] = 'J';
                endJ = intervals[k][1];
            } else {
                return false;
            }
        }
        return true;
    }

    private static void reorderAssignments(int[] indices, char[] assignments) {
        for (int j = 0; j < indices.length - 1; j++) {
            for (int k = j + 1; k < indices.length; k++) {
                if (indices[j] > indices[k]) {
                    int tempIndex = indices[j];
                    indices[j] = indices[k];
                    indices[k] = tempIndex;

                    char tempChar = assignments[j];
                    assignments[j] = assignments[k];
                    assignments[k] = tempChar;
                }
            }
        }
    }
}