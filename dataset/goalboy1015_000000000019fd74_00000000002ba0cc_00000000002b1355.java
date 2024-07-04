import java.util.Scanner;

public class Solution {
    static final int[] R_OFFSETS = { -1, 0, 1, 0 };
    static final int[] C_OFFSETS = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] S = new int[R][C];
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    S[r][c] = sc.nextInt();
                }
            }

            System.out.println(String.format("Case #%d: %d", tc, solve(S)));
        }

        sc.close();
    }

    static long solve(int[][] S) {
        int row = S.length;
        int col = S[0].length;

        long result = computeSum(S);
        while (true) {
            boolean changed = false;
            int[][] nextS = new int[row][col];

            for (int r = 0; r < row; ++r) {
                for (int c = 0; c < col; ++c) {
                    if (S[r][c] == -1) {
                        nextS[r][c] = -1;
                    } else {
                        int count = 0;
                        int total = 0;
                        for (int i = 0; i < R_OFFSETS.length; ++i) {
                            int adjR = r + R_OFFSETS[i];
                            int adjC = c + C_OFFSETS[i];
                            while (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col && S[adjR][adjC] == -1) {
                                adjR += R_OFFSETS[i];
                                adjC += C_OFFSETS[i];
                            }

                            if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col) {
                                ++count;
                                total += S[adjR][adjC];
                            }
                        }

                        if (count != 0 && S[r][c] * count < total) {
                            nextS[r][c] = -1;
                            changed = true;
                        } else {
                            nextS[r][c] = S[r][c];
                        }
                    }
                }
            }

            if (!changed) {
                break;
            }

            S = nextS;
            result += computeSum(S);
        }

        return result;
    }

    static long computeSum(int[][] S) {
        int row = S.length;
        int col = S[0].length;

        int result = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (S[r][c] != -1) {
                    result += S[r][c];
                }
            }
        }

        return result;
    }
}