import java.util.Scanner;

public class Solution {

    public static void ref(int[][] ar, int n, int q) {
        int diagonalSum = 0;
        int rowCount = 0;
        int colCount = 0;

        int[] rowFrequency = new int[10];
        int[] colFrequency = new int[10];

        for (int i = 0; i < n; i++) {
            Arrays.fill(rowFrequency, 0);
            Arrays.fill(colFrequency, 0);

            for (int j = 0; j < n; j++) {
                rowFrequency[ar[i][j]]++;
                colFrequency[ar[j][i]]++;

                if (i == j) {
                    diagonalSum += ar[i][j];
                }
            }

            if (containsNonZero(rowFrequency)) {
                rowCount++;
            }
            if (containsNonZero(colFrequency)) {
                colCount++;
            }
        }

        System.out.format("Case #%d: %d %d %d\n", q, diagonalSum, rowCount, colCount);
    }

    private static boolean containsNonZero(int[] arr) {
        for (int value : arr) {
            if (value > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    arr[row][col] = sc.nextInt();
                }
            }

            ref(arr, n, i);
        }
    }
}