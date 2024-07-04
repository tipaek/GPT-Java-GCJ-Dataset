import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            List<Set<Integer>> columnValues = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowValues.add(value);

                    if (columnValues.size() <= j) {
                        columnValues.add(new HashSet<>());
                    }
                    columnValues.get(j).add(value);

                    if (i == j) {
                        diagonalSum += value;
                    }
                }
                if (rowValues.size() < matrixSize) {
                    rowRepeats++;
                }
            }

            for (Set<Integer> colSet : columnValues) {
                if (colSet.size() < matrixSize) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, diagonalSum, rowRepeats, colRepeats);
        }
    }
}