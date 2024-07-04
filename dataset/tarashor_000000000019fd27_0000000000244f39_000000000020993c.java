import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] M = readMatrix(in, N);
            System.out.println("Case #" + i + ": " + solve(M, N));
        }
        // write your code here
    }

    private static String solve(int[][] M, int N) {
        int trace = getTrace(M, N);
        int rows = duplicateRows(M, N);
        int cols = duplicateCols(M, N);
        return trace + " " + rows + " " + cols;
    }

    private static int duplicateRows(int[][] M, int N) {
        int dup = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int link = Math.abs(M[i][j]) - 1;
                if (M[i][link] < 0){
                    dup++;
                    break;
                } else {
                    M[i][link] *= -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                M[i][j] = Math.abs(M[i][j]);
            }
        }
        return dup;
    }

    private static int duplicateCols(int[][] M, int N) {
        int dup = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int link = Math.abs(M[j][i]) - 1;
                if (M[link][i] < 0){
                    dup++;
                    break;
                } else {
                    M[link][i] *= -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                M[i][j] = Math.abs(M[i][j]);
            }
        }
        return dup;
    }

    private static int getTrace(int[][] M, int N) {
        int t = 0;
        for (int i = 0; i < N; i++) {
            t += M[i][i];
        }
        return t;
    }

    private static int[][] readMatrix(Scanner in, int N) {
        int[][] M = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                M[i][j] = in.nextInt();
            }
        }
        return M;
    }
}
