import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = Integer.parseInt(in.nextLine());
        for (int tc = 1; tc <= tests; tc++) {
            String[] data = in.nextLine().split(" ");
            int n = Integer.parseInt(data[0]);
            int k = Integer.parseInt(data[1]);
            if (k < n || k % n != 0) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                continue;
            }
            int[][] m = new int[n][n];
            int x = k / n;
            for (int row = 0; row < n; row++) {
                for (int col = row, val = x, i = 0; i < n; i++, col++) {
                    m[row][col % n] = val;
                    val = val == n ? 1 : val + 1;
                }
            }
            System.out.println("Case #" + tc + ": POSSIBLE");
            for (int[] row : m) {
                StringBuilder sb = new StringBuilder();
                for (int val : row) {
                    sb.append(val).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
}
