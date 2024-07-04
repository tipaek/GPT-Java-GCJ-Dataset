import java.util.Arrays;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int testCases = kb.nextInt();
        for (int i = 0; i < testCases; i++) {
            int N = kb.nextInt();
            int trace = 0;
            int[][] grid = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    grid[j][k] = kb.nextInt();
                    if(j == k)
                        trace += grid[j][k];
                }
            }
            int rowsWithASameNumber = 0, columnsWithASameNumber = 0;
            for (int j = 0; j < N; j++) {
                int[] row = new int[N];
                for (int k = 0; k < N; k++)
                    row[k] = grid[j][k];
                Arrays.sort(row);
                for (int k = 0; k < N - 1; k++) {
                    if(row[k] == row[k + 1]) {
                        rowsWithASameNumber++;
                        break;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                int[] row = new int[N];
                for (int k = 0; k < N; k++)
                    row[k] = grid[k][j];
                Arrays.sort(row);
                for (int k = 0; k < N - 1; k++) {
                    if(row[k] == row[k + 1]) {
                        columnsWithASameNumber++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowsWithASameNumber + " " + columnsWithASameNumber);
        }
        kb.close();
    }
}