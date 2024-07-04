import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int N = Integer.parseInt(reader.readLine());
            StringBuilder matrixBuilder = new StringBuilder();

            for (int j = 0; j < N; j++) {
                matrixBuilder.append(reader.readLine()).append(" ");
            }

            String[] values = matrixBuilder.toString().trim().split(" ");
            StringBuilder matrixString = new StringBuilder();

            for (String value : values) {
                matrixString.append(value);
            }

            if (i < testCases - 1) {
                result.append(calculateRowsAndColumns(matrixString.toString(), N, i + 1)).append("\n");
            } else {
                result.append(calculateRowsAndColumns(matrixString.toString(), N, i + 1));
            }
        }

        System.out.println(result);
    }

    public static String calculateRowsAndColumns(String matrixString, int N, int caseNumber) {
        Set<Integer> seen = new HashSet<>();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrixString.charAt(N * i + j) - '0';
            }
        }

        int numRepeatedRows = 0;
        int numRepeatedCols = 0;
        int trace = 0;

        // Check for repeated rows
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (seen.contains(matrix[i][j])) {
                    numRepeatedRows++;
                    break;
                } else {
                    seen.add(matrix[i][j]);
                }
            }
            seen.clear();
        }

        // Check for repeated columns
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (seen.contains(matrix[j][i])) {
                    numRepeatedCols++;
                    break;
                } else {
                    seen.add(matrix[j][i]);
                }
            }
            seen.clear();
        }

        // Calculate trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        return String.format("Case #%d: %d %d %d", caseNumber, trace, numRepeatedRows, numRepeatedCols);
    }
}