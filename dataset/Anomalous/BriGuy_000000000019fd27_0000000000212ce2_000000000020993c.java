import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(tokenizer.nextToken());
                    matrix[i][j] = value;

                    if (rowCheck[value]) {
                        rowHasDuplicate = true;
                    }
                    rowCheck[value] = true;

                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];

                    if (colCheck[value]) {
                        colHasDuplicate = true;
                    }
                    colCheck[value] = true;
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}