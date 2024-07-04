import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int cs = 0; cs < cases; ++cs) {
            int N = in.nextInt();
            int K = in.nextInt();
            int [][] matrix = generateMatrix(N, K);
            System.out.println("Case #" + (cs + 1) + ": " + (matrix != null ? "POSSIBLE" : "IMPOSSIBLE"));
            if (matrix != null) {
                for (int row = 0; row < N; ++row) {
                    for (int col = 0; col < N; ++col) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static int[][] generateMatrix(int N, int K) {
        if (K % N != 0) {
            return null;
        }
        int D = K / N;
        
        if(D > N) {
            return null;
        }

        int[][] ans = new int[N][N];
        for (int row = 0; row < N; ++row) {
            ans[row] = new int[N];
            for (int col = 0; col < N; ++col) {
                int index = (D - 1) + row - col;
                if (index >= 0) {
                    index = index % N;
                } else {
                    index = N + index;
                }
                ans[row][col] = index + 1;
            }
        }

        return ans;
    }
}
