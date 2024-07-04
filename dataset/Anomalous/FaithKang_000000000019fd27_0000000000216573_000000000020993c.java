import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int sum = 0, row = 0, col = 0;

            // Read the matrix
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            // Compute the sum of the diagonal and check for duplicate rows and columns
            for (int j = 0; j < N; j++) {
                sum += map[j][j];
                boolean sameRow = false, sameCol = false;
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int k = 0; k < N; k++) {
                    // Check for duplicates in the current row
                    if (!rowSet.add(map[j][k])) {
                        sameRow = true;
                    }
                    // Check for duplicates in the current column
                    if (!colSet.add(map[k][j])) {
                        sameCol = true;
                    }
                }

                if (sameRow) row++;
                if (sameCol) col++;
            }

            System.out.println("#" + (i + 1) + " " + sum + " " + row + " " + col);
        }
    }
}