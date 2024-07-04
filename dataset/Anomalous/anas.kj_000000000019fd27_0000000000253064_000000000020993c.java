import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] numbers = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    numbers[row][col] = in.nextInt();
                }
            }

            int k = calculateTrace(numbers, n);
            int r = calculateDuplicateRows(numbers, n);
            int c = calculateDuplicateColumns(numbers, n);

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }

    private static int calculateTrace(int[][] numbers, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += numbers[i][i];
        }
        return trace;
    }

    private static int calculateDuplicateRows(int[][] numbers, int n) {
        int duplicateRows = 0;
        int[] temp = new int[n];

        for (int row = 0; row < n; row++) {
            System.arraycopy(numbers[row], 0, temp, 0, n);
            quickSort(temp, 0, n - 1);

            if (hasDuplicates(temp)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int calculateDuplicateColumns(int[][] numbers, int n) {
        int duplicateColumns = 0;
        int[] temp = new int[n];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                temp[row] = numbers[row][col];
            }
            quickSort(temp, 0, n - 1);

            if (hasDuplicates(temp)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}