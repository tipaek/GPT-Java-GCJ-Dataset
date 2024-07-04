import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final int N;
    final int[][] M;

    public Solution(Scanner scanner) {
        N = scanner.nextInt();
        M = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                M[i][j] = scanner.nextInt();
            }
        }
    }

    private String solve() {
        return "" + trace() + " " + rows() + " " + columns();
    }

    private int trace() {
        return IntStream.range(0, N)
                .map(i -> M[i][i])
                .sum();
    }

    private long rows() {
        return IntStream.range(0, N)
                .filter(i -> checkRow(i))
                .count();
    }

    private boolean checkRow(int r) {
        Set<Integer> integers = IntStream.range(0, N)
                .map(i -> M[r][i])
                .boxed()
                .collect(Collectors.toSet());

        return integers.size() != N;
    }

    private long columns() {
        return IntStream.range(0, N)
                .filter(i -> checkColumn(i))
                .count();
    }

    private boolean checkColumn(int c) {
        Set<Integer> integers = IntStream.range(0, N)
                .map(i -> M[i][c])
                .boxed()
                .collect(Collectors.toSet());

        return integers.size() != N;
    }

}
