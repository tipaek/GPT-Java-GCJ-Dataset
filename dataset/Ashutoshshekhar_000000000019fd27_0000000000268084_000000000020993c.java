
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= numberOfTestCases; testCaseNumber++) {
            int matrixSize = scanner.nextInt();

            int[][] matrix = new int[matrixSize][matrixSize];

            for (int rowNum = 0; rowNum < matrixSize; rowNum++) {
                for (int colNum = 0; colNum < matrixSize; colNum++) {
                    matrix[rowNum][colNum] = scanner.nextInt();
                }
            }

            solve(testCaseNumber, matrix);
        }
    }

    private static void solve(int testCaseNumber, int[][] matrix) {
        int trace = computeTrace(matrix);
        int rowCount = computeRowCountContainsRepeatedValue(matrix);
        int colCount = computeColumnCountContainsRepeatedValue(matrix);

        System.out.printf("Case #%d: %d %d %d\n", testCaseNumber, trace, rowCount, colCount);
    }

    private static int computeTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int computeRowCountContainsRepeatedValue(int[][] matrix) {
        int count = 0;

        for (int[] row : matrix) {
            int setSize = Arrays.stream(row).boxed().collect(Collectors.toSet()).size();

            if (setSize != row.length) {
                count++;
            }
        }

        return count;
    }

    private static int computeColumnCountContainsRepeatedValue(int[][] matrix) {
        int count = 0;

        for (int columnIdx = 0; columnIdx < matrix.length; columnIdx++) {
            Set<Integer> set = new HashSet<>();
            for (int[] row : matrix) {
                set.add(row[columnIdx]);
            }

            if (set.size() != matrix.length) {
                count++;
            }
        }

        return count;
    }
}