import java.util.Scanner;

public class Set1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[][] arr = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = input.nextInt();
                }
            }

            int trace = calculateTrace(arr, n);
            int repeatedRow = countRepeatedRows(arr, n);
            int repeatedCol = countRepeatedCols(arr, n);

            System.out.println("case#" + (i + 1) + ": " + trace + " " + repeatedRow + " " + repeatedCol);
        }
    }

    private static int calculateTrace(int[][] arr, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += arr[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] arr, int n) {
        int repeatedRow = 0;
        for (int row = 0; row < n; row++) {
            if (hasDuplicates(arr[row])) {
                repeatedRow++;
            }
        }
        return repeatedRow;
    }

    private static int countRepeatedCols(int[][] arr, int n) {
        int repeatedCol = 0;
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = arr[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedCol++;
            }
        }
        return repeatedCol;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value > 0 && value <= array.length && seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}