import java.util.Scanner;

public class Solution {

    public static void ref(int[][] ar, int n, int q) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        int[] rowFreq = new int[10];
        int[] colFreq = new int[10];

        for (int i = 0; i < n; i++) {
            Arrays.fill(rowFreq, 0);
            Arrays.fill(colFreq, 0);

            for (int j = 0; j < n; j++) {
                // Calculate trace
                if (i == j) {
                    trace += ar[i][j];
                }

                // Check for row duplicates
                rowFreq[ar[i][j]]++;
                if (rowFreq[ar[i][j]] > 1) {
                    rowDuplicates++;
                    break;
                }

                // Check for column duplicates
                colFreq[ar[j][i]]++;
                if (colFreq[ar[j][i]] > 1) {
                    colDuplicates++;
                    break;
                }
            }
        }

        System.out.format("Case #%d: %d %d %d\n", q, trace, rowDuplicates, colDuplicates);
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