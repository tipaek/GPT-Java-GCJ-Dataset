import java.util.Scanner;

// Vestigium
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            int N = in.nextInt();
            int[][] A = new int[N][N];
            for (int r=0; r<N; r++) {
                for (int c=0; c<N; c++) {
                    A[r][c] = in.nextInt();
                }
            }
            int trace = 0;
            for (int n=0; n<N; n++) {
                trace += A[n][n];
            }
            int brokenRows = 0;
            for (int r=0; r<N; r++) {
                boolean[] used = new boolean[N];
                for (int c=0; c<N; c++) {
                    if (used[A[r][c]-1]) {
                        brokenRows++;
                        break;
                    }
                    used[A[r][c]-1] = true;
                }
            }
            int brokenColumns = 0;
            for (int c=0; c<N; c++) {
                boolean[] used = new boolean[N];
                for (int r=0; r<N; r++) {
                    if (used[A[r][c]-1]) {
                        brokenColumns++;
                        break;
                    }
                    used[A[r][c]-1] = true;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t, trace, brokenRows, brokenColumns);
        }
    }

}
