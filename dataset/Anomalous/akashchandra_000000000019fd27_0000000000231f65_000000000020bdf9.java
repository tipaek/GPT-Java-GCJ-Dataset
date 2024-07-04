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

    public static String calc(int[][] a, int[][] b, int n) {
        String schedule = "CJ";
        mergeSort(a, 0, n - 1);

        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][0] == b[j][0] && a[i][1] == b[j][1]) {
                    indexMap[i] = j;
                }
            }
        }

        int cIndex = 0;
        int jIndex = 1;
        for (int i = 2; i < n; i++) {
            if (a[i][0] >= a[cIndex][1]) {
                schedule += "C";
                cIndex = i;
            } else if (a[i][0] >= a[jIndex][1]) {
                schedule += "J";
                jIndex = i;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder finalSchedule = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalSchedule.append(schedule.charAt(indexMap[i]));
        }
        return finalSchedule.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] a = new int[n][2];
            int[][] b = new int[n][2];
            for (int j = 0; j < n; j++) {
                a[j][0] = sc.nextInt();
                a[j][1] = sc.nextInt();
                b[j][0] = a[j][0];
                b[j][1] = a[j][1];
            }
            String result = calc(a, b, n);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }
}