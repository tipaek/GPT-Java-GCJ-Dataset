import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static final int MOD = (int) 1e9 + 7;
    static final int INFINITY = Integer.MAX_VALUE;
    static final int NEG_INFINITY = Integer.MIN_VALUE;
    static final int MAX_SIZE = 2000;

    static int[] j1 = new int[MAX_SIZE];
    static int[] c = new int[MAX_SIZE];
    static int cc = 0;
    static int jj = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            cc = jj = 0;
            Arrays.fill(j1, 0);
            Arrays.fill(c, 0);
            boolean isImpossible = false;

            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (check(startTimes[j], endTimes[j])) {
                    result.append("J");
                } else if (check1(startTimes[j], endTimes[j])) {
                    result.append("C");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }

        scanner.close();
    }

    static boolean check(int start, int end) {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            if ((start > j1[i] && start < j1[i + 1]) || (end > j1[i] && end < j1[i + 1])) {
                return false;
            }
        }
        j1[jj] = start;
        j1[jj + 1] = end;
        jj += 2;
        return true;
    }

    static boolean check1(int start, int end) {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            if ((start > c[i] && start < c[i + 1]) || (end > c[i] && end < c[i + 1])) {
                return false;
            }
        }
        c[cc] = start;
        c[cc + 1] = end;
        cc += 2;
        return true;
    }
}