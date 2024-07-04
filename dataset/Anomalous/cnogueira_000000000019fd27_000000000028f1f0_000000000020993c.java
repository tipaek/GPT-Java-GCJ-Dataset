import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class Result {
        int dupRows, dupCols, trace;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = readMatrix(n, scanner);
            Result result = analyzeMatrix(matrix, n);

            System.out.printf("Case #%d: %d %d %d%n", testCase, result.trace, result.dupRows, result.dupCols);
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static Result analyzeMatrix(int[][] matrix, int size) {
        Result result = new Result();

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            result.trace += matrix[i][i];
            if (rowSet.size() < size) result.dupRows++;
            if (colSet.size() < size) result.dupCols++;
        }

        return result;
    }
}