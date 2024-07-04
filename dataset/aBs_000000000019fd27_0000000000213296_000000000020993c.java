import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] data = new int[N][N];

            int trace = 0;
            // collect data
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    data[j][k] = scanner.nextInt();
                    if (k == j)
                        trace += data[j][k];
                }
            }

            int rows = 0;
            int cols = 0;
            for (int r = 0; r < N; r++) {
                BitSet bitSetCol = new BitSet(N+1);
                boolean b = false;
                for (int c = 0; c < N; c++) {
                    if (!b && bitSetCol.get(data[r][c]))
                        b = true;
                    bitSetCol.set(data[r][c], true);
                }
                if (b)
                    rows++;
            }
            for (int c = 0; c < N; c++) {
                BitSet bitSetCol = new BitSet(N+1);
                boolean b = false;
                for (int r = 0; r < N; r++) {
                    if (!b && bitSetCol.get(data[r][c]))
                        b = true;
                    bitSetCol.set(data[r][c], true);
                }
                if (b)
                    cols++;
            }
            System.out.printf("Case #%d: %d %d %d\n", i, trace, rows, cols);
        }
        scanner.close();
    }
}