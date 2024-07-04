import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.hasNextInt() ? scanner.nextInt() : 0;

        for (int t = 1; t <= T; t++) {
            int N = scanner.hasNextInt() ? scanner.nextInt() : 0;
            int trace = 0;
            int row_repeats = 0;
            int col_repeats = 0;
            int[][] arr = new int[N][N];
            int[][] row_copies = new int[N][N];
            int[][] col_copies = new int[N][N];
            int[] rows_with_repeats = new int[N];
            int[] cols_with_repeats = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int e = scanner.hasNextInt() ? scanner.nextInt() : 0;
                    arr[i][j] = e;
                    if (i == j) trace += e;

                    row_copies[i][e - 1] += 1;
                    col_copies[j][e - 1] += 1;

                    if (row_copies[i][e - 1] > 1) {
                        rows_with_repeats[i] = 1;
                    }

                    if (col_copies[j][e - 1] > 1) {
                        cols_with_repeats[j] = 1;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                row_repeats += rows_with_repeats[i];
                col_repeats += cols_with_repeats[i];
            }
            System.out.println(String.format("Case #%s: %s %s %s", t, trace, row_repeats, col_repeats));
        }


    }
}
