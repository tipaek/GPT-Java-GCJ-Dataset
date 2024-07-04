import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Calculate trace and check for repeated elements in rows and columns
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasRepeat = false;
                boolean colHasRepeat = false;

                for (int j = 0; j < n; j++) {
                    // Check for row repeats
                    if (!rowHasRepeat && !rowSet.add(matrix[i][j])) {
                        rowHasRepeat = true;
                    }
                    // Check for column repeats
                    if (!colHasRepeat && !colSet.add(matrix[j][i])) {
                        colHasRepeat = true;
                    }
                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }

                if (rowHasRepeat) {
                    rowRepeats++;
                }
                if (colHasRepeat) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}