import java.io.*;
import java.util.*;

import javax.security.auth.kerberos.KerberosKey;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int R = sc.nextInt(), C = sc.nextInt();
            int[][] A = new int[R][C];
            for (int k = 0; k < R; k++) {
                for (int j = 0; j < C; j++) {
                    A[k][j] = sc.nextInt();
                }
            }
            solve(i, R, C, A);
        }
    }

    private static void solve(int T, int R, int C, int[][] A) {
        System.out.printf("Case #%d: ", T);

        int res = 0;

        TreeMap<Integer, Integer>[] rows = (TreeMap<Integer, Integer>[]) new TreeMap[R];
        TreeMap<Integer, Integer>[] cols = (TreeMap<Integer, Integer>[]) new TreeMap[C];
        for (int i = 0; i < R; i++) rows[i] = new TreeMap<>();
        for (int i = 0; i < C; i++) cols[i] = new TreeMap<>();

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rows[i].put(j, A[i][j]);
                cols[j].put(i, A[i][j]);
                sum += A[i][j];
            }
        }

        while (true) {
            int elim = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (A[i][j] < 0) {
                        continue;
                    }

                    Integer l = rows[i].lowerKey(j), r = rows[i].higherKey(j);
                    Integer u = cols[j].lowerKey(i), d = cols[j].higherKey(j);

                    int cnt = 0, nsum = 0;
                    if (l != null) {
                        cnt++;
                        nsum += A[i][l];
                    }
                    if (r != null) {
                        cnt++;
                        nsum += A[i][r];
                    }
                    if (u != null) {
                        cnt++;
                        nsum += A[u][j];
                    }
                    if (d != null) {
                        cnt++;
                        nsum += A[d][j];
                    }
                    if (cnt > 0 && A[i][j] * cnt < nsum) {
                        elim++;
                        sum -= A[i][j];
                        A[i][j] = -1;
                        rows[i].remove(j);
                        cols[j].remove(i);
                    }
                }
            }
            if (elim > 0) {
                res += sum;
            } else {
                break;
            }
        }

        System.out.println(res);
    }
}