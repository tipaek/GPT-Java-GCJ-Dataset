import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
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

            String caseResult = calculateResults(matrixString.toString(), N, i + 1);
            if (i < testCases - 1) {
                result.append(caseResult).append("\n");
            } else {
                result.append(caseResult);
            }
        }

        System.out.println(result);
    }

    private static String calculateResults(String matrixString, int N, int caseNumber) {
        int[][] matrix = new int[N][N];
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrixString.charAt(N * i + j) - '0';
            }
        }

        int repeatedRows = 0, repeatedColumns = 0, trace = 0;

        for (int i = 0; i < N; i++) {
            seen.clear();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[i][j])) {
                    repeatedRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            seen.clear();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[j][i])) {
                    repeatedColumns++;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        return "Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns;
    }
}