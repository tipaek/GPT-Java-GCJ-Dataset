import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < dimension; i++) {
                trace += matrix[i][i];
                if (hasDuplicate(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < dimension; j++) {
                if (hasDuplicate(getColumn(matrix, j))) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}