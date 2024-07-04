package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = in.nextInt();

        for (int x = 1; x <= T; ++x) {
            final int N = in.nextInt();
            final int[][] M = new int[N + 1][N + 1];
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    M[i][j] = in.nextInt();
                }
            }

            int k = 0;
            for (int i = 1; i <= N; ++i) {
                k += M[i][i];
            }

            int r = 0;
            for (int i = 1; i <= N; ++i) {
                boolean repeated = false;
                final Set<Integer> elements = new HashSet<>();
                for (int j = 1; j <= N; ++j) {
                    if (elements.contains(M[i][j])) {
                        repeated = true;
                        break;
                    } else {
                        elements.add(M[i][j]);
                    }
                }
                if (repeated) {
                    r++;
                }
            }

            int c = 0;
            for (int j = 1; j <= N; ++j) {
                boolean repeated = false;
                final Set<Integer> elements = new HashSet<>();
                for (int i = 1; i <= N; ++i) {
                    if (elements.contains(M[i][j])) {
                        repeated = true;
                        break;
                    } else {
                        elements.add(M[i][j]);
                    }
                }
                if (repeated) {
                    c++;
                }
            }

            System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
            System.out.flush();

        }
    }
}
