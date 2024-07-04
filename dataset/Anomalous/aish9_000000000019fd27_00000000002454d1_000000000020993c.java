import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int z = 0; z < T; z++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row duplicates
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (z + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}