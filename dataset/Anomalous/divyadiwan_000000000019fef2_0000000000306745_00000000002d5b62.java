import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int h = scanner.nextInt();
            int v = scanner.nextInt();
            int sum = Math.abs(h) + Math.abs(v);
            int rh = getReversedBits(Math.abs(h));
            int rv = getReversedBits(Math.abs(v));
            int k = (int) (Math.log(sum + 1) / Math.log(2));

            if (Math.pow(2, k) == sum + 1) {
                System.out.println("Case #" + t + ": " + buildPath(h, v, 0, 0, k));
            } else {
                sum = Math.abs(h) + 2 * rh + 2 * rv + Math.abs(v);
                k = (int) (Math.log(sum + 1) / Math.log(2));

                if (Math.pow(2, k) == sum + 1) {
                    System.out.println("Case #" + t + ": " + buildPath(h, v, rh, rv, k));
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }
    }

    static int getReversedBits(int n) {
        int reversed = 0;
        int k = (int) (Math.log(n) / Math.log(2));

        for (int i = 0; i < k; i++) {
            if ((n & (1 << i)) == 0) {
                reversed |= 1 << i;
            }
        }

        return reversed;
    }

    static String buildPath(int h, int v, int rh, int rv, int k) {
        char[] path = new char[k];

        if (h > 0) {
            for (int i = 0; i < k; i++) {
                if (((h + rv) & (1 << i)) != 0) path[i] = 'E';
                if ((rv & (1 << i)) != 0) path[i] = 'W';
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (((-h + rv) & (1 << i)) != 0) path[i] = 'W';
                if ((rv & (1 << i)) != 0) path[i] = 'E';
            }
        }

        if (v > 0) {
            for (int i = 0; i < k; i++) {
                if (((v + rh) & (1 << i)) != 0) path[i] = 'N';
                if ((rh & (1 << i)) != 0) path[i] = 'S';
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (((-v + rh) & (1 << i)) != 0) path[i] = 'S';
                if ((rh & (1 << i)) != 0) path[i] = 'N';
            }
        }

        return new String(path);
    }
}