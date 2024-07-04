import java.util.*;
public class Solution {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static void solve() {
        int R = scanner.nextInt();
        int S = scanner.nextInt();
        System.out.print((R - 1) * (S - 1) + "\n");
        int j = 0;
        for (int i = R; i >= 2; i--) {
            for (int k = 0; k < S - 1; k++) {
                System.out.println(i + " " + (R * S - 1 - j * S - i - k));
            }
            j++;
        }
    }
}
