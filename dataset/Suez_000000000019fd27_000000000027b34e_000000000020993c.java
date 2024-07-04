import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int[][] ar = new int[N][N];

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    ar[i][j] = in.nextInt();
                }
            }

            int trace = 0;
            int col = 0;
            int row = 0;
            for (int i=0; i<N; i++) {
                trace += ar[i][i];
            }

            for (int i=0; i<N; i++) {
                Set<Integer> repeated = new HashSet<>();
                for (int j=0; j<N; j++) {
                    repeated.add(ar[i][j]);
                }
                row += repeated.size() == N ? 0 : 1;
            }

            for (int j=0; j<N; j++) {
                Set<Integer> repeated = new HashSet<>();
                for (int i=0; i<N; i++) {
                    repeated.add(ar[i][j]);
                }
                col += repeated.size() == N ? 0 : 1;
            }

            System.out.println(String.format("Case #%s: %s %s %s", t, trace, row, col));

        }
    }
}
