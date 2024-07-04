import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseSetSize = Integer.parseInt(scanner.nextLine().trim());
        for (int testCaseNumber = 1; testCaseNumber <= testCaseSetSize; testCaseNumber++) {
            int matrixSize = Integer.parseInt(scanner.nextLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int rowNumber = 0; rowNumber < matrixSize; rowNumber++) {
                String[] strings = scanner.nextLine().trim().split(" ");
                for (int colNumber = 0; colNumber < matrixSize; colNumber++) {
                    matrix[rowNumber][colNumber] = Integer.parseInt(strings[colNumber]);
                }
                trace += matrix[rowNumber][rowNumber];
            }

            System.out.print("Case #" + testCaseNumber + ": " + trace);

            int rowWithRepeatedNumbers = countRowsWithRepeatedNumbers(matrix);
            System.out.print(" " + rowWithRepeatedNumbers);

            int[][] transposedMatrix = transpose(matrix);
            int colWithRepeatedNumbers = countRowsWithRepeatedNumbers(transposedMatrix);
            System.out.print(" " + colWithRepeatedNumbers);

            System.out.println();
        }
    }

    private static int countRowsWithRepeatedNumbers(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueNumbers = Arrays.stream(row).boxed().collect(Collectors.toSet());
            if (uniqueNumbers.size() < row.length) {
                count++;
            }
        }
        return count;
    }

    private static int[][] transpose(int[][] matrix) {
        int size = matrix.length;
        int[][] transposedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}