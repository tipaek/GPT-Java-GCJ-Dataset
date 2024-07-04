import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(read.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < testcases; i++) {
            int N = Integer.parseInt(read.readLine());
            StringBuilder matrixBuilder = new StringBuilder();

            for (int j = 0; j < N; j++) {
                matrixBuilder.append(read.readLine()).append(" ");
            }

            String[] vals = matrixBuilder.toString().trim().split(" ");
            StringBuilder m = new StringBuilder();
            for (String s : vals) {
                m.append(s);
            }

            if (i < testcases - 1) {
                answer.append(calcRowsAndColumns(m.toString(), N, i + 1)).append("\n");
            } else {
                answer.append(calcRowsAndColumns(m.toString(), N, i + 1));
            }
        }

        System.out.println(answer);
    }

    public static String calcRowsAndColumns(String matrixStr, int N, int caseNumber) {
        HashSet<Integer> seen = new HashSet<>();
        int[][] matrix = new int[N][N];
        int trace = 0, numRowRepeats = 0, numColRepeats = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = matrixStr.charAt(N * i + j) - '0';
            }
        }

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