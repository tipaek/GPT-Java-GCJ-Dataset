import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            System.out.printf("Case #%d:\n", t);

            if (N <= 500) {
                for (int i = 1; i <= N; i++) {
                    System.out.printf("%d %d\n", i, 1);
                }
            } else if (N == 501) {
                System.out.printf("%d %d\n", 1, 1);
                System.out.printf("%d %d\n", 2, 2);
                for (int i = 2; i <= N - 1; i++) {
                    System.out.printf("%d %d\n", i, 1);
                }
            } else if (N <= 999) {
                System.out.printf("%d %d\n", 1, 1);
                int dx = N - 500;
                for (int i = 2; i <= 500; i++) {
                    if (dx + 1 == i) {
                        System.out.printf("%d %d\n", i, 2);
                    }
                    System.out.printf("%d %d\n", i, 1);
                }
            } else if (N == 1000) {
                System.out.printf("%d %d\n", 1, 1);
                System.out.printf("%d %d\n", 2, 2);
                int dx = 500;
                for (int i = 2; i <= 500; i++) {
                    if (dx == i + 1) {
                        System.out.printf("%d %d\n", i, 2);
                    }
                    System.out.printf("%d %d\n", i, 1);
                }
            }
        }
    }
}