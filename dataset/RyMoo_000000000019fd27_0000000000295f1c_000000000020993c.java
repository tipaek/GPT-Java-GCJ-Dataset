import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();
        
        for (int t = 0; t <= T; t++) {
            System.out.println("Case #" + (t+1) + ": " + sol(t, s));
        }
    }
    public static String sol(int test, Scanner s) {
        String str = "";
        int N = s.nextInt();
        int[][] ar = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                ar[r][c] = s.nextInt();
            }
        }
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += ar[i][i];
        }
        str += trace + " ";
        int rows = 0;
        for (int[] row : ar) {
            if (rows[row]) {
                rows++;
            }
        }
        str += rows + " ";
        return str;
    }
    public static boolean rows(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}