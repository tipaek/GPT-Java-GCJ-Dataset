import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] s = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    s[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + foo(r, c, s));
        }
    }

    private static int foo(int r, int c, final int[][] s) {
        int inter = 0;
        int totalSum = 0;
        int[] sumR = new int[r];
        int[] sumC = new int[c];
        int[] countR = new int[r];
        int[] countC = new int[c];
        boolean[][] in = new boolean[r][c];
        Arrays.fill(countR, c);
        Arrays.fill(countC, r);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sumR[i] += s[i][j];
                sumC[j] += s[i][j];
                totalSum += s[i][j];
                in[i][j] = true;
            }
        }
        boolean elim = true;
        while (elim) {
            elim = false;
            inter += totalSum;
            boolean[][] out = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (in[i][j]) {
                        int s0 = s[i][j];
                        if (sumR[i] + sumC[j] - s0 > s0 * (countR[i] + countC[j] - 1)) {
                            elim = true;
                            in[i][j] = false;
                            out[i][j] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (out[i][j]) {
                        int s0 = s[i][j];
                        totalSum -= s0;
                        sumR[i] -= s0;
                        sumC[j] -= s0;
                        countR[i]--;
                        countC[j]--;
                    }
                }
            }
        }
        return inter;
    }

}
