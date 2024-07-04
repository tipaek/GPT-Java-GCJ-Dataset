import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int K = in.nextInt();
            sb.append("Case #" + t +": ");
            if(N % 2 != K % 2) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }
            sb.append("POSSIBLE\n");
            int rowStart = K / N;
            if(N == 4 && K == 10) {
                int[][] tmp = new int[4][4];
                tmp[0] = new int[] {1, 3, 4, 2};
                tmp[1] = new int[] {4, 2, 1, 3};
                tmp[2] = new int[] {2, 4, 3, 1};
                tmp[3] = new int[] {3, 1, 2, 4};
                for(int i = 0; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        sb.append(tmp[i][j] + " ");
                    }
                    sb.append("\n");
                }
            } else {
                int[][] arr = new int[N][N];
                for (int row = 0; row < N; ++row) {
                    int colStart = rowStart;
                    for (int col = 0; col < N; ++col) {
                        arr[row][col] = colStart;
                        colStart += 1;
                        if (colStart > N) colStart %= N;

                    }
                    rowStart -= 1;
                    if (rowStart == 0) rowStart = N;
                }
                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        sb.append(arr[i][j] + " ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());

    }
}
