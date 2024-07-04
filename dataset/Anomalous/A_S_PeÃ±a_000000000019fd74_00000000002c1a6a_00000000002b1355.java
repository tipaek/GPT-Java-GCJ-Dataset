import java.util.Scanner;

public class Solution {
    
    static final Scanner SCNR = new Scanner(System.in);
    
    static int method1(int[][] arr, int R, int C) {
        int totalSum = 0;
        boolean eliminated;
        int[][] rowSum = new int[R][C];
        int[][] rowCount = new int[R][C];
        
        do {
            eliminated = false;

            // Reset totalSum and auxiliary arrays
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    totalSum += arr[r][c];
                    rowSum[r][c] = rowCount[r][c] = 0;
                }
            }

            // Calculate row and column sums and counts
            for (int r = 0; r < R; ++r) {
                int comp = 0;
                for (int c = 0; c < C; ++c) {
                    if (arr[r][c] > 0) {
                        rowSum[r][c] += comp;
                        rowCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
                comp = 0;
                for (int c = C - 1; c >= 0; --c) {
                    if (arr[r][c] > 0) {
                        rowSum[r][c] += comp;
                        rowCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
            }

            for (int c = 0; c < C; ++c) {
                int comp = 0;
                for (int r = 0; r < R; ++r) {
                    if (arr[r][c] > 0) {
                        rowSum[r][c] += comp;
                        rowCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
                comp = 0;
                for (int r = R - 1; r >= 0; --r) {
                    if (arr[r][c] > 0) {
                        rowSum[r][c] += comp;
                        rowCount[r][c] += Math.min(comp, 1);
                        comp = arr[r][c];
                    }
                }
            }

            // Eliminate elements based on average comparison
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (rowCount[r][c] > 0 && ((double) rowSum[r][c] / rowCount[r][c]) > arr[r][c]) {
                        arr[r][c] = 0;
                        eliminated = true;
                    }
                }
            }
        } while (eliminated);
        
        return totalSum;
    }
    
    public static void main(String[] args) {
        int T = SCNR.nextInt();

        for (int i = 1; i <= T; ++i) {
            int R = SCNR.nextInt();
            int C = SCNR.nextInt();
            int[][] arr = new int[R][C];

            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    arr[r][c] = SCNR.nextInt();
                }
            }

            int result = method1(arr, R, C);
            System.out.printf("Case #%d: %d\n", i, result);
        }

        SCNR.close();
    }
}