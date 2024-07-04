import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[] originalOrder = new int[24 * 60 + 1];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                originalOrder[intervals[i][0]] = i;
                assignments[i] = ' ';
            }

            sort(intervals, 0, n - 1);

            int endC = -1, endJ = -1;
            boolean possible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= endC) {
                    endC = intervals[i][1];
                    assignments[originalOrder[intervals[i][0]]] = 'C';
                } else if (intervals[i][0] >= endJ) {
                    endJ = intervals[i][1];
                    assignments[originalOrder[intervals[i][0]]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (char assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + (t + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static void sort(int[][] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[][] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i][0] <= rightArray[j][0]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}