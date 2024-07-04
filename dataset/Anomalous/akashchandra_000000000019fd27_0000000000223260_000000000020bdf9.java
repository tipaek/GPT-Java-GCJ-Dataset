import java.util.Scanner;

class Solution {

    public static void merge(int[][] intervals, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int[][] temp = new int[end - start + 1][2];
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (intervals[leftIndex][0] <= intervals[rightIndex][0]) {
                temp[tempIndex][0] = intervals[leftIndex][0];
                temp[tempIndex++][1] = intervals[leftIndex++][1];
            } else {
                temp[tempIndex][0] = intervals[rightIndex][0];
                temp[tempIndex++][1] = intervals[rightIndex++][1];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex][0] = intervals[leftIndex][0];
            temp[tempIndex++][1] = intervals[leftIndex++][1];
        }

        while (rightIndex <= end) {
            temp[tempIndex][0] = intervals[rightIndex][0];
            temp[tempIndex++][1] = intervals[rightIndex++][1];
        }

        for (int i = 0; i < temp.length; i++) {
            intervals[start + i][0] = temp[i][0];
            intervals[start + i][1] = temp[i][1];
        }
    }

    public static void mergeSort(int[][] intervals, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(intervals, start, mid);
            mergeSort(intervals, mid + 1, end);
            merge(intervals, start, mid, end);
        }
    }

    public static String calculateSchedule(int[][] intervals, int n) {
        mergeSort(intervals, 0, n - 1);
        StringBuilder schedule = new StringBuilder("CJ");
        int cameronLastEnd = 0;
        int jamieLastEnd = 1;

        for (int i = 2; i < n; i++) {
            if (intervals[i][0] >= intervals[cameronLastEnd][1]) {
                schedule.append("C");
                cameronLastEnd = i;
            } else if (intervals[i][0] >= intervals[jamieLastEnd][1]) {
                schedule.append("J");
                jamieLastEnd = i;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = calculateSchedule(intervals, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}