import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            if ((k % n == 1) || (k % n == (n - 1)) || n > k) {
                isPossible = false;
                break;
            }
        }

        System.out.println("Case #" + (tn++) + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
    }
}