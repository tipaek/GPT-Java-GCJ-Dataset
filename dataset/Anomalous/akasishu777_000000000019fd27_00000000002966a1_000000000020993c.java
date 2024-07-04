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

            String matrixString = matrixBuilder.toString().trim().replace(" ", "");
            if (i < testCases - 1) {
                result.append(calcRowsAndColumns(matrixString, N, i + 1)).append("\n");
            } else {
                result.append(calcRowsAndColumns(matrixString, N, i + 1));
            }
        }

        System.out.println(result);
    }

    public static String calcRowsAndColumns(String matrixString, int N, int caseNumber) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrixString.charAt(N * i + j) - '0';
            }
        }

        int trace = 0;
        int numRowRepeats = 0;
        int numColRepeats = 0;

        // Check for repeated numbers in rows
        for (int i = 0; i < N; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[i][j])) {
                    numRowRepeats++;
                    break;
                }
            }
        }

        // Check for repeated numbers in columns
        for (int j = 0; j < N; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (!seen.add(matrix[i][j])) {
                    numColRepeats++;
                    break;
                }
            }
        }

        // Calculate trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        return "Case #" + caseNumber + ": " + trace + " " + numRowRepeats + " " + numColRepeats;
    }
}