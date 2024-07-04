import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseSetSize = Integer.parseInt(scanner.nextLine().trim());
        for (int testCaseNumber = 1; testCaseNumber <= testCaseSetSize; testCaseNumber++) {
            int matrixSize = Integer.parseInt(scanner.nextLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int rowNumber = 0; rowNumber < matrixSize; rowNumber++) {
                matrix[rowNumber] = Arrays.stream(scanner.nextLine().trim().split(" "))
                                          .mapToInt(Integer::parseInt)
                                          .toArray();
                trace += matrix[rowNumber][rowNumber];
            }

            System.out.print("Case #" + testCaseNumber + ": " + trace);
            showRepeatedNumbers(matrixSize, matrix);
            showRepeatedNumbers(matrixSize, transpose(matrix));
            System.out.println();
        }
    }

    private static void showRepeatedNumbers(int matrixSize, int[][] matrix) {
        int rowsWithRepeatedNumbers = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueNumbers = Arrays.stream(row).boxed().collect(Collectors.toSet());
            if (uniqueNumbers.size() != matrixSize) {
                rowsWithRepeatedNumbers++;
            }
        }
        System.out.print(" " + rowsWithRepeatedNumbers);
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