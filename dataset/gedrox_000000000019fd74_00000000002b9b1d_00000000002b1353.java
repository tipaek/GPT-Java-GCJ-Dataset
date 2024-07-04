import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            if (n > 2000) {
                continue;
            }
            int[] s = solve(n);

            System.out.printf("Case #%d:%n", i + 1);
            System.out.println("1 1");
            for (int i1 = 1; i1 <= s[0]; i1++) {
                System.out.printf("%d %d%n", i1 + 1, 2);
            }
            for (int i1 = 0; i1 < s[1]; i1++) {
                System.out.printf("%d %d%n", s[0] + 1 + i1, 1);
            }
        }
    }

    private static int[] solve(int n) {
        int t = (int)Math.sqrt(2 * n) + 1;
        while (t * (t + 1) / 2 + 1 > n) {
            t--;
        }
        return new int[] {t, n - t * (t + 1) / 2 - 1};
    }
}
