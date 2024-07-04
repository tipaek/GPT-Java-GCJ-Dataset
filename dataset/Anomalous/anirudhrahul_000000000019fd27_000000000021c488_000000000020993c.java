import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            writer.write("Case #" + caseNum + ":");

            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            long trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    int value = matrix[i][j];
                    if (seen[value]) {
                        duplicateRows++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            int duplicateCols = 0;
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    int value = matrix[j][i];
                    if (seen[value]) {
                        duplicateCols++;
                        break;
                    }
                    seen[value] = true;
                }
            }

            writer.write(" " + trace);
            writer.write(" " + duplicateRows);
            writer.write(" " + duplicateCols);
            writer.write("\n");
        }
        writer.close();
    }
}