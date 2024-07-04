import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Solution.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            System.out.printf("Case #%d:\n", t + 1);
            solve(N);
        }
    }

    private static void solve(int N) {
        if (N < 4) {
            for (int i = 1; i <= N; i++) {
                System.out.printf("%d 1\n", i);
            }
            return;
        }

        System.out.println("1 1");
        System.out.println("2 2");
        N -= 2;

        int r = 3, k = 2;
        int vk2 = 2;

        while (vk2 <= N) {
            System.out.printf("%d %d\n", r, k);
            r++;

            N -= vk2;

            vk2 += 1;
        }

        while (N > 0) {
            N--;
            r--;
            System.out.printf("%d %d\n", r, 1);
        }

    }


}
