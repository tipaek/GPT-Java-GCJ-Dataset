import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }
            int rowsNumber = 0;
            int columnsNumber = 0;
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
                boolean[] row = new boolean[n + 1];
                boolean[] column = new boolean[n + 1];
                for (int c = 0; c < n; c++) {
                    int v = matrix[j][c];
                    if (row[v]) {
                        rowsNumber++;
                        break;
                    } else {
                        row[v] = true;
                    }
                }

                for (int r = 0; r < n; r++) {
                    int v = matrix[r][j];
                    if (column[v]) {
                        columnsNumber++;
                        break;
                    } else {
                        column[v] = true;
                    }
                }
            }
            System.out.println("#" + (t + 1) + ": " + diagonalSum + " " + rowsNumber + " " + columnsNumber);
        }
    }
}
