import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                if (!isRowUnique(matrix, i)) rowDuplicates++;
                if (!isColumnUnique(matrix, i)) colDuplicates++;
            }

            writer.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        writer.close();
    }

    private static boolean isRowUnique(int[][] matrix, int row) {
        Set<Integer> seen = new HashSet<>();
        for (int value : matrix[row]) {
            if (!seen.add(value)) return false;
        }
        return true;
    }

    private static boolean isColumnUnique(int[][] matrix, int col) {
        Set<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            if (!seen.add(row[col])) return false;
        }
        return true;
    }
}