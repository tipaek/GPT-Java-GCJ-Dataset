import java.util.HashSet;
import java.util.Scanner;

public class Trace {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int sum = 0;
            int row = 0;
            int col = 0;

            // Read the matrix
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            // Calculate the trace and check for duplicate entries in rows and columns
            for (int j = 0; j < N; j++) {
                sum += map[j][j];
                boolean sameRow = false;
                boolean sameCol = false;
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();

                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(map[j][k])) {
                        sameRow = true;
                    }
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