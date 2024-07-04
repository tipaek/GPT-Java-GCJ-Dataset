import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            int arr[][] = new int[n][n];
            boolean solution = findSolution(0, 0, k, arr);
            if (solution) {
                System.out.println(String.format("Case #%d: POSSIBLE", i));
                for (int j = 0; j < n; j++) {
                    StringBuilder builder = new StringBuilder();
                    for (int l = 0; l < n; l++) {
                        builder.append(arr[j][l]);
                        builder.append(' ');
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    System.out.println(builder.toString());
                }
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i));
            }
        }
    }

    private static boolean findSolution(int row, int col, int k, int arr[][]) {
        if (row == arr.length) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i][i];
            }
            return sum == k;
        }
        int max = arr.length;
        int old = arr[row][col];
        boolean isRowEnd = col == arr.length - 1;
        for (int i = 1; i <= max; i++) {
            if (isUsedInRow(arr, row, i) || isUsedInColumn(arr, col, i)) continue;
            arr[row][col] = i;
            if (findSolution(isRowEnd ? row + 1 : row, isRowEnd ? 0 : col + 1, k, arr)) return true;
            arr[row][col] = old;
        }
        return false;
    }

    private static boolean isUsedInRow(int arr[][], int rowIndex, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[rowIndex][i] == num) return true;
        }
        return false;
    }

    private static boolean isUsedInColumn(int arr[][], int columnIndex, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][columnIndex] == num) return true;
        }
        return false;
    }

}