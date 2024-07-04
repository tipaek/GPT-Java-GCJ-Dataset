import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static String printMatrix(int[][] matrix, int N) {
        String ret = "";
        for (int r = 0; r < N; r++) {
            String row = "";
            for (int c = 0; c < N; c++) {
                row += matrix[r][c] + " ";
            }
            if (r < N - 1)
                ret += row.trim() + "\n";
            else
                ret += row.trim();
        }
        return ret;
    }

    public static void main(String[] args) {
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int K = in.nextInt();

            String res = "Case #" + t + ": ";
            if (K % N != 0) {
                res += "IMPOSSIBLE";
            } else {
                int[][] matrix = new int[N][N];
                int seed = K / N;
                for (int r = 0; r < N; r++) {
                    int start = seed + r;
                    for (int c = 0; c < N; c++) {
                        if (start > N)
                            start = 1;
                        matrix[r][c] = start;
                        start++;
                    }
                }
                res += "POSSIBLE\n" + printMatrix(matrix, N);
            }
            System.out.println(res);
        }
    }
}
