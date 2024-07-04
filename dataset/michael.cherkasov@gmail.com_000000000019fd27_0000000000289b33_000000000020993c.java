import java.util.*;

public class Solution {
    private final int T ;
    private final int N;
    private final int[][] M;

    public Solution(int T, int N, int[][] M) {
        this.T = T;
        this.N = N;
        this.M = M;
    }

    public void solve() {
        int trace = 0;

        List<Set<Integer>> columnNumbers = new ArrayList<>(N);
        List<Set<Integer>> rowNumbers = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            columnNumbers.add(new HashSet<>(N));
            rowNumbers.add(new HashSet<>(N));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                final int x = M[i][j];

                rowNumbers.get(i).add(x);
                columnNumbers.get(j).add(x);

                if(i == j) trace += x;
            }
        }

        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            if(rowNumbers.get(i).size() != N) r++;
            if(columnNumbers.get(i).size() != N) c++;
        }

        System.out.printf("Case #%s: %s %s %s\n", T, trace, r, c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();

            final int M[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = in.nextInt();
                }
            }

            final Solution vestigium = new Solution(t + 1, N, M);

            vestigium.solve();
        }
    }
}
