import java.util.Scanner;

public class Solution {
    public static String solve(Scanner s) {
        int n = s.nextInt();
        int a[][] = new int[n][n];
        int ansR = 0;
        int ansC = 0;
        int sum = (n * (n + 1)) / 2;
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int rowXor = 0;
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
                if (i == j) trace += a[i][j];
                rowSum += a[i][j];
                rowXor ^= a[i][j];
            }
            if (rowSum != sum || ((rowXor ^ xor) != 0)) {
                ansR++;
            }
        }
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            int colXor = 0;
            for (int i = 0; i < n; i++) {
                colSum += a[i][j];
                colXor ^= a[i][j];
            }
            if (colSum != sum || ((colXor ^ xor) != 0)) {
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
