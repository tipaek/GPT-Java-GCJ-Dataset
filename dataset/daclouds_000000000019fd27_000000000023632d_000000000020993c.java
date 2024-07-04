import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static int calcK(final int n, final int[][] m) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += m[i][i];
        }
        return k;
    }

    public static int calcR(final int n, final int[][] m) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            final Set<Integer> s = new TreeSet<Integer>();
            for (int j = 0; j < n; j++) {
                s.add(m[i][j]);
            }
            if (s.size() != n) r++;
        }
        return r;
    }

    public static int calcC(final int n, final int[][] m) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            final Set<Integer> s = new TreeSet<Integer>();
            for (int j = 0; j < n; j++) {
                s.add(m[j][i]);
            }
            if (s.size() != n) c++;
        }
        return c;
    }
    
    public static void solve(int t, int n, int[][] m) {
        final int k = calcK(n, m);
        final int r = calcR(n, m);
        final int c = calcC(n, m);
        System.out.println("Case #" + (t + 1) + ": " + k + " " + r + " " + c);
    }

    public static void main(final String[] args) {
        final int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            final int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            final int[][] m = new int[n][n];

            for (int i = 0; i < n; i++) {
                final String[] rItems = scanner.nextLine().split(" ");
                for (int j = 0; j < rItems.length; j++) {
                    int rItem = Integer.parseInt(rItems[j]);
                    m[i][j] = rItem;
                }
            }
            solve(tItr, n, m);
        }

        scanner.close();
    }
}