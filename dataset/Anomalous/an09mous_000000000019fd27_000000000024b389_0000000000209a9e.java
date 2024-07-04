import java.util.Scanner;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        int n = sc.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int[] a = new int[n];
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                System.out.println(i);
                int res = sc.nextInt();

                if (i % 10 == 1) {
                    a[i - 1] = -1;
                    cnt++;
                } else {
                    a[i - 1] = res;
                }
            }

            int pos = 1;
            while (cnt > 0) {
                System.out.println(pos);
                int res = sc.nextInt();

                if (pos % 10 != 1) {
                    a[pos - 1] = res;
                    pos += 10;
                    cnt--;
                }
            }

            for (int i = n + 1; i <= 150; i++) {
                System.out.println(1);
                sc.nextInt();
            }

            StringBuilder ans = new StringBuilder();
            for (int x : a) {
                ans.append(x);
            }
            System.out.println(ans);

            String o = sc.next();
            if (o.equals("N")) {
                return;
            }
        }
    }
}