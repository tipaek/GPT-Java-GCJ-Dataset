import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int z = 1; z <= t; z++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[] countArray = new int[n + 1];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < n; i++) {
                int uniqueCount = 0;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (countArray[matrix[i][j]] == 0) {
                        countArray[matrix[i][j]] = 1;
                        uniqueCount++;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (uniqueCount != n) {
                    rowCount++;
                }
                Arrays.fill(countArray, 0);
            }

            for (int j = 0; j < n; j++) {
                int uniqueCount = 0;
                for (int i = 0; i < n; i++) {
                    if (countArray[matrix[i][j]] == 0) {
                        countArray[matrix[i][j]] = 1;
                        uniqueCount++;
                    }
                }
                if (uniqueCount != n) {
                    colCount++;
                }
                Arrays.fill(countArray, 0);
            }

            System.out.println("Case #" + z + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}