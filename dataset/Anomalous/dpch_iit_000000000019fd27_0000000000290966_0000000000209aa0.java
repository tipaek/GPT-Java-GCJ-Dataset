import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine().trim());
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            handleTestCase(testCase, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int matrixSize = Integer.parseInt(tokenizer.nextToken());
        int targetTrace = Integer.parseInt(tokenizer.nextToken());

        List<List<Integer>> partitions = generatePartitions(targetTrace, matrixSize);
        int[][] matrix = initializeMatrix(matrixSize);

        for (List<Integer> diagonal : partitions) {
            if (attemptDiagonal(matrixSize, matrix, diagonal)) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix(matrix);
                return;
            }
        }

        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
    }

    private static List<List<Integer>> generatePartitions(int sum, int size) {
        List<List<Integer>> partitions = new ArrayList<>();
        generatePartitionsRecursive(sum, size, size, new ArrayList<>(), partitions);
        return partitions;
    }

    private static void generatePartitionsRecursive(int sum, int maxElement, int elementsLeft, List<Integer> currentPartition, List<List<Integer>> partitions) {
        if (maxElement == 1) {
            if (sum == elementsLeft) {
                List<Integer> partition = new ArrayList<>(currentPartition);
                for (int i = 0; i < elementsLeft; i++) {
                    partition.add(1);
                }
                partitions.add(partition);
            }
            return;
        }
        generatePartitionsRecursive(sum, maxElement - 1, elementsLeft, currentPartition, partitions);
        int addedElements = 0;
        for (int i = 1; i <= elementsLeft && i * maxElement <= sum; i++) {
            currentPartition.add(maxElement);
            addedElements++;
            generatePartitionsRecursive(sum - i * maxElement, maxElement - 1, elementsLeft - i, currentPartition, partitions);
        }
        for (int i = 0; i < addedElements; i++) {
            currentPartition.remove(currentPartition.size() - 1);
        }
    }

    private static int[][] initializeMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            int value = row + 1;
            for (int col = 0; col < size; col++) {
                matrix[row][col] = value;
                value = (value % size) + 1;
            }
        }
        return matrix;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        if (row1 != row2) {
            int[] temp = matrix[row1];
            matrix[row1] = matrix[row2];
            matrix[row2] = temp;
        }
    }

    private static void swapCols(int[][] matrix, int col1, int col2) {
        if (col1 != col2) {
            for (int row = 0; row < matrix.length; row++) {
                int temp = matrix[row][col1];
                matrix[row][col1] = matrix[row][col2];
                matrix[row][col2] = temp;
            }
        }
    }

    private static boolean attemptDiagonal(int size, int[][] matrix, List<Integer> diagonal) {
        return attemptDiagonalRecursive(size, matrix, diagonal, 0);
    }

    private static boolean attemptDiagonalRecursive(int size, int[][] matrix, List<Integer> diagonal, int index) {
        if (index == size - 1) {
            return matrix[index][index] == diagonal.get(index);
        }

        for (int targetRow = index; targetRow < size; targetRow++) {
            int targetCol = -1;
            for (int col = index; col < size; col++) {
                if (matrix[targetRow][col] == diagonal.get(index)) {
                    targetCol = col;
                    break;
                }
            }
            if (targetCol != -1) {
                swapRows(matrix, index, targetRow);
                swapCols(matrix, index, targetCol);
                if (attemptDiagonalRecursive(size, matrix, diagonal, index + 1)) {
                    return true;
                }
                swapCols(matrix, index, targetCol);
                swapRows(matrix, index, targetRow);
            }
        }

        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}