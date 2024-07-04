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
        int testCaseCount = Integer.parseInt(reader.readLine().trim());
        for (int i = 1; i <= testCaseCount; i++) {
            handleTestCase(i, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int trace = Integer.parseInt(tokenizer.nextToken());

        List<ArrayList<Integer>> partitions = generatePartitions(trace, n);
        int[][] matrix = initializeMatrix(n);

        for (ArrayList<Integer> diagonal : partitions) {
            if (tryDiagonal(n, matrix, diagonal)) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix(matrix);
                return;
            }
        }
        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
    }

    private static List<ArrayList<Integer>> generatePartitions(int sum, int n) {
        List<ArrayList<Integer>> partitions = new ArrayList<>();
        generatePartitionsRecursive(sum, n, n, new ArrayList<>(), partitions);
        return partitions;
    }

    private static void generatePartitionsRecursive(int sum, int maxN, int toSelect, ArrayList<Integer> currentList, List<ArrayList<Integer>> partitions) {
        if (maxN == 1) {
            if (sum == toSelect) {
                ArrayList<Integer> tempList = new ArrayList<>(currentList);
                for (int i = 1; i <= toSelect; i++) {
                    tempList.add(1);
                }
                partitions.add(tempList);
            }
            return;
        }

        generatePartitionsRecursive(sum, maxN - 1, toSelect, currentList, partitions);

        int added = 0;
        for (int select = 1; select <= toSelect && select * maxN <= sum; select++) {
            currentList.add(maxN);
            added++;
            generatePartitionsRecursive(sum - select * maxN, maxN - 1, toSelect - select, currentList, partitions);
        }

        for (int i = 0; i < added; i++) {
            currentList.remove((Integer) maxN);
        }
    }

    private static int[][] initializeMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int value = row + 1;
            for (int col = 0; col < n; col++) {
                matrix[row][col] = value;
                value = (value % n) + 1;
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

    private static boolean tryDiagonal(int n, int[][] matrix, ArrayList<Integer> diagonal) {
        return tryDiagonalRecursive(n, matrix, diagonal, 0);
    }

    private static boolean tryDiagonalRecursive(int n, int[][] matrix, ArrayList<Integer> diagonal, int index) {
        if (index == n - 1) {
            return matrix[index][index] == diagonal.get(index);
        }

        for (int targetRow = index; targetRow < n; targetRow++) {
            int targetCol = -1;
            for (int col = index; col < n; col++) {
                if (matrix[targetRow][col] == diagonal.get(index)) {
                    targetCol = col;
                    break;
                }
            }
            if (targetCol != -1) {
                swapRows(matrix, index, targetRow);
                swapCols(matrix, index, targetCol);
                if (tryDiagonalRecursive(n, matrix, diagonal, index + 1)) {
                    return true;
                }
                swapRows(matrix, index, targetRow);
                swapCols(matrix, index, targetCol);
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