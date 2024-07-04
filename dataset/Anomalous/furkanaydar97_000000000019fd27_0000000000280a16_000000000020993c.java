import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int trace = 0, repeatedElemRow = 0, repeatedElemCol = 0;

            boolean[][] columnHash = new boolean[N][N + 1];
            boolean[] columnCheckFlag = new boolean[N];

            for (int i = 0; i < N; i++) {
                boolean[] rowHash = new boolean[N + 1];
                boolean rowCheckFlag = false;

                for (int j = 0; j < N; j++) {
                    int cur = scanner.nextInt();

                    if (i == j) {
                        trace += cur;
                    }

                    if (!rowCheckFlag && rowHash[cur]) {
                        repeatedElemRow++;
                        rowCheckFlag = true;
                    }
                    rowHash[cur] = true;

                    if (!columnCheckFlag[j] && columnHash[j][cur]) {
                        repeatedElemCol++;
                        columnCheckFlag[j] = true;
                    }
                    columnHash[j][cur] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, repeatedElemRow, repeatedElemCol);
        }

        scanner.close();
    }
}