import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void trace(int x, int N, int[][] matrix) {
        int k = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            k += matrix[i][i];
        }

        for (int i = 0; i < N; i++) {
            int[] rIndex = new int[101];
            for (int j = 0; j < N; j++) {
                ++rIndex[matrix[i][j]];
                if (rIndex[matrix[i][j]] > 1) {
                    ++r;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int[] cIndex = new int[101];
            for (int j = 0; j < N; j++) {
                ++cIndex[matrix[j][i]];
                if (cIndex[matrix[j][i]] > 1) {
                    ++c;
                    break;
                }
            }
        }

        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();

        for (int tIttr = 1; tIttr <= T; tIttr++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {
                    int M = scanner.nextInt();
                    matrix[i][j] = M;
                }
            }

            trace(tIttr, N, matrix);
        }
    }
}
