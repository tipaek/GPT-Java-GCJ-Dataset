import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < N; ++i) {
                trace += matrix[i][i];
            }

            int repeatedRows = 0;
            for (int row = 0; row < N; ++row) {
                Set<Integer> unique = new HashSet<>();
                for (int col = 0; col < N; ++col) {
                    unique.add(matrix[row][col]);
                }
                if (unique.size() < N) {
                    repeatedRows++;
                }
            }
            int repeatedCols = 0;
            for (int col = 0; col < N; ++col) {
                Set<Integer> unique = new HashSet<>();
                for (int row = 0; row < N; ++row) {
                    unique.add(matrix[row][col]);
                }
                if (unique.size() < N) {
                    repeatedCols++;
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }

        in.close();
    }
}
