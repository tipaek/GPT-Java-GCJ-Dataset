import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int limit = in.nextInt();

        for (int l = 0; l < limit; l++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Check rows for duplicates
            int rowDuplicates = 0;
            for (int r = 0; r < size; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check columns for duplicates
            int colDuplicates = 0;
            for (int c = 0; c < size; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", l + 1, trace, rowDuplicates, colDuplicates);
        }

        in.close();
    }
}