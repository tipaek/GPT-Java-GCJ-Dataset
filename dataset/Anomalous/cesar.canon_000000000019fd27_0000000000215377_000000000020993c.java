import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < cases; i++) {
            int N = Integer.parseInt(reader.readLine());
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean hasDuplicateRow = false;
                int[] rowCount = new int[N + 1];

                for (int col = 0; col < N; col++) {
                    int num = Integer.parseInt(tokenizer.nextToken());
                    matrix[row][col] = num;
                    rowCount[num]++;

                    if (rowCount[num] > 1) {
                        hasDuplicateRow = true;
                    }

                    if (row == col) {
                        trace += num;
                    }
                }

                if (hasDuplicateRow) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < N; col++) {
                boolean hasDuplicateCol = false;
                int[] colCount = new int[N + 1];

                for (int row = 0; row < N; row++) {
                    int num = matrix[row][col];
                    colCount[num]++;

                    if (colCount[num] > 1) {
                        hasDuplicateCol = true;
                    }
                }

                if (hasDuplicateCol) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}