import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, reader);
        }
    }

    private static void processTestCase(int caseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int trace = Integer.parseInt(tokenizer.nextToken());
        
        List<List<Integer>> partitions = generatePartitions(trace, n);
        int[][] matrix = initializeMatrix(n);
        
        for (List<Integer> diagonal : partitions) {
            if (attemptDiagonalPlacement(n, matrix, diagonal)) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix(matrix);
                return;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
    }

    private static List<List<Integer>> generatePartitions(int sum, int n) {
        List<List<Integer>> partitions = new ArrayList<>();
        generatePartitionsRecursive(sum, n, n, new ArrayList<>(), partitions);
        return partitions;
    }

    private static void generatePartitionsRecursive(int sum, int maxN, int toSelect, List<Integer> currentList, List<List<Integer>> partitions) {
        if (maxN == 1) {
            if (sum == toSelect) {
                List<Integer> temp = new ArrayList<>(currentList);
                for (int i = 1; i <= toSelect; i++) {
                    temp.add(1);
                }
                partitions.add(temp);
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
            currentList.remove(Integer.valueOf(maxN));
        }
    }

    private static int[][] initializeMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            int value = r + 1;
            for (int c = 0; c < n; c++) {
                matrix[r][c] = value;
                value = (value % n) + 1;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static boolean attemptDiagonalPlacement(int n, int[][] matrix, List<Integer> diagonal) {
        return placeDiagonalRecursive(n, matrix, diagonal, 0);
    }

    private static boolean placeDiagonalRecursive(int n, int[][] matrix, List<Integer> diagonal, int index) {
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
                if (placeDiagonalRecursive(n, matrix, diagonal, index + 1)) {
                    return true;
                }
                swapCols(matrix, index, targetCol);
                swapRows(matrix, index, targetRow);
            }
        }

        return false;
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
            for (int[] row : matrix) {
                int temp = row[col1];
                row[col1] = row[col2];
                row[col2] = temp;
            }
        }
    }
}