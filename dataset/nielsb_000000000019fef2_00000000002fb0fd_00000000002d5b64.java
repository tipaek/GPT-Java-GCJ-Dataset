import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": ");
            new Solution(scanner).solve();
        }
    }

    final int R, S;

    public Solution(Scanner scanner) {
        R = scanner.nextInt();
        S = scanner.nextInt();
    }

    private void solve() {
        System.out.println((R - 1) * (S - 1));
        for (int r = R; r > 1; r--) {
            for (int s = 1; s < S; s++) {
                System.out.println("" + (r * S - r - s + 1)  + " " + (r - 1));
            }
        }
    }

}