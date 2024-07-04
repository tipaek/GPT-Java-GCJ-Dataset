import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int matSize = sc.nextInt();
            int[][] matrix = new int[matSize][matSize];

            for (int row = 0; row < matSize; row++) {
                for (int col = 0; col < matSize; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int duplicateRows = countDuplicateRows(matrix, matSize);
            int duplicateCols = countDuplicateCols(matrix, matSize);
            int diagonalSum = calculateDiagonalSum(matrix, matSize);

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != size) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateColCount = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != size) {
                duplicateColCount++;
            }
        }

        return duplicateColCount;
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }
}