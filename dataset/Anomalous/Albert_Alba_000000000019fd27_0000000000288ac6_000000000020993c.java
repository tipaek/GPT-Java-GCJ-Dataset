import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read matrix values
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");

            // Calculate the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }
            System.out.print(diagonalSum + " ");

            // Calculate the number of rows with duplicate values
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != size) {
                    duplicateRows++;
                }
            }
            System.out.print(duplicateRows + " ");

            // Calculate the number of columns with duplicate values
            int duplicateColumns = 0;
            for (int j = 0; j < size; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() != size) {
                    duplicateColumns++;
                }
            }
            System.out.println(duplicateColumns);
        }

        scanner.close();
    }
}