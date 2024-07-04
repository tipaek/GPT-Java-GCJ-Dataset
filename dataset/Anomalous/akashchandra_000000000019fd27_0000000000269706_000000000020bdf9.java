import java.util.Scanner;

class Solution {

    public static void merge(int[][] intervals, int start, int mid, int end) {
        int leftIndex = start, rightIndex = mid + 1;
        int[][] temp = new int[end - start + 1][2];
        int tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (intervals[leftIndex][0] <= intervals[rightIndex][0]) {
                temp[tempIndex++] = intervals[leftIndex++];
            } else {
                temp[tempIndex++] = intervals[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = intervals[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[tempIndex++] = intervals[rightIndex++];
        }

        System.arraycopy(temp, 0, intervals, start, temp.length);
    }

    public static void mergeSort(int[][] intervals, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(intervals, start, mid);
            mergeSort(intervals, mid + 1, end);
            merge(intervals, start, mid, end);
        }
    }

    public static String assignTasks(int[][] originalIntervals, int[][] sortedIntervals, int n) {
        StringBuilder result = new StringBuilder("CJ");
        mergeSort(sortedIntervals, 0, n - 1);

        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (originalIntervals[i][0] == sortedIntervals[j][0] && originalIntervals[i][1] == sortedIntervals[j][1]) {
                    indexMap[j] = i;
                }
            }
        }

        int cameronEnd = 0, jamieEnd = 1;
        for (int i = 2; i < n; i++) {
            if (sortedIntervals[i][0] < sortedIntervals[cameronEnd][1] && sortedIntervals[i][0] < sortedIntervals[jamieEnd][1]) {
                return "IMPOSSIBLE";
            } else if (sortedIntervals[i][0] >= sortedIntervals[cameronEnd][1]) {
                result.append("C");
                cameronEnd = i;
            } else if (sortedIntervals[i][0] >= sortedIntervals[jamieEnd][1]) {
                result.append("J");
                jamieEnd = i;
            }
        }

        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalResult.append(result.charAt(indexMap[i]));
        }

        return finalResult.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                originalIntervals[i] = intervals[i].clone();
            }

            String result = assignTasks(originalIntervals, intervals, n);
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}