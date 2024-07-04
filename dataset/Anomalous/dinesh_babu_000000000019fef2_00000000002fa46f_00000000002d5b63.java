import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int j = 1; j <= T; j++) {
            double ans = 0;
            int row = sc.nextInt();
            int col = sc.nextInt();
            int startRow = sc.nextInt();
            int startCol = sc.nextInt();
            int endRow = sc.nextInt();
            int endCol = sc.nextInt();
            double[][] mat = new double[row + 1][col + 1];

            for (int ind = startRow; ind <= endRow; ind++) {
                for (int tr = startCol; tr <= endCol; tr++) {
                    mat[ind][tr] = -1;
                }
            }

            mat[1][1] = 1;

            for (int i = 1; i <= row; i++) {
                for (int k = 1; k <= col; k++) {
                    if (mat[i][k] != -1) {
                        if (i == 1 && k == 1) continue; // Skip the starting cell

                        double fromTop = (i > 1 && mat[i - 1][k] != -1) ? mat[i - 1][k] / 2 : 0;
                        double fromLeft = (k > 1 && mat[i][k - 1] != -1) ? mat[i][k - 1] / 2 : 0;

                        mat[i][k] = fromTop + fromLeft;
                    }
                }
            }

            ans = mat[row][col];
            System.out.println("Case #" + j + ": " + ans);
        }
    }
}