package codejam4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Codejam4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcaseCount; i++) {
            int matrixSize = Integer.parseInt(br.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String[] elements = br.readLine().split(" ");
                for (int k = 0; k < elements.length; k++) {
                    matrix[j][k] = Integer.parseInt(elements[k]);
                }
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];
                if (hasDuplicates(matrix[j])) {
                    rowRepeats++;
                }
                if (hasColumnDuplicates(matrix, j)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicates(int[] row) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for (int value : row) {
            if (seen.containsKey(value)) {
                return true;
            }
            seen.put(value, true);
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int colIndex) {
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for (int[] row : matrix) {
            if (seen.containsKey(row[colIndex])) {
                return true;
            }
            seen.put(row[colIndex], true);
        }
        return false;
    }
}