import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row and column duplicates
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }

                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }

                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] == sortedArray[i - 1]) {
                return true;
            }
        }
        return false;
    }
}