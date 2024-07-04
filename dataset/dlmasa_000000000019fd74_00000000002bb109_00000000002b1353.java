import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t = 1 ; t <= T; t++) {
            int N = scan.nextInt();
            if (N <= 500) {
                System.out.printf("Case #%d:\n", t);
                System.out.printf("%d %d\n", 1, 1);
                for (int i = 2; i <= N; i++) {
                    System.out.printf("%d %d\n", i, 1);
                }
                continue;
            }
            if (501 <= N && N <= 997) {
                System.out.printf("Case #%d:\n", t);
                System.out.printf("%d %d\n", 1, 1);
                int dx = N - 499;
                for (int i = 2; i <= 499; i++) {
                    if (dx + 1 == i) {
                        System.out.printf("%d %d\n", i, 2);
                    }
                    System.out.printf("%d %d\n", i, 1);
                }
                continue;
            }
            if (998 <= N && N <= 1000) {
                System.out.printf("Case #%d:\n", t);
                System.out.printf("%d %d\n", 1, 1);
                int dx1 = 995 - 498;
                int dx2 = N - 995;
                for (int i = 2; i <= 498; i++) {
                    if (dx1 + 1 == i || dx2 + 1 == i) {
                        System.out.printf("%d %d\n", i, 2);
                    }
                    System.out.printf("%d %d\n", i, 1);
                }
                continue;
            }
            System.out.printf("Case #%d:\n", t);
        }
    }
}
