import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int traceValue = calculateTrace(arr);
            int rowCount = countRowsWithDuplicates(arr, n);
            int columnCount = countColumnsWithDuplicates(arr, n);

            System.out.println(traceValue + " " + rowCount + " " + columnCount);
        }

        sc.close();
    }

    private static int calculateTrace(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }

    private static int countRowsWithDuplicates(int[][] arr, int n) {
        int rowCount = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicate(arr[i])) {
                rowCount++;
            }
        }
        return rowCount;
    }

    private static int countColumnsWithDuplicates(int[][] arr, int n) {
        int columnCount = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicate(getColumn(arr, i))) {
                columnCount++;
            }
        }
        return columnCount;
    }

    private static boolean hasDuplicate(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}