import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static int[][] sol;

    private static boolean indicium(int N, int trace) {
        if (N == 0 || trace % N != 0 || trace > N * N) {
            return false;
        }

        sol = new int[N][N];
        int traceNum = trace / N;
        int start = 1;

        for (int i = 0; i < N; i++) {
            if (start == traceNum) start++;
            sol[i][i] = traceNum;

            int x = 0, y = i + 1;
            while (x < N && y < N) {
                sol[x++][y++] = start;
            }

            x = N - i - 1;
            y = 0;
            while (x < N && y < N && x > 0) {
                sol[x++][y++] = start;
            }
            start++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = in.nextInt();
        for (int i = 1; i <= testSize; ++i) {
            int N = in.nextInt();
            int trace = in.nextInt();
            boolean output = indicium(N, trace);
            StringBuilder builder = new StringBuilder();
            builder.append("Case #").append(i).append(": ").append(output ? POSSIBLE : IMPOSSIBLE);
            System.out.println(builder.toString().trim());
            if (output) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        System.out.print(sol[x][y]);
                        if (y < N - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}