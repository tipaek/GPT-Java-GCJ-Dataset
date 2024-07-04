import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int expectedSum = size * (size + 1) / 2;
            int[][] matrix = new int[size][size];
            int trace = 0;

            for (int i = 0; i < size; i++) {
                String[] row = reader.readLine().trim().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int invalidRows = 0, invalidCols = 0;

            // Check rows
            for (int i = 0; i < size; i++) {
                int rowSum = 0;
                for (int j = 0; j < size; j++) {
                    rowSum += matrix[i][j];
                }
                if (rowSum != expectedSum) {
                    invalidRows++;
                }
            }

            // Check columns
            for (int j = 0; j < size; j++) {
                int colSum = 0;
                for (int i = 0; i < size; i++) {
                    colSum += matrix[i][j];
                }
                if (colSum != expectedSum) {
                    invalidCols++;
                }
            }

            results[t] = "Case #" + (t + 1) + ": " + size + " " + invalidRows + " " + invalidCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}