import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = reader.nextInt(); // Number of test cases
        reader.nextLine();
        String[] results = new String[t];

        for (int p = 0; p < t; p++) {
            int n = reader.nextInt(); // Size of the matrix
            reader.nextLine();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                String[] line = reader.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Calculate trace and duplicates
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];

                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDupFound = false;
                boolean colDupFound = false;

                for (int j = 0; j < n; j++) {
                    if (!rowDupFound && !rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        rowDupFound = true;
                    }
                    if (!colDupFound && !colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        colDupFound = true;
                    }
                }
            }

            results[p] = "Case #" + (p + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates;
        }

        // Print results
        for (String result : results) {
            System.out.println(result);
        }
    }
}