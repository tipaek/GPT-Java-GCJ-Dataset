import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int cnt = 0;
        while (T > 0) {
            --T;
            cnt++;
            System.out.println("Case #" + cnt + ":");
            int N = scanner.nextInt();
            int[][] triangle = new int[N + 1][N + 1];
            triangle[0][0] = 1;
            for (int i = 1; i <= N; ++i) {
                for (int j = 0; j <= i; ++j) {
                    if (j == 0)
                        triangle[i][j] = 1;
                    else if (j == i)
                        triangle[i][j] = 1;
                    else
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }

            int x_pos = 0;
            int y_pos = -1;
            while (N > 0 && N >= triangle[x_pos + 1][y_pos + 1]) {
                x_pos++;
                y_pos++;
                System.out.println((x_pos + 1) + " " + (y_pos + 1));
                N -= (triangle[x_pos][y_pos]);
            }
            if (N > 0)
                x_pos--;
            while (N > 0) {
                x_pos++;
                y_pos++;
                System.out.println((x_pos + 1) + " " + (y_pos + 1));
                N -= (triangle[x_pos][y_pos]);
            }
        }
    }
}
