import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < dimension; i++) {
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
                if (hasColumnDuplicates(matrix, i)) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, colDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        Set<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            if (!seen.add(row[colIndex])) {
                return true;
            }
        }
        return false;
    }
}