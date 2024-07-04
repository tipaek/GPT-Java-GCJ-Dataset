import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class Result {
        int diagonalSum;
        int repeatedRowsCount;
        int repeatedColsCount;

        public Result(int diagonalSum, int repeatedRowsCount, int repeatedColsCount) {
            this.diagonalSum = diagonalSum;
            this.repeatedRowsCount = repeatedRowsCount;
            this.repeatedColsCount = repeatedColsCount;
        }
    }

    public static Result analyzeMatrix(int dimension, int[] matrixValues) {
        int diagonalSum = 0;
        for (int i = 0; i < dimension; ++i) {
            diagonalSum += matrixValues[i * dimension + i];
        }

        int repeatedRowsCount = 0;
        int repeatedColsCount = 0;

        for (int i = 0; i < dimension; ++i) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;

            for (int j = 0; j < dimension; ++j) {
                if (!rowSet.add(matrixValues[i * dimension + j])) {
                    rowHasDuplicates = true;
                }
                if (!colSet.add(matrixValues[j * dimension + i])) {
                    colHasDuplicates = true;
                }
            }

            if (rowHasDuplicates) {
                repeatedRowsCount++;
            }
            if (colHasDuplicates) {
                repeatedColsCount++;
            }
        }

        return new Result(diagonalSum, repeatedRowsCount, repeatedColsCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            int dimension = scanner.nextInt();
            int[] matrixValues = new int[dimension * dimension];

            for (int i = 0; i < matrixValues.length; ++i) {
                matrixValues[i] = scanner.nextInt();
            }

            Result result = analyzeMatrix(dimension, matrixValues);
            System.out.println("Case #" + test + ": " + result.diagonalSum + " " + result.repeatedRowsCount + " " + result.repeatedColsCount);
        }
    }
}