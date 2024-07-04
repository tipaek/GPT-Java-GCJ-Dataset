import java.io.*;
import java.util.*;

public class CodeForces {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = scanner.nextInt();

        for (int e = 0; e < t; e++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row repetitions
            for (int i = 0; i < n; i++) {
                if (!hasUniqueElements(matrix[i])) {
                    rowRepeats++;
                }
            }

            // Check for column repetitions
            for (int j = 0; j < n; j++) {
                if (!hasUniqueElements(getColumn(matrix, j))) {
                    colRepeats++;
                }
            }

            out.printf("Case #%d: %d %d %d%n", e + 1, trace, rowRepeats, colRepeats);
        }

        out.close();
    }

    private static boolean hasUniqueElements(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static int[] getColumn(int[][] matrix, int index) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }
}