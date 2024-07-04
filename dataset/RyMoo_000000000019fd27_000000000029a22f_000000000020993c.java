import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();
        
        for (int t = 0; t <= T; t++) {
            int N = s.nextInt();
            int[][] ar = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    ar[r][c] = s.nextInt();
                }
            }
            solve(t, ar);
        }
    }
    public static void solve(int test, int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i][i];
        }
        System.out.print("Case #" + test +": " + sum);
        int count = 0;
        f: for (int[] row : ar) {
            for (int c = 0; c < ar.length; c++) {
                for (int j = c+1; j < ar.length; j++) {
                    if (row[c] == row[j]) {
                        count++;
                        continue f;
                    }
                }
            }
        }
        System.out.print(" " + count);
        int cnt = 0;
        f1: for (int c = 0; c < ar.length; c++) {
            for (int r = 0; r < ar.length; r++) {
                for (int j = r+1; j < ar.length; j++) {
                    if (ar[r][c] == ar[j][c]) {
                        cnt++;
                        continue f1;
                    }
                }
            }
        }
        System.out.print(" " + cnt);
        System.out.println();
    }
}