import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                int[] rowCheck = new int[n];
                boolean rowFlag = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowCheck[matrix[i][j] - 1]++;
                    if (rowCheck[matrix[i][j] - 1] > 1) {
                        rowFlag = true;
                    }
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowFlag) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] colCheck = new int[n];
                boolean colFlag = false;
                for (int i = 0; i < n; i++) {
                    colCheck[matrix[i][j] - 1]++;
                    if (colCheck[matrix[i][j] - 1] > 1) {
                        colFlag = true;
                    }
                }
                if (colFlag) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}