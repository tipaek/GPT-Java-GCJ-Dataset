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
                    if (!a[l + 1] && !a[u - 1]) {
                        Arrays.fill(a, l, u + 1, true);
                        op.append('C');
                    } else if (!b[l + 1] && !b[u - 1]) {
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

        sc.close();
    }
}