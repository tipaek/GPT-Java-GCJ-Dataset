import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static int N;
    private static int[][] M;
    private static int k;
    private static int r;
    private static int c;
    private static boolean[] isDuplicated;

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int T = sc.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            initTrace();
            computeC();
            computeR();
            printAnswer(caseNum);
        }
    }

    private static void initTrace() {
        N = sc.nextInt();
        isDuplicated = new boolean[N + 5];
        M = new int[N][N];
        k = 0;
        r = 0;
        c = 0;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                M[row][col] = sc.nextInt();

                // compute k
                if (row == col) {
                    k += M[row][col];
                }
            }
        }
    }

    private static void computeC() {
        for (int col = 0; col < N; col++) {
            initIsDuplicated();
            for (int row = 0; row < N; row++) {
                int num = M[row][col];
                if (isDuplicated[num]) {
                    c++;
                    break;
                }
                isDuplicated[num] = true;
            }
        }
    }

    private static void computeR() {
        for (int row = 0; row < N; row++) {
            initIsDuplicated();
            for (int col = 0; col < N; col++) {
                int num = M[row][col];
                if (isDuplicated[num]) {
                    r++;
                    break;
                }
                isDuplicated[num] = true;
            }
        }
    }

    private static void initIsDuplicated() {
        Arrays.fill(isDuplicated, false);
    }

    private static void printAnswer(int caseNum) {
        System.out.printf("Case #%d: %d %d %d\n", caseNum, k, r, c);
    }
}
