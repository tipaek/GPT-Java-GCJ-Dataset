import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;

            for (int i = 0; i < size; i++) {
                int[] rowCheck = new int[size];
                boolean rowHasDuplicates = false;
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowCheck[matrix[i][j] - 1]++;
                    if (rowCheck[matrix[i][j] - 1] > 1) {
                        rowHasDuplicates = true;
                    }
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            for (int i = 0; i < size; i++) {
                int[] colCheck = new int[size];
                boolean colHasDuplicates = false;
                for (int j = 0; j < size; j++) {
                    colCheck[matrix[j][i] - 1]++;
                    if (colCheck[matrix[j][i] - 1] > 1) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}