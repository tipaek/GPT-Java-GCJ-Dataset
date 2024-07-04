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
            if(K % N != 0) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }
            sb.append("POSSIBLE\n");
            int rowStart = K / N;
            int[][] arr = new int[N][N];
            for(int row = 0; row < N; ++row) {
                int colStart = rowStart;
                for(int col = 0; col < N; ++col) {
                    arr[row][col] = colStart;
                    colStart += 1;
                    if(colStart > N) colStart %= N;

                }
                rowStart -= 1;
                if(rowStart == 0) rowStart = N;
            }
            for(int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());

    }
}
