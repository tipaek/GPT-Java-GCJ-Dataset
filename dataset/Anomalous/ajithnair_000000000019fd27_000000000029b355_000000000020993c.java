import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(reader.readLine());
            int expectedSum = size * (size + 1) / 2;
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                String[] inputs = reader.readLine().trim().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(inputs[col]);
                }
            }

            int rowViolations = 0, colViolations = 0;

            // Check rows
            for (int row = 0; row < size; row++) {
                int rowSum = 0;
                for (int col = 0; col < size; col++) {
                    rowSum += matrix[row][col];
                }
                if (rowSum != expectedSum) {
                    rowViolations++;
                }
            }

            // Check columns
            for (int col = 0; col < size; col++) {
                int colSum = 0;
                for (int row = 0; row < size; row++) {
                    colSum += matrix[row][col];
                }
                if (colSum != expectedSum) {
                    colViolations++;
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + size + " " + rowViolations + " " + colViolations;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}