import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] line = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            String result = processMatrix(matrix);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }

    public static String processMatrix(int[][] matrix) {
        int size = matrix.length;
        int trace = calculateTrace(matrix, size);
        int badRows = countBadRows(matrix, size);
        int badColumns = countBadColumns(matrix, size);

        return trace + " " + badRows + " " + badColumns;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countBadRows(int[][] matrix, int size) {
        int badRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seen.add(matrix[row][col])) {
                    badRows++;
                    break;
                }
            }
        }
        return badRows;
    }

    private static int countBadColumns(int[][] matrix, int size) {
        int badColumns = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    badColumns++;
                    break;
                }
            }
        }
        return badColumns;
    }
}