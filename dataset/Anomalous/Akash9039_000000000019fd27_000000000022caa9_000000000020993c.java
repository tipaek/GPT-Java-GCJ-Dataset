import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }

            // Counting rows with duplicate elements
            int duplicateRowsCount = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRowsCount++;
                }
            }

            // Counting columns with duplicate elements
            int duplicateColumnsCount = 0;
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumnsCount++;
                }
            }

            // Output results
            System.out.println(diagonalSum);
            System.out.println(duplicateRowsCount);
            System.out.println(duplicateColumnsCount);
        }

        scanner.close();
    }
}