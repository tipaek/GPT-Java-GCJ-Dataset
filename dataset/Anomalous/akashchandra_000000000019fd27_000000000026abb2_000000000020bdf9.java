import java.util.Scanner;

class Solution {

    public static void merge(int[][] intervals, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
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

        for (int i = 0; i < temp.length; i++) {
            intervals[start + i] = temp[i];
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

    public static String calculateSchedule(int[][] intervals, int[][] original, int n) {
        mergeSort(intervals, 0, n - 1);
        int[] mapping = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (intervals[i][0] == original[j][0] && intervals[i][1] == original[j][1]) {
                    mapping[i] = j;
                    break;
                }
            }
        }

        StringBuilder schedule = new StringBuilder("CJ");
        int cameronEnd = 0;
        int jamieEnd = 1;

        for (int i = 2; i < n; i++) {
            if (intervals[i][0] < intervals[cameronEnd][1] && intervals[i][0] < intervals[jamieEnd][1]) {
                return "IMPOSSIBLE";
            } else if (intervals[i][0] >= intervals[cameronEnd][1]) {
                schedule.append("C");
                cameronEnd = i;
            } else {
                schedule.append("J");
                jamieEnd = i;
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[mapping[i]] = schedule.charAt(i);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] original = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                original[i][0] = intervals[i][0];
                original[i][1] = intervals[i][1];
            }

            String result = calculateSchedule(intervals, original, n);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}