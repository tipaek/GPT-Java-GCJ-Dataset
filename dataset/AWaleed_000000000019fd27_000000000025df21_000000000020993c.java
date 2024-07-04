import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            int k = 0, r = 0, c;
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {

                for (int col = 0; col < N; col++) {
                    int temp = sc.nextInt();
                    matrix[row][col] = temp;
                    if (col == row) k += temp;
                }

                if (!goodRow(matrix[row])) ++r;

            }
            c = checkCols(matrix);
            System.out.println("Case #" + t + ":" + " " + k + " " + r  + " " + c);
        }//END
    }

    private static boolean goodRow(int[] row) {
        int n = row.length;
        boolean[] bool = new boolean[n];
        for (int i = 0; i < n; i++) {
            bool[i] = false;
        }
        for (int value : row) {
            bool[value - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!bool[i]) return false;
        }
        return true;
    }

    private static int checkCols(int[][] matrix) {
        int N = matrix.length;
        int c = 0;
        for (int col = 0; col < N; col++) {

            boolean[] bool = new boolean[N];
            for (int i = 0; i < N; ++i) {
                bool[i] = false;
            }

            for (int[] ints : matrix) {
                bool[ints[col] - 1] = true;
            }
            for (int i = 0; i < N; i++) {
                if (!bool[i]) {
                    ++c;
                    break;
                }
            }
        }//END matrix
        return c;
    }
}



