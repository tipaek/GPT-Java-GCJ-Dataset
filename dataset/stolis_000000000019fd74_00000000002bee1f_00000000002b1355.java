import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] S = new int[R][C];
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    S[r][c] = in.nextInt();
                }
            }
            long answer = 0;
            boolean eliminated = true;
            while (eliminated) {
                eliminated = false;
                int[][] newS = new int[R][C];
                for (int r=0; r<R; r++) {
                    for (int c=0; c<C; c++) {
                        int d = S[r][c];
                        newS[r][c] = d;
                        answer += d;
                        int sum = 0;
                        int count = 0;
                        if (d > 0) {
                            int rr = r-1;
                            while (rr >= 0 && S[rr][c] == 0) rr--;
                            if (rr >= 0) {
                                sum += S[rr][c];
                                count++;
                            }
                            rr = r + 1;
                            while (rr < R && S[rr][c] == 0) rr++;
                            if (rr < R) {
                                sum += S[rr][c];
                                count++;
                            }
                            int cc = c-1;
                            while (cc >= 0 && S[r][cc] == 0) cc--;
                            if (cc >= 0) {
                                sum += S[r][cc];
                                count++;
                            }
                            cc = c + 1;
                            while (cc < C && S[r][cc] == 0) cc++;
                            if (cc < C) {
                                sum += S[r][cc];
                                count++;
                            }
                            if (sum > d*count) {
                                eliminated = true;
                                newS[r][c] = 0;
                            }
                        }
                    }
                }
                S = newS;
            }
            System.out.printf("Case #%d: %d\n", t, answer);
        }
    }

}
