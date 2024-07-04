import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int test = 1; test <= t; test++) {
            int k = 0, r = 0, c = 0;
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            // Construct the matrix
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Check rows, columns, and diagonal
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowRepeated = false;
                boolean colRepeated = false;

                for (int j = 0; j < n; j++) {
                    // Check row
                    if (!rowRepeated && !rowSet.add(matrix[i][j])) {
                        rowRepeated = true;
                    }

                    // Check column
                    if (!colRepeated && !colSet.add(matrix[j][i])) {
                        colRepeated = true;
                    }

                    // Check diagonal
                    if (i == j) {
                        k += matrix[i][j];
                    }
                }

                if (rowRepeated) r++;
                if (colRepeated) c++;
            }

            System.out.println("Case #" + test + ": " + k + " " + r + " " + c);
        }
    }
}