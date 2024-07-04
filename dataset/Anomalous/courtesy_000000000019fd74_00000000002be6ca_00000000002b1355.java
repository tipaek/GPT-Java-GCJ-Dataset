import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int[][] A = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }
            long ans = 0;
            while (true) {
                boolean eliminated = false;
                long sum = 0;
                boolean[][] toEliminate = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (A[i][j] == 0) continue;

                        sum += A[i][j];
                        int count = 0;
                        int total = 0;
                        for (int ii = i - 1; ii >= 0; ii--) {
                            if (A[ii][j] > 0) {
                                count++;
                                total += A[ii][j];
                                break;
                            }
                        }
                        for (int ii = i + 1; ii < R; ii++) {
                            if (A[ii][j] > 0) {
                                count++;
                                total += A[ii][j];
                                break;
                            }
                        }
                        for (int jj = j - 1; jj >= 0; jj--) {
                            if (A[i][jj] > 0) {
                                count++;
                                total += A[i][jj];
                                break;
                            }
                        }
                        for (int jj = j + 1; jj < C; jj++) {
                            if (A[i][jj] > 0) {
                                count++;
                                total += A[i][jj];
                                break;
                            }
                        }
                        if (count > 0 && total > count * A[i][j]) {
                            eliminated = true;
                            toEliminate[i][j] = true;
                        }
                    }
                }
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (toEliminate[i][j]) {
                            A[i][j] = 0;
                        }
                    }
                }
                ans += sum;
                if (!eliminated) break;
            }
            writer.println("Case #" + cs + ": " + ans);
        }
        writer.flush();
        writer.close();
    }
}