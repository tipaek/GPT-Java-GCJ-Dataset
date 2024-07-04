import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();

            if (N <= 2) {
                System.out.println("Case #" + t +": IMPOSSIBLE");
            } else {
                int index = 0;
                int[][] matrix = new int[N][N];
                while (index < N) {
                    int trace = 0;
                    for (int r = 0; r < N; r++) {
                        for (int c=0; c < N; c++) {
                            int value = (c+1) + index;
                            matrix[r][c] = value <= N ? value : N - value;
                            if (r == c) {
                                trace += value;
                            }
                        }
                    }
                    if (trace == K) {
                        System.out.println("Case #" + t +": POSSIBLE");
                        break;
                    }
                    index++;
                }
            }
        }
    }
}
