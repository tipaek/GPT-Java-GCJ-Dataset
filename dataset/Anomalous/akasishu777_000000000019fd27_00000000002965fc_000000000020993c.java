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
                matrixBuilder.append(reader.readLine());
            }

            String matrixString = matrixBuilder.toString().replaceAll(" ", "");
            String caseResult = calculateRowsAndColumns(matrixString, N, i + 1);
            result.append(caseResult);

            if (i < testCases - 1) {
                result.append("\n");
            }
        }

        System.out.println(result);
    }

    public static String calculateRowsAndColumns(String matrixString, int N, int caseNumber) {
        int[][] matrix = new int[N][N];
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrixString.charAt(N * i + j) - '0';
            }
        }

        int numRowRepeats = 0, numColRepeats = 0, trace = 0;

        for (int i = 0; i < N; i++) {
            seen.clear();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[i][j])) {
                    numRowRepeats++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            seen.clear();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[j][i])) {
                    numColRepeats++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        return "Case #" + caseNumber + ": " + trace + " " + numRowRepeats + " " + numColRepeats;
    }
}