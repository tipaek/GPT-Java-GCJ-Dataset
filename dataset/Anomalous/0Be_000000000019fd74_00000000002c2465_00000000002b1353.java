import java.util.*;
import java.io.*;

public class Solution {
    private static final int SIZE = 30;
    private static int[][] matrix = new int[SIZE][SIZE];
    private static int[][] nextI = new int[SIZE][SIZE];
    private static int[][] nextJ = new int[SIZE][SIZE];
    private static boolean[][] visited = new boolean[SIZE][SIZE];
    private static final int[] dx = {0, 0, 1, 1, -1, -1};
    private static final int[] dy = {1, -1, 0, 1, -1, 0};
    private static int N;

    private static void fillMatrix() {
        for (int i = 0; i < SIZE; i++) {
            matrix[i][0] = 1;
            matrix[i][i] = 1;
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int testCases = Integer.parseInt(in.readLine());
        StringBuilder output = new StringBuilder();

        fillMatrix();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(":\n");

            N = Integer.parseInt(in.readLine());
            for (int[] row : nextI) Arrays.fill(row, 0);
            for (int[] row : nextJ) Arrays.fill(row, 0);
            for (boolean[] row : visited) Arrays.fill(row, false);

            visited[0][0] = true;
            solve(0, 0, N - 1, 1);

            output.append("1 1\n");
            int i = nextI[0][0], j = nextJ[0][0];
            while (i != 0 || j != 0) {
                output.append(i + 1).append(" ").append(j + 1).append("\n");
                int tempI = i, tempJ = j;
                i = nextI[tempI][tempJ];
                j = nextJ[tempI][tempJ];
            }
        }

        out.print(output);
        in.close();
        out.close();
    }

    private static boolean isValid(int currentI, int currentJ, int nextI, int nextJ) {
        return nextI >= 0 && nextI < SIZE &&
               nextJ >= 0 && nextJ < SIZE &&
               nextJ <= nextI &&
               !visited[nextI][nextJ];
    }

    private static boolean solve(int i, int j, int remaining, int steps) {
        if (steps > 500 || remaining < 0) {
            return false;
        }
        if (remaining == 0) {
            return true;
        }

        for (int k = 0; k < dx.length; k++) {
            int newI = i + dx[k];
            int newJ = j + dy[k];
            if (isValid(i, j, newI, newJ)) {
                nextI[i][j] = newI;
                nextJ[i][j] = newJ;
                visited[newI][newJ] = true;
                if (solve(newI, newJ, remaining - matrix[newI][newJ], steps + 1)) {
                    return true;
                }
                nextI[i][j] = 0;
                nextJ[i][j] = 0;
                visited[newI][newJ] = false;
            }
        }
        return false;
    }
}