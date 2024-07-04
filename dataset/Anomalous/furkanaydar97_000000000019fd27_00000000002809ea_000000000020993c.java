import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int trace = 0, repeatedElemRow = 0, repeatedElemCol = 0;
            boolean[][] columnHash = new boolean[N + 1][N + 1];
            boolean[] columnCheckFlag = new boolean[N + 1];

            for (int i = 0; i < N; i++) {
                boolean[] rowHash = new boolean[N + 1];
                boolean rowCheckFlag = false;

                for (int j = 0; j < N; j++) {
                    int cur = sc.nextInt();

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
    }
}