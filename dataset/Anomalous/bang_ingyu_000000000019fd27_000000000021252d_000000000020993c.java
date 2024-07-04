import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultBuilder;
        StringTokenizer tokenizer;

        int testCases = parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            resultBuilder = new StringBuilder();
            resultBuilder.append("Case #").append(t).append(": ");

            int matrixSize = parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    int value = parseInt(tokenizer.nextToken());
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    int value = matrix[i][j];
                    if (rowCheck[value - 1]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[value - 1] = true;
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    int value = matrix[i][j];
                    if (colCheck[value - 1]) {
                        duplicateCols++;
                        break;
                    }
                    colCheck[value - 1] = true;
                }
            }

            resultBuilder.append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols).append("\n");
            writer.write(resultBuilder.toString());
        }

        writer.flush();
        writer.close();
    }
}