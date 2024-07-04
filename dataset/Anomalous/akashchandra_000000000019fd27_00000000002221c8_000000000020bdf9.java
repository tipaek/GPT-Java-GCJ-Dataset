import java.util.Scanner;

class Solution {

    public static void merge(int[][] intervals, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int[][] tempArray = new int[end - start + 1][2];
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (intervals[leftIndex][0] <= intervals[rightIndex][0]) {
                tempArray[tempIndex][0] = intervals[leftIndex][0];
                tempArray[tempIndex++][1] = intervals[leftIndex++][1];
            } else {
                tempArray[tempIndex][0] = intervals[rightIndex][0];
                tempArray[tempIndex++][1] = intervals[rightIndex++][1];
            }
        }

        while (leftIndex <= mid) {
            tempArray[tempIndex][0] = intervals[leftIndex][0];
            tempArray[tempIndex++][1] = intervals[leftIndex++][1];
        }

        while (rightIndex <= end) {
            tempArray[tempIndex][0] = intervals[rightIndex][0];
            tempArray[tempIndex++][1] = intervals[rightIndex++][1];
        }

        for (int i = 0; i < tempArray.length; i++) {
            intervals[start + i][0] = tempArray[i][0];
            intervals[start + i][1] = tempArray[i][1];
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
        StringBuilder schedule = new StringBuilder("CJ");
        mergeSort(intervals, 0, n - 1);
        int cIndex = 0;
        int jIndex = 1;

        for (int i = 2; i < n; i++) {
            if (intervals[i][0] >= intervals[cIndex][1]) {
                schedule.append("C");
                cIndex = i;
            } else if (intervals[i][0] >= intervals[jIndex][1]) {
                schedule.append("J");
                jIndex = i;
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

        scanner.close();
    }
}