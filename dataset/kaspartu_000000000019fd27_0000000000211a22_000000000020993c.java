import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int tc = 0;

        while (++tc <= T) {
            int N = scanner.nextInt();
            int[][] grid = new int[N][N];
            int diag = 0;
            int repeatedRows = 0;

            for (int i = 0; i < N; i++) {
                boolean[] checkRow = new boolean[N + 1];
                boolean repeatedRow = false;
                for (int j = 0; j < N; j++) {
                    int read = scanner.nextInt();
                    grid[i][j] = read;
                    if (i == j) diag += grid[i][j];
                    if (!repeatedRow) {
                        if (checkRow[read] == true) {
                            repeatedRow = true;
                            repeatedRows++;
                        }
                        checkRow[read] = true;
                    }
                }
            }
            int repeatedCols = 0;

            for (int col = 0; col < N; col++) {
                boolean[] checkCol = new boolean[N + 1];
                for (int row = 0; row < N; row++) {
                    if (checkCol[grid[row][col]] == true) {
                        repeatedCols++;
                        break;
                    }
                    checkCol[grid[row][col]] = true;
                }
            }
            System.out.println("Case #" + tc + ": " + diag + " " + repeatedRows + " " + repeatedCols);
        }
    }
}
