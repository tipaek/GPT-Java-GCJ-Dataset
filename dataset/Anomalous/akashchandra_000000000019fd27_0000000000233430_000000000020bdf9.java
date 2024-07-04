import java.util.Scanner;

class Solution {
    public static void merge(int[][] intervals, int start, int mid, int end) {
        int leftIndex = start, rightIndex = mid + 1;
        int[][] tempArray = new int[end - start + 1][2];
        int k = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (intervals[leftIndex][0] <= intervals[rightIndex][0]) {
                tempArray[k][0] = intervals[leftIndex][0];
                tempArray[k++][1] = intervals[leftIndex++][1];
            } else {
                tempArray[k][0] = intervals[rightIndex][0];
                tempArray[k++][1] = intervals[rightIndex++][1];
            }
        }

        while (leftIndex <= mid) {
            tempArray[k][0] = intervals[leftIndex][0];
            tempArray[k++][1] = intervals[leftIndex++][1];
        }

        while (rightIndex <= end) {
            tempArray[k][0] = intervals[rightIndex][0];
            tempArray[k++][1] = intervals[rightIndex++][1];
        }

        for (int i = 0; i < k; i++) {
            intervals[start][0] = tempArray[i][0];
            intervals[start++][1] = tempArray[i][1];
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

    public static String calculateSchedule(int[][] original, int[][] sorted, int n) {
        String schedule = "CJ";
        mergeSort(sorted, 0, n - 1);
        int[] mapping = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sorted[i][0] == original[j][0] && sorted[i][1] == original[j][1]) {
                    mapping[i] = j;
                }
            }
        }

        int cameronLastIndex = 0, jamieLastIndex = 1;
        for (int i = 2; i < n; i++) {
            if (sorted[i][0] < sorted[cameronLastIndex][1] && sorted[i][0] < sorted[jamieLastIndex][1]) {
                return "IMPOSSIBLE";
            } else if (sorted[i][0] >= sorted[cameronLastIndex][1]) {
                schedule += "C";
                cameronLastIndex = i;
            } else if (sorted[i][0] >= sorted[jamieLastIndex][1]) {
                schedule += "J";
                jamieLastIndex = i;
            }
        }

        StringBuilder finalSchedule = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalSchedule.append(schedule.charAt(mapping[i]));
        }
        return finalSchedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    intervals[j][k] = scanner.nextInt();
                    originalIntervals[j][k] = intervals[j][k];
                }
            }

            String result = calculateSchedule(originalIntervals, intervals, n);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}