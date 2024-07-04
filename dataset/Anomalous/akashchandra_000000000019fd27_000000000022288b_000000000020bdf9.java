import java.util.Scanner;

class Solution {
    public static void merge(int[][] m, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int[][] tempArray = new int[end - start + 1][2];
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (m[leftIndex][0] <= m[rightIndex][0]) {
                tempArray[tempIndex][0] = m[leftIndex][0];
                tempArray[tempIndex++][1] = m[leftIndex++][1];
            } else {
                tempArray[tempIndex][0] = m[rightIndex][0];
                tempArray[tempIndex++][1] = m[rightIndex++][1];
            }
        }

        while (leftIndex <= mid) {
            tempArray[tempIndex][0] = m[leftIndex][0];
            tempArray[tempIndex++][1] = m[leftIndex++][1];
        }

        while (rightIndex <= end) {
            tempArray[tempIndex][0] = m[rightIndex][0];
            tempArray[tempIndex++][1] = m[rightIndex++][1];
        }

        for (int i = 0; i < tempIndex; i++) {
            m[start][0] = tempArray[i][0];
            m[start++][1] = tempArray[i][1];
        }
    }

    public static void mergeSort(int[][] m, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(m, start, mid);
            mergeSort(m, mid + 1, end);
            merge(m, start, mid, end);
        }
    }

    public static String calculateSchedule(int[][] intervals, int n) {
        StringBuilder schedule = new StringBuilder("CJ");
        mergeSort(intervals, 0, n - 1);
        int c = 0;
        int j = 1;

        for (int i = 2; i < n; i++) {
            if (intervals[i][0] >= intervals[c][1]) {
                schedule.append("C");
                c = i;
            } else if (intervals[i][0] >= intervals[j][1]) {
                schedule.append("J");
                j = i;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
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