import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            // Reading matrix and calculating diagonal sum
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Checking for duplicate values in rows
            for (int i = 0; i < size; i++) {
                List<Integer> rowValues = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    rowValues.add(matrix[i][j]);
                }
                for (int k = 1; k <= size; k++) {
                    if (!rowValues.contains(k)) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < size; j++) {
                List<Integer> colValues = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    colValues.add(matrix[i][j]);
                }
                for (int k = 1; k <= size; k++) {
                    if (!colValues.contains(k)) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t + 1, diagonalSum, rowDuplicates, colDuplicates);
        }
        
        scanner.close();
    }
}