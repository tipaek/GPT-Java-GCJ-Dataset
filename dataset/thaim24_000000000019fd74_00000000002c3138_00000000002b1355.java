import java.util.Scanner;

public  class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] S = new int[R][C];
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    S[r][c] = sc.nextInt();
                }
            }

            System.out.println("Case #" + (t+1) + ": " + solve(R, C, S));
        }
    }

    private static long solve(int R, int C, int[][] S) {
        long level = 0;
        int competitors = R*C;
        int L = Math.max(R, C);

        while (competitors > 0) {
            int round = 0;
            int eliminated = 0;
            int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            int[][] nextS = new int[R][C];

            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    int sum = 0;
                    int neighbour = 0;
                    direction: for (int i=0; i<d.length; i++) {
                        for (int l=1; l<L; l++) {
                            int nr = r + l*d[i][0];
                            int nc = c + l*d[i][1];
                            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue direction;

                            if (S[nr][nc] != 0) {
                                sum += S[nr][nc];
                                neighbour++;
                            }
                        }
                    }

                    round += S[r][c];

                    if (S[r][c] != 0 && neighbour > 0 && S[r][c] < (double)sum/neighbour) {
                        nextS[r][c] = 0;
                        eliminated++;
                    } else {
                        nextS[r][c] = S[r][c];
                    }
                }
            }

            S = nextS;
            level += round;
            competitors -= eliminated;

            /*
            System.err.println("competitors:" + competitors + ", level=" + level);
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    System.err.print(S[r][c] + " ");
                }
                System.err.println();
            }
             */

            if (eliminated == 0) {
                // System.err.println("no one eliminated");
                break;
            }
        }

        return level;
    }
}
