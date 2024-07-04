import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Integer[][] matrix = new Integer[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                if (!hasUniqueElements(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!hasUniqueElements(getColumn(matrix, j))) {
                    colRepeats++;
                }
            }

            writer.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        writer.close();
    }

    private static boolean hasUniqueElements(Integer[] array) {
        Set<Integer> uniqueElements = new HashSet<>(Arrays.asList(array));
        return uniqueElements.size() == array.length;
    }

    private static Integer[] getColumn(Integer[][] matrix, int colIndex) {
        Integer[] column = new Integer[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}