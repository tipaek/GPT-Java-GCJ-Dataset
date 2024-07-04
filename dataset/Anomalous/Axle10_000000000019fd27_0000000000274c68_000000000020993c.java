import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            int countRow = 0, countCol = 0;

            for (int i = 0; i < n; i++) {
                if (hasDuplicate(arr[i])) {
                    countRow++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicate(getColumn(arr, i))) {
                    countCol++;
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + sum + " " + countRow + " " + countCol);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}