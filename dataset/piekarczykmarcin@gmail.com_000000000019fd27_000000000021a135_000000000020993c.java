import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int k = 0;

            int[][] rows = new int[N][N];
            int[][] columns = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    rows[i][j] = columns[i][j] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int x = in.nextInt();
                    rows[i][x - 1]++;
                    columns[j][x - 1]++;
                    if (i == j) k += x;
                }
            }

            int r = 0;
            int c = 0;

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (rows[i][j] > 1) {
                        r++;
                        break;
                    }

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (columns[i][j] > 1) {
                        c++;
                        break;
                    }

            System.out.println("Case #" + t+1 + ": " + k + " " + r + " " + c);
        }
    }
}
