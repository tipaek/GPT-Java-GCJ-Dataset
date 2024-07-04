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
            System.out.println("Case #" + (t+1) + ": " + trace(ar) + " " + rows(ar) + " " + cols(ar));
        }
    }
    public static int trace(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i][i];
        }
        return sum;
    }
    public static int rows(int[][] ar) {
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
        return count;
    }
    public static int cols(int[][] ar) {
        int count = 0;
        f: for (int c = 0; c < ar.length; c++) {
            for (int r = 0; r < ar.length; r++) {
                for (int j = r+1; j < ar.length; j++) {
                    if (ar[r][c] == ar[j][c]) {
                        count++;
                        continue f;
                    }
                }
            }
        }
        return count;
    }
}