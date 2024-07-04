import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    
    static boolean isOverlap(int a, int b) {
        return a > b;
    }

    static boolean isImpossible(int n, int[][] m, int i) {
        for (; i < n; i++) {
            if (!isOverlap(m[i - 1][1], m[i][0])) {
                return false;
            }
        }
        return true;
    }
    
    static char toggle(char w) {
        return w == 'C' ? 'J' : 'C';
    }

    static String solve(int n, int[][] m) {
        StringBuilder sb = new StringBuilder();
        sb.append("C");
        for (int i = 1; i < n; i++) {
            if ((i < m.length) && isImpossible(n, m, i)) {
                return "IMPOSSIBLE";
            }
            if (isOverlap(m[i - 1][1], m[i][0])) {
                sb.append(toggle(sb.charAt(sb.length() - 1)));
            } else {
                sb.append(sb.charAt(sb.length() - 1));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
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
            System.out.println("Case #" + (tItr + 1) + ": " + solve(m.length, m));
        }

        scanner.close();
    }
}