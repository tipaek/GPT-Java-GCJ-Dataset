import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            
            for (int row = 0; row < dimension; row++) {
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] result = analyzeMatrix(matrix, dimension);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, result[0], result[1], result[2]);
        }
    }

    public static int[] analyzeMatrix(int[][] matrix, int dimension) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < dimension; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
        }

        for (int i = 0; i < dimension; i++) {
            if (hasColumnDuplicates(matrix, i)) {
                colDuplicates++;
            }
        }

        return new int[]{trace, rowDuplicates, colDuplicates};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int col) {
        boolean[] seen = new boolean[matrix.length + 1];
        for (int[] row : matrix) {
            int value = row[col];
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}