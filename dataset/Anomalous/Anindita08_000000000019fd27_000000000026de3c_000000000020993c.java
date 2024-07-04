import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());

        for (int t = 1; t <= T; t++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int[][] matrix = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < N; i++) {
                boolean rowHasDuplicates = false, colHasDuplicates = false;
                HashMap<Integer, Boolean> rowMap = new HashMap<>();
                HashMap<Integer, Boolean> colMap = new HashMap<>();

                for (int j = 0; j < N; j++) {
                    if (rowMap.putIfAbsent(matrix[i][j], true) != null) {
                        rowHasDuplicates = true;
                    }
                    if (colMap.putIfAbsent(matrix[j][i], true) != null) {
                        colHasDuplicates = true;
                    }
                }

                if (rowHasDuplicates) {
                    rowDuplicates++;
                }
                if (colHasDuplicates) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}