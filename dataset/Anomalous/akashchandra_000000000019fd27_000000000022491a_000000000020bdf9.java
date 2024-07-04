import java.util.Scanner;

class Solution {

    public static void merge(int[][] m, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int[][] tempArray = new int[end - start + 1][2];
        int k = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (m[leftIndex][0] <= m[rightIndex][0]) {
                tempArray[k][0] = m[leftIndex][0];
                tempArray[k++][1] = m[leftIndex++][1];
            } else {
                tempArray[k][0] = m[rightIndex][0];
                tempArray[k++][1] = m[rightIndex++][1];
            }
        }

        while (leftIndex <= mid) {
            tempArray[k][0] = m[leftIndex][0];
            tempArray[k++][1] = m[leftIndex++][1];
        }

        while (rightIndex <= end) {
            tempArray[k][0] = m[rightIndex][0];
            tempArray[k++][1] = m[rightIndex++][1];
        }

        for (int i = 0; i < k; i++) {
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
        int cIndex = 0;
        int jIndex = 1;

        for (int i = 2; i < n; i++) {
            if (intervals[i][0] >= intervals[cIndex][1] || intervals[i][1] <= intervals[cIndex][0]) {
                schedule.append("C");
                cIndex = i;
            } else if (intervals[i][0] >= intervals[jIndex][1] || intervals[i][1] <= intervals[jIndex][0]) {
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