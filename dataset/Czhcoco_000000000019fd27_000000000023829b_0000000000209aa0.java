import java.util.*;
import java.io.*;

public class Solution {
    private static boolean equalTrace(int[][] m, int k) {
        int trace = 0;
        for (int i = 0; i < m.length; i++) {
            trace += m[i][i];
        }
        return k == trace;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int times = scanner.nextInt();
        for (int t = 1; t <= times; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            boolean valid = true;
            String ans = "POSSIBLE";
            int[][] m = new int[n][n];

            int a = n+1;
            for (int i = 0; i < n; i++)
            {
                int temp = a;
                int cur = 0;
                while (temp <= n)
                {
                    m[i][cur] = temp;
                    temp++;
                    cur++;
                }
                for (int j = 1; j < a; j++, cur++)
                    m[i][cur] = j;
                a--;
            }

            int d = 0;
            for (; d < n; d++) {
                if (equalTrace(m, k)) {
                    break;
                } else {
                    for (int b = 0; b < n; b++) {
                        int temp = m[b][0];
                        for (int c = 0; c < n - 1; c++) {
                            m[b][c] = m[b][c+1];
                        }
                        m[b][n-1] = temp;
                    }
                }
            }

            if (d == n)
                valid = false;

            if (!valid) {
                ans = "IMPOSSIBLE";
            }

            System.out.println(String.format("Case #%d: %s", t, ans));
            if (valid) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(m[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

}