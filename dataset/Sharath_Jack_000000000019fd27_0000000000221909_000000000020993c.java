import java.util.Scanner;

public class Solution {
    public static String solve(Scanner s) {
        int n = s.nextInt();
        int a[][] = new int[n][n];
        int ansR = 0;
        int ansC = 0;
        int xor = 1;
        for (int i = 2; i <= n; i++) xor ^= i;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            int rowXor = 0;
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
                if (i == j) trace += a[i][j];
                rowXor ^= a[i][j];
            }
            if ((rowXor ^ xor) != 0) {
                ansR++;
            }
        }
        for (int j = 0; j < n; j++) {
            int colXor = 0;
            for (int i = 0; i < n; i++) {
                colXor ^= a[i][j];
            }
            if ((colXor ^ xor) != 0) {
                ansC++;
            }
        }
        return trace + " " + ansR + " " + ansC;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }
    }
}
