import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            fillMatrix(scanner, matrix, size);
            int[] result = calculateResults(matrix, size);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int[] calculateResults(int[][] matrix, int size) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < size; i++) {
            if (hasRepeats(matrix[i])) {
                rowRepeats++;
            }
        }

        // Check for repeated elements in columns
        for (int j = 0; j < size; j++) {
            if (hasRepeats(getColumn(matrix, j))) {
                colRepeats++;
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }

    private static boolean hasRepeats(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int size = matrix.length;
        int[] column = new int[size];
        for (int i = 0; i < size; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}