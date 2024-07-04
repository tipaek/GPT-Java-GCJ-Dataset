import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    M[r][c] = sc.nextInt();
                }
            }

            System.out.println(String.format("Case #%d: %s", tc, solve(M)));
        }

        sc.close();
    }

    static String solve(int[][] M) {
        int N = M.length;

        return String.format("%d %d %d", IntStream.range(0, N).map(i -> M[i][i]).sum(),
                (int) IntStream.range(0, N).filter(r -> Arrays.stream(M[r]).distinct().count() != N).count(),
                (int) IntStream.range(0, N).filter(c -> IntStream.range(0, N).map(r -> M[r][c]).distinct().count() != N)
                        .count());
    }
}