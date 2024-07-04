import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeJam1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine().trim());
            
            for (int t = 1; t <= testCases; t++) {
                int n = Integer.parseInt(br.readLine().trim());
                int[][] matrix = new int[n][n];
                int trace = 0;
                int duplicateRows = 0;
                int duplicateCols = 0;

                // Read matrix and calculate trace
                for (int i = 0; i < n; i++) {
                    String[] row = br.readLine().trim().split("\\s+");
                    boolean[] rowCheck = new boolean[n];
                    boolean rowHasDuplicates = false;

                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(row[j]);
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                        if (!rowHasDuplicates && rowCheck[matrix[i][j] - 1]) {
                            duplicateRows++;
                            rowHasDuplicates = true;
                        }
                        rowCheck[matrix[i][j] - 1] = true;
                    }
                }

                // Check for duplicate columns
                for (int j = 0; j < n; j++) {
                    boolean[] colCheck = new boolean[n];
                    boolean colHasDuplicates = false;

                    for (int i = 0; i < n; i++) {
                        if (!colHasDuplicates && colCheck[matrix[i][j] - 1]) {
                            duplicateCols++;
                            colHasDuplicates = true;
                        }
                        colCheck[matrix[i][j] - 1] = true;
                    }
                }

                System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}