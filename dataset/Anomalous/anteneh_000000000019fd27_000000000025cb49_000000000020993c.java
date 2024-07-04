import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            result.append("Case #").append(testCase).append(":").append(getResult(matrix)).append("\n");
        }

        System.out.print(result.toString());
        scanner.close();
    }

    public static String getResult(int[][] matrix) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowVals = new HashSet<>();
            HashSet<Integer> colVals = new HashSet<>();
            boolean rowDuplicateFound = false, colDuplicateFound = false;

            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowVals.add(matrix[i][j]) && !rowDuplicateFound) {
                    rowDuplicates++;
                    rowDuplicateFound = true;
                }

                if (!colVals.add(matrix[j][i]) && !colDuplicateFound) {
                    colDuplicates++;
                    colDuplicateFound = true;
                }
            }
        }

        return " " + trace + " " + rowDuplicates + " " + colDuplicates;
    }
}