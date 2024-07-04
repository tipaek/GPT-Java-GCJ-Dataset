import java.util.Scanner;

public class Main {
    public static void ref(int[][] ar, int n, int q) {
        int diagonalSum = 0, rowCount = 0, colCount = 0;
        int[] rowFrequency = new int[10];
        int[] colFrequency = new int[10];

        for (int i = 0; i < n; i++) {
            Arrays.fill(rowFrequency, 0);
            Arrays.fill(colFrequency, 0);

            for (int j = 0; j < n; j++) {
                // Sum of the diagonal elements
                if (i == j) {
                    diagonalSum += ar[i][j];
                }

                // Row frequency
                rowFrequency[ar[i][j]]++;

                // Column frequency
                colFrequency[ar[j][i]]++;
            }

            // Check if the row contains all unique elements
            for (int freq : rowFrequency) {
                if (freq > 1) {
                    rowCount++;
                    break;
                }
            }

            // Check if the column contains all unique elements
            for (int freq : colFrequency) {
                if (freq > 1) {
                    colCount++;
                    break;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", q, diagonalSum, rowCount, colCount);
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

        sc.close();
    }
}