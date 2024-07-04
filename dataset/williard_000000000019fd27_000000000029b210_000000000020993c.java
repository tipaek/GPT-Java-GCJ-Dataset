import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int casenum = 1; casenum <= T; casenum++) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            int row_digit[][] = new int[N][N];
            int col_digit[][] = new int[N][N];
            boolean rep_row[] = new boolean[N];
            boolean rep_col[] = new boolean[N];
            int check, K, R, C;
            K = R = C = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                    check = ++row_digit[i][M[i][j]-1];
                    if (check > 1)
                        rep_row[i] = true;
                    check = ++col_digit[j][M[i][j]-1];
                    if (check > 1)
                        rep_col[j] = true;
                }
            for (int i = 0; i < N; i++)
                K += M[i][i];
            for (int i = 0; i < N; i++) {
                if (rep_row[i])
                    R++;
                if (rep_col[i])
                    C++;
            }
            System.out.printf("Case #%d: %d %d %d\n", casenum, K, R, C);
        }
    }
}