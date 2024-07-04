
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            System.out.println("Case #" + t + ": " + solve(arr, r, c));
        }
    }

    public static int solve(int[][] arr, int R, int C) {
        int[][][] nbs = new int[R][C][4];
        int sum = 0;
        int cnt = R * C;
        int[] rr = new int[cnt];
        int[] rc = new int[cnt];
        int rcnt = 0;
        int[] dr = new int[cnt];
        int[] dc = new int[cnt];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rr[rcnt] = i;
                rc[rcnt++] = j;
//                sum += arr[i][j];
                nbs[i][j][0] = i > 0 ? i - 1 : -1;
                nbs[i][j][1] = j < C - 1 ? j + 1 : -1;
                nbs[i][j][2] = i < R - 1 ? i + 1 : -1;
                nbs[i][j][3] = j > 0 ? j - 1 : -1;
            }
        }

        while (true) {
            int rcnt2 = 0;
            int dcnt = 0;
            for (int i = 0; i < rcnt; i++) {
                int r = rr[i];
                int c = rc[i];
                int val = arr[r][c];

                int tcnt = 0;
                int tsum = 0;
                if (nbs[r][c][0] != -1) {
                    tsum += arr[nbs[r][c][0]][c];
                    tcnt++;
                }
                if (nbs[r][c][1] != -1) {
                    tsum += arr[r][nbs[r][c][1]];
                    tcnt++;
                }
                if (nbs[r][c][2] != -1) {
                    tsum += arr[nbs[r][c][2]][c];
                    tcnt++;
                }
                if (nbs[r][c][3] != -1) {
                    tsum += arr[r][nbs[r][c][3]];
                    tcnt++;
                }
                if (val * tcnt >= tsum) {
                    rr[rcnt2] = r;
                    rc[rcnt2++] = c;
                } else {
                    dr[dcnt] = r;
                    dc[dcnt++] = c;
                }
                sum += val;
            }
            if (rcnt == rcnt2) {
                break;
            }
            for (int i = 0; i < dcnt; i++) {
                int r = dr[i];
                int c = dc[i];
                if (nbs[r][c][0] != -1) {
                    nbs[nbs[r][c][0]][c][2] = nbs[r][c][2];
                }
                if (nbs[r][c][1] != -1) {
                    nbs[r][nbs[r][c][1]][3] = nbs[r][c][3];
                }
                if (nbs[r][c][2] != -1) {
                    nbs[nbs[r][c][2]][c][0] = nbs[r][c][0];
                }
                if (nbs[r][c][3] != -1) {
                    nbs[r][nbs[r][c][3]][1] = nbs[r][c][1];
                }
            }
            rcnt = rcnt2;
        }
        return sum;
    }
}