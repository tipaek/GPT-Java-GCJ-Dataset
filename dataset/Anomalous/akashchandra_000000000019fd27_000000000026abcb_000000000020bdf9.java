import java.util.Scanner;

class Solution {

    public static void merge(int[][] intervals, int start, int mid, int end) {
        int left = start, right = mid + 1;
        int[][] temp = new int[end - start + 1][2];
        int index = 0;

        while (left <= mid && right <= end) {
            if (intervals[left][0] <= intervals[right][0]) {
                temp[index][0] = intervals[left][0];
                temp[index++][1] = intervals[left++][1];
            } else {
                temp[index][0] = intervals[right][0];
                temp[index++][1] = intervals[right++][1];
            }
        }

        while (left <= mid) {
            temp[index][0] = intervals[left][0];
            temp[index++][1] = intervals[left++][1];
        }

        while (right <= end) {
            temp[index][0] = intervals[right][0];
            temp[index++][1] = intervals[right++][1];
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

    public static String calculate(int[][] original, int[][] sorted, int n) {
        StringBuilder result = new StringBuilder("CJ");
        mergeSort(sorted, 0, n - 1);

        int[] indexMap = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (original[i][0] == sorted[j][0] && original[i][1] == sorted[j][1]) {
                    indexMap[j] = i;
                    break;
                }
            }
        }

        int cameron = 0, jamie = 1;
        for (int i = 2; i < n; i++) {
            if (sorted[i][0] < sorted[cameron][1] && sorted[i][0] < sorted[jamie][1]) {
                return "IMPOSSIBLE";
            } else if (sorted[i][0] >= sorted[cameron][1]) {
                result.append("C");
                cameron = i;
            } else {
                result.append("J");
                jamie = i;
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
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] original = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                original[j][0] = intervals[j][0];
                original[j][1] = intervals[j][1];
            }
            String result = calculate(original, intervals, n);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}