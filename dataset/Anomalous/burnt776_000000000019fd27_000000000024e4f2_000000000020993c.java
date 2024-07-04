import java.util.*;
import java.io.*;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = sc.nextInt();

        for (int q = 1; q <= numberOfMatrices; q++) {
            System.out.println("Enter the matrix size:");
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            // Reading matrix elements
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Calculating diagonal sum
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < size; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + q + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}