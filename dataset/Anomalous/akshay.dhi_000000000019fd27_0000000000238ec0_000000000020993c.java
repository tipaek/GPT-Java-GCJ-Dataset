import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int testCases = Integer.parseInt(tokenizer.nextToken());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            int rowRepeated = 0;
            int colRepeated = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                boolean[] rowCheck = new boolean[101];
                boolean[] colCheck = new boolean[101];

                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeated++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }

                for (int j = 0; j < matrixSize; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colRepeated++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowRepeated, colRepeated);
            caseNumber++;
        }
    }
}