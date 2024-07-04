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

            for (int j = 0; j < size; j++) {
                String[] inputs = reader.readLine().trim().split(" ");
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(inputs[k]);
                }
            }

            int rowErrors = 0, colErrors = 0;

            for (int j = 0; j < size; j++) {
                int rowSum = 0, colSum = 0;
                for (int k = 0; k < size; k++) {
                    rowSum += matrix[j][k];
                    colSum += matrix[k][j];
                }
                if (rowSum != expectedSum) rowErrors++;
                if (colSum != expectedSum) colErrors++;
            }

            results[i] = "Case #" + (i + 1) + ": " + size + " " + rowErrors + " " + colErrors;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}