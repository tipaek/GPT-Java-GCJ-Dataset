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

    public static String calculateSchedule(int[][] a, int[][] b, int n) {
        StringBuilder schedule = new StringBuilder("C");
        mergeSort(a, 0, n - 1);
        int[] originalOrder = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][0] == b[j][0] && a[i][1] == b[j][1]) {
                    originalOrder[j] = i;
                }
            }
        }

        int cIndex = 0;
        int jIndex = 0;

        if (a[1][0] >= a[0][1]) {
            schedule.append("C");
            cIndex = 1;
        } else {
            schedule.append("J");
            jIndex = 1;
        }

        for (int i = 2; i < n; i++) {
            if (a[i][0] < a[cIndex][1] && a[i][0] < a[jIndex][1]) {
                return "IMPOSSIBLE";
            } else if (a[i][0] >= a[cIndex][1]) {
                schedule.append("C");
                cIndex = i;
            } else {
                schedule.append("J");
                jIndex = i;
            }
        }

        StringBuilder finalSchedule = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalSchedule.append(schedule.charAt(originalOrder[i]));
        }

        return finalSchedule.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
                originalIntervals[j][0] = intervals[j][0];
                originalIntervals[j][1] = intervals[j][1];
            }

            String result = calculateSchedule(intervals, originalIntervals, n);
            System.out.println("Case #" + i + ": " + result);
        }

        sc.close();
    }
}