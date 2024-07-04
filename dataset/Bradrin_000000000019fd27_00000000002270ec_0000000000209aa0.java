import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static Scanner scan;

    private void solve() {
        int n = scan.nextInt();
        int k = scan.nextInt();
        int max = n * n;

        int a;
        int b;
        int c;
        if (k % n == 0) {
            a = k / n;
            b = a;
            c = a;
        } else if (n % 2 == 0) {
            if (k < n + 2) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (k > max - 2) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            a = findModeEven(n, k);
            int rem = k - a * (n - 2);
            b = rem / 2;
            if (rem % 2 == 0) {
                c = b;
            } else {
                c = b + 1;
            }
            if (a == b || a == c) {
                b--;
                c++;
            }
        } else {
            if (k < n + 3) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (k > max - 3) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            a = findModeOdd(n, k);
            int rem = k - a * (n - 2);
            if (rem % 2 == 0) {
                b = rem / 2 - 1;
                c = b + 2;
            } else {
                b = rem / 2;
                c = b + 1;
            }
            if (a == b || a == c) {
                b--;
                c++;
            }
        }
        System.out.println("POSSIBLE");

        int[][] m = create(n, a);

        if (b != c) {
            int[] t = m[0];
            m[0] = m[1];
            m[1] = t;
            swap(m, b, m[0][0]);
            swap(m, c, m[1][1]);
        } else if (a != b) {
            int[] t = m[0];
            m[0] = m[n/2];
            m[n/2] = t;
            swap(m, b, m[0][0]);
            swap(m, c, m[n/2][n/2]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.stream(m[i]).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        }
    }

    private int[][] create(int n, int d) {
        int[][] m = new int[n][n];

        int v = d - 1;
        for (int i = 0; i < n; i++) {
            v--;
            for (int j = 0; j < n; j++) {
                v++;
                m[i][j] = (v % n) + 1;
            }
        }

        return m;
    }

    private void swap(int[][] m, int x, int y) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == x) {
                    m[i][j] = y;
                } else if (m[i][j] == y) {
                    m[i][j] = x;
                }
            }
        }
    }

    private int findModeEven(int n, int k) {
        for (int i = 1; i < n; i++) {
            if (i * (n - 2) + 2 * n - 1 > k) {
                return i;
            }
        }
        return n;
    }

    private int findModeOdd(int n, int k) {
        for (int i = 1; i < n - 1; i++) {
            if (i * (n - 2) + n + n - 1 > k) {
                return i;
            }
        }
        if (n * (n - 1) > k) {
            return n - 1;
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve();
        }
        scan.close();
    }
}
