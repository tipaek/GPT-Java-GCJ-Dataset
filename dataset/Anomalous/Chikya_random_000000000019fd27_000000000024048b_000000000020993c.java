import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
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

            // Checking for duplicate values in each row
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in each column
            for (int i = 0; i < size; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
            caseNumber++;
        }

        scanner.close();
    }
}