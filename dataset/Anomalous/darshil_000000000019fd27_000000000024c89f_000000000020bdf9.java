import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int[] a = new int[1443];
            int[] b = new int[1443];
            int n = sc.nextInt();
            StringBuilder op = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < n; j++) {
                int l = sc.nextInt();
                int u = sc.nextInt();

                if (j == 0) {
                    Arrays.fill(a, l, u + 1, 1);
                    op.append('C');
                } else {
                    if (l == u) {
                        if (l != 0 && a[l] == 1 && b[l] == 1) {
                            isImpossible = true;
                            break;
                        } else if (b[l + 1] == 1 && b[l - 1] == 1) {
                            a[l] = 1;
                            op.append('C');
                        } else {
                            b[l] = 1;
                            op.append('J');
                        }
                    } else if (a[l + 1] == 0 && a[u - 1] == 0) {
                        Arrays.fill(a, l, u + 1, 1);
                        op.append('C');
                    } else if (b[l + 1] == 0 && b[u - 1] == 0) {
                        Arrays.fill(b, l, u + 1, 1);
                        op.append('J');
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + op.toString());
            }
        }
        sc.close();
    }
}