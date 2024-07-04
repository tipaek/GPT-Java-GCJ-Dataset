import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().trim().split("\\s+");
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicateInRow = true;
                    }
                }

                if (hasDuplicateInRow) {
                    repeatedRows++;
                }

                trace += matrix[i][i];
            }

            // Checking for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInCol = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicateInCol = true;
                    }
                }

                if (hasDuplicateInCol) {
                    repeatedCols++;
                }
            }

            System.out.println(trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}