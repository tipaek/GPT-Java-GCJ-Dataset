import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (k % n != 0) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                int d = k / n;
                int[][] res = new int[n][n];
                int start = (n - d + 1) % n;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        res[i][(i + j + start) % n] = j + 1;
                    }
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        stringBuilder.append(res[i][j]);
                        if (j < n - 1) {
                            stringBuilder.append(" ");
                        }
                    }
                    stringBuilder.append("\n");
                }
                System.out.print("Case #" + t + ": POSSIBLE\n" + stringBuilder);
            }
        }
    }
}