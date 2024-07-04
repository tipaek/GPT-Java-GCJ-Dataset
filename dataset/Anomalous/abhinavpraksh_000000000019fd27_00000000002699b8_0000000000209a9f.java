package codejam.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2020_Q_1 {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(System.out);
    private static final StringBuilder resultStringBuilder = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            resultStringBuilder.append(String.format("Case #%d: ", t))
                               .append(solve(matrixSize, matrix))
                               .append(NEW_LINE);
        }
        writer.print(resultStringBuilder.toString());
        writer.close();
    }

    private static String solve(int matrixSize, int[][] matrix) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() < matrixSize) {
                rowRepeats++;
            }
            if (colSet.size() < matrixSize) {
                colRepeats++;
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}