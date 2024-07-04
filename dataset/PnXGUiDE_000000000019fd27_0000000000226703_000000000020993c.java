import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int c = 1; c <= T; c++) {
            int N = in.nextInt();
            int sum = (N + 1) * N / 2;
            int[][] data = new int[N][N];

            int rowCount = 0;
            int colCount = 0;

            // O(n^2)
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    data[i][j] = in.nextInt();
                }
            }
            
            // O(n^2)
            for(int i = 0; i < N; i++) {
                boolean[] isDup = new boolean[N];
                for(int j = 0; j < N; j++) {
                    if(isDup[data[i][j] - 1]) {
                        rowCount++;
                        break;
                    }
                    isDup[data[i][j] - 1] = true;
                }
            }

            // O(n^2)
            for(int i = 0; i < N; i++) {
                boolean[] isDup = new boolean[N];
                for(int j = 0; j < N; j++) {
                    if(isDup[data[j][i] - 1]) {
                        colCount++;
                        break;
                    }
                    isDup[data[j][i] - 1] = true;
                }
            }

            int trace = 0;

            for(int j = 0; j < N; j++) {
                trace += data[j][j];
            }

            System.out.printf("Case #%d: %d %d %d\n", c, trace, rowCount, colCount);
        }
    }
}
