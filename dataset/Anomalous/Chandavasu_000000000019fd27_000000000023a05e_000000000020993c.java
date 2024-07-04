import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 0; test < numberOfTests; test++) {
            int matrixSize = scanner.nextInt();
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            List<Set<Integer>> columnValues = new ArrayList<>();
            for (int i = 0; i < matrixSize; i++) {
                columnValues.add(new HashSet<>());
            }

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    rowValues.add(value);
                    columnValues.get(col).add(value);

                    if (row == col) {
                        diagonalSum += value;
                    }
                }
                if (rowValues.size() < matrixSize) {
                    duplicateRows++;
                }
            }

            for (Set<Integer> colSet : columnValues) {
                if (colSet.size() < matrixSize) {
                    duplicateCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", test + 1, diagonalSum, duplicateRows, duplicateCols);
        }
    }
}