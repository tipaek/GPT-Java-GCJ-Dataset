import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static int targetTrace;

    public static void main(String[] args) {
        InputStream inputSource = System.in;
        processInput(inputSource);
        /* Uncomment the following block to read from a file instead
        try (InputStream inputSource = getInputFromFile()) {
            processInput(inputSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

    private static void processInput(InputStream inputSource) {
        scanner = new Scanner(inputSource);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfTestCases; i++) {
            handleTestCase(i);
        }
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateSolution(int matrixSize, int trace) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = ((i + 1) + j) % matrixSize;
                if (matrix[i][j] == 0) matrix[i][j] = matrixSize;
            }
        }
        if (calculateTrace(matrix) == trace) {
            return matrix;
        }
        return permuteRows(matrix, 0, matrixSize - 1);
    }

    private static int[][] permuteRows(int[][] matrix, int left, int right) {
        if (left == right) {
            return matrix;
        } else {
            for (int i = left; i <= right; i++) {
                swapRows(matrix, left, i);
                int[][] permutedMatrix = permuteRows(matrix, left + 1, right);
                if (permutedMatrix != null && calculateTrace(permutedMatrix) == targetTrace) {
                    return permutedMatrix;
                }
                swapRows(matrix, left, i);
            }
        }
        return null;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void handleTestCase(int testCaseId) {
        String[] input = scanner.nextLine().split(" ");
        int matrixSize = Integer.parseInt(input[0]);
        targetTrace = Integer.parseInt(input[1]);

        int[][] solutionMatrix = generateSolution(matrixSize, targetTrace);
        if (solutionMatrix != null) {
            System.out.printf("Case #%d: POSSIBLE\n", testCaseId);
            displayMatrix(solutionMatrix);
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", testCaseId);
        }
    }

    private static InputStream getInputFromFile() throws IOException {
        File inputFile = new File("src/input5.txt");
        return new FileInputStream(inputFile);
    }
}