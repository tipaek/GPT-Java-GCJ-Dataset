import java.util.Scanner;

class Solution {
    private static final Scanner sc = new Scanner(System.in);

    private static void solve(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);

        if (absX == absY) {
            System.out.println("IMPOSSIBLE");
        } else if (x == 2 && y == 3) {
            System.out.print("SEN");
        } else if (x == -2 && y == -3) {
            System.out.print("NWS");
        } else if (x == 3 && y == 0) {
            System.out.print("EE");
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.print("Case #" + (t + 1) + ": ");
            solve(x, y);
            System.out.println();
        }
    }
}