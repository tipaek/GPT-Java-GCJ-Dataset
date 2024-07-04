import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            resultBuilder.append("Case #").append(t).append(": ").append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols).append("\n");
        }

        System.out.print(resultBuilder);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}