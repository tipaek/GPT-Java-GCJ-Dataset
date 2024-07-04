import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private void work() {
        int[] p = new int[32];
        p[0] = 1;
        for (int i = 1; i < p.length; i++) {
            p[i] = p[i - 1] << 1;
        }
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int n = sc.nextInt() - 1;
            System.out.printf("Case #%d:\n1 1\n", tc);
            if (n < 1500) {
                int r = 2;
                while (n >= p[r - 1]) {
                    if ((r & 1) == 0) {
                        for (int i = 1; i <= r; i++) {
                            System.out.printf("%d %d\n", r, i);
                        }
                    } else {
                        for (int i = r; i > 0; i--) {
                            System.out.printf("%d %d\n", r, i);
                        }
                    }
                    n -= p[r++ - 1];
                }

                if (n > 0) {
                    if ((r & 1) == 0) {
                        while (n > 0) {
                            if (n == r) {
                                System.out.printf("%d %d\n", r, 2);
                                break;
                            }
                            n--;
                            System.out.printf("%d %d\n", r, 1);

                            if (n == r) {
                                System.out.printf("%d %d\n", r, 2);
                                break;
                            }
                            r++;
                        }
                    } else {
                        while (n > 0) {
                            if (n == r) {
                                System.out.printf("%d %d\n", r, r - 1);
                                break;
                            }
                            n--;
                            System.out.printf("%d %d\n", r, r);

                            if (n == r) {
                                System.out.printf("%d %d\n", r, r - 1);
                                break;
                            }
                            r++;
                        }
                    }
                }
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
