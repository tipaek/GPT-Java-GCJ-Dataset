import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        processTestCases();
    }

    private static void processTestCases() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfTestCases = Integer.parseInt(tokenizer.nextToken());
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            handleTestCase(testCase, reader);
        }
    }

    private static void handleTestCase(int testCaseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int matrixSize = Integer.parseInt(tokenizer.nextToken());
        int targetTrace = Integer.parseInt(tokenizer.nextToken());

        List<ArrayList<Integer>> partitions = generatePartitions(targetTrace, matrixSize);

        for (ArrayList<Integer> diagonal : partitions) {
            int[][] matrix = new int[matrixSize][matrixSize];
            boolean[][] rowFlags = new boolean[matrixSize][matrixSize + 1];
            boolean[][] colFlags = new boolean[matrixSize][matrixSize + 1];

            for (int i = 0; i < matrixSize; i++) {
                matrix[i][i] = diagonal.get(i);
                rowFlags[i][diagonal.get(i)] = true;
                colFlags[i][diagonal.get(i)] = true;
            }

            if (fillMatrix(matrix, 0, 0, rowFlags, colFlags)) {
                System.out.printf("Case #%d: POSSIBLE%n", testCaseNumber);
                for (int[] row : matrix) {
                    for (int cell : row) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }

        System.out.printf("Case #%d: IMPOSSIBLE%n", testCaseNumber);
    }

    private static List<ArrayList<Integer>> generatePartitions(int sum, int n) {
        List<ArrayList<Integer>> partitions = new ArrayList<>();
        generatePartitionsRecursive(sum, n, n, new ArrayList<>(), partitions);
        return partitions;
    }

    private static void generatePartitionsRecursive(int sum, int maxN, int toSelect, ArrayList<Integer> current, List<ArrayList<Integer>> partitions) {
        if (maxN == 1) {
            if (sum == toSelect) {
                ArrayList<Integer> partition = new ArrayList<>(current);
                for (int i = 1; i <= toSelect; i++) {
                    partition.add(1);
                }
                partitions.add(partition);
            }
            return;
        }

        generatePartitionsRecursive(sum, maxN - 1, toSelect, current, partitions);

        for (int select = 1; select <= toSelect && select * maxN <= sum; select++) {
            current.add(maxN);
            generatePartitionsRecursive(sum - select * maxN, maxN - 1, toSelect - select, current, partitions);
            current.remove(current.size() - 1);
        }
    }

    private static boolean fillMatrix(int[][] matrix, int row, int col, boolean[][] rowFlags, boolean[][] colFlags) {
        int n = matrix.length;
        if (row == n - 1 && col == n - 1) {
            return true;
        }

        if (row == col) {
            return fillMatrix(matrix, row, col + 1, rowFlags, colFlags);
        }

        for (int value = 1; value <= n; value++) {
            if (!rowFlags[row][value] && !colFlags[col][value]) {
                rowFlags[row][value] = true;
                colFlags[col][value] = true;
                matrix[row][col] = value;

                boolean result = (col < n - 1)
                        ? fillMatrix(matrix, row, col + 1, rowFlags, colFlags)
                        : fillMatrix(matrix, row + 1, 0, rowFlags, colFlags);

                if (result) {
                    return true;
                }

                rowFlags[row][value] = false;
                colFlags[col][value] = false;
            }
        }

        return false;
    }
}