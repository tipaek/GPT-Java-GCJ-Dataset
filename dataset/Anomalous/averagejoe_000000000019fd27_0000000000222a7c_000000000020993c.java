import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int nCases = Integer.parseInt(br.readLine());

            for (int i = 0; i < nCases; i++) {
                int N = Integer.parseInt(br.readLine());
                int[][] matrix = new int[N][N];
                int trace = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                // Read the matrix and calculate the trace
                for (int r = 0; r < N; r++) {
                    String[] row = br.readLine().split(" ");
                    Set<Integer> rowSet = new HashSet<>();
                    boolean rowHasDuplicate = false;

                    for (int c = 0; c < N; c++) {
                        int num = Integer.parseInt(row[c]);
                        matrix[r][c] = num;
                        if (r == c) trace += num;
                        if (!rowSet.add(num) && !rowHasDuplicate) {
                            rowHasDuplicate = true;
                            rowDuplicates++;
                        }
                    }
                }

                // Check for column duplicates
                for (int c = 0; c < N; c++) {
                    Set<Integer> colSet = new HashSet<>();
                    boolean colHasDuplicate = false;

                    for (int r = 0; r < N; r++) {
                        int num = matrix[r][c];
                        if (!colSet.add(num) && !colHasDuplicate) {
                            colHasDuplicate = true;
                            colDuplicates++;
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowDuplicates, colDuplicates);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}