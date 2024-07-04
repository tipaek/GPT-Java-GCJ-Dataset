import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int z = 0; z < t; z++) {
            boolean flag = false;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int j = 0;
            for (int i = 1; i <= n; i++) {
                if (i * n == k) {
                    j = i;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("Case #" + (z + 1) + ": POSSIBLE");
                int a[] = new int[n];
                a[0] = j;
                int m = 1;
                int i = 1;
                while (i < n) {
                    if (m != j) {
                        a[i++] = m;
                    }
                    m++;
                }
                for (int g = 0; g < n; g++) {
                    leftRotatebyOne(a, a.length);
                    System.out.println();
                }
            } else
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
        }
    }

    private static void leftRotatebyOne(int[] a, int n) {
        int i, temp;
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        temp = a[n-1];
        for (i = n-1; i > 0; i--)
            a[i] = a[i-1];
        a[0] = temp;
    }
}
