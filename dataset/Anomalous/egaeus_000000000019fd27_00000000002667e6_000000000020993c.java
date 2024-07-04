import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < N; i++) {
                boolean[] rowCheck = new boolean[N];
                boolean[] colCheck = new boolean[N];
                boolean rowHasDuplicates = false;
                boolean colHasDuplicates = false;

                for (int j = 0; j < N; j++) {
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowHasDuplicates = true;
                    } else {
                        rowCheck[matrix[i][j] - 1] = true;
                    }

                    if (colCheck[matrix[j][i] - 1]) {
                        colHasDuplicates = true;
                    } else {
                        colCheck[matrix[j][i] - 1] = true;
                    }

                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }

                if (rowHasDuplicates) {
                    duplicateRows++;
                }

                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }

            result.append("Case #").append(t).append(": ")
                  .append(diagonalSum).append(" ")
                  .append(duplicateRows).append(" ")
                  .append(duplicateCols).append("\n");
        }

        System.out.print(result);
    }
}