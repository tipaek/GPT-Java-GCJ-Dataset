import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(read.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < testcases; i++) {
            int N = Integer.parseInt(read.readLine());
            StringBuilder matrixBuilder = new StringBuilder();

            for (int j = 0; j < N; j++) {
                matrixBuilder.append(read.readLine().replace(" ", ""));
            }

            String matrix = matrixBuilder.toString();
            answer.append(calcRowsAndColumns(matrix, N, i + 1));
            if (i < testcases - 1) {
                answer.append("\n");
            }
        }

        System.out.println(answer);
    }

    public static String calcRowsAndColumns(String matrixStr, int N, int caseNumber) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrixStr.charAt(N * i + j) - '0';
            }
        }

        int numRowr = 0, numColr = 0, trace = 0;

        // Check rows for duplicates
        for (int i = 0; i < N; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[i][j])) {
                    numRowr++;
                    break;
                }
            }
        }

        // Check columns for duplicates
        for (int i = 0; i < N; i++) {
            HashSet<Integer> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!seen.add(matrix[j][i])) {
                    numColr++;
                    break;
                }
            }
        }

        // Calculate trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        return "Case #" + caseNumber + ": " + trace + " " + numRowr + " " + numColr;
    }
}