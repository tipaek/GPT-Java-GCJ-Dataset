import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static final int MOD = 1_000_000_007;
    static final int INFINITY = Integer.MAX_VALUE;
    static final int NEG_INFINITY = Integer.MIN_VALUE;
    static final int MAX_SIZE = 2000;
    static int[] j1 = new int[MAX_SIZE];
    static int[] c = new int[MAX_SIZE];
    static int cc = 0;
    static int jj = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                cc = jj = 0;
                Arrays.fill(j1, 0);
                Arrays.fill(c, 0);
                int z = 0;
                int n = scanner.nextInt();
                int[] s = new int[n];
                int[] e = new int[n];

                for (int j = 0; j < n; j++) {
                    s[j] = scanner.nextInt();
                    e[j] = scanner.nextInt();
                }

                StringBuilder q = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (check(s[j], e[j]) == 1) {
                        q.append("J");
                    } else if (check1(s[j], e[j]) == 1) {
                        q.append("C");
                    } else {
                        z = 1;
                        break;
                    }
                }

                if (z == 1) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + q.toString());
                }
            }
        } catch (Exception e) {
            System.out.println(0);
        }
    }

    static int check(int z, int x) {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            if ((z > j1[i] && z < j1[i + 1]) || (x > j1[i] && x < j1[i + 1])) {
                return 0;
            }
        }
        j1[jj] = z;
        j1[jj + 1] = x;
        jj += 2;
        return 1;
    }

    static int check1(int z, int x) {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            if ((z > c[i] && z < c[i + 1]) || (x > c[i] && x < c[i + 1])) {
                return 0;
            }
        }
        c[cc] = z;
        c[cc + 1] = x;
        cc += 2;
        return 1;
    }
}