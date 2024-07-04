import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String solution[] = new String[T];
        for (int t = 0; t < T; t++) {
            int N;
            int row[][], col[][], arr[][];
            N = sc.nextInt();
            row = new int[N][N + 1];
            col = new int[N][N + 1];
            arr = new int[N][N];
            boolean cur_row = true, cur_col = true;
            int tr = 0, row_count = 0, col_count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    arr[i][j] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                cur_row = true;
                cur_col = true;
                tr += arr[i][i];
                for (int j = 0; j < N; j++) {
                    if (row[i][arr[i][j]] == 1 && cur_row) {
                        row_count++;
                        cur_row = false;
                    } else if (cur_row)
                        row[i][arr[i][j]] = 1;

                    if (col[i][arr[j][i]] == 1 && cur_col) {
                        col_count++;
                        cur_col = false;
                    } else if (cur_col)
                        col[i][arr[j][i]] = 1;
                    if (!cur_row && !cur_col)
                        break;
                }
            }
            solution[t] = "Case #" + (t + 1) + ": " + tr + " " + row_count + " " + col_count + "";
        }
        for (int t = 0; t < T; t++) {

            System.out.println(solution[t]);
        }
    }
}