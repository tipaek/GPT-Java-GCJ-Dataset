import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    arr[r][c] = in.nextInt();
                    if (r == c) {
                        trace += arr[r][c];
                    }
                }
            }

            for (int r = 0; r < n; ++r) {
                if (hasDuplicates(arr[r])) {
                    rowRepeats++;
                }
            }

            for (int c = 0; c < n; ++c) {
                if (hasDuplicates(getColumn(arr, c))) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }
}