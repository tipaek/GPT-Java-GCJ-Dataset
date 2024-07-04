import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            boolean[] a = new boolean[1442];
            boolean[] b = new boolean[1442];
            int n = sc.nextInt();
            StringBuilder op = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                int l = sc.nextInt();
                int u = sc.nextInt();

                if (j == 0) {
                    Arrays.fill(a, l, u + 1, true);
                    op.append('C');
                } else {
                    if (isAvailable(a, l, u)) {
                        Arrays.fill(a, l, u + 1, true);
                        op.append('C');
                    } else if (isAvailable(b, l, u)) {
                        Arrays.fill(b, l, u + 1, true);
                        op.append('J');
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + op.toString());
            }
        }
    }

    private static boolean isAvailable(boolean[] arr, int l, int u) {
        for (int p = l; p <= u; p++) {
            if (arr[p]) {
                return false;
            }
        }
        return true;
    }
}