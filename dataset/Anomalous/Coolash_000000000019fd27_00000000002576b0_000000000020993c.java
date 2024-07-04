import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {
            
            int testCases = Integer.parseInt(reader.readLine().trim());

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int n = Integer.parseInt(reader.readLine().trim());
                int[][] matrix = new int[n][n];
                int trace = 0, rowCount = 0, columnCount = 0;

                for (int i = 0; i < n; i++) {
                    String[] row = reader.readLine().trim().split("\\s+");
                    boolean[] rowCheck = new boolean[n + 1];
                    for (int j = 0; j < n; j++) {
                        int value = Integer.parseInt(row[j]);
                        matrix[i][j] = value;
                        if (i == j) {
                            trace += value;
                        }
                        if (rowCheck[value]) {
                            rowCount++;
                            break;
                        }
                        rowCheck[value] = true;
                    }
                }

                for (int j = 0; j < n; j++) {
                    boolean[] columnCheck = new boolean[n + 1];
                    for (int i = 0; i < n; i++) {
                        int value = matrix[i][j];
                        if (columnCheck[value]) {
                            columnCount++;
                            break;
                        }
                        columnCheck[value] = true;
                    }
                }

                writer.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + columnCount);
            }
        }
    }
}