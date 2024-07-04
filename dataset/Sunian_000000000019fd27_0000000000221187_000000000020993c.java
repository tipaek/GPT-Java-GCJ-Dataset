import java.util.Scanner;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scan.nextLine());
            int[][] M = new int[N][N];
            for (int row = 0; row < N; row++) {
                String[] elements = scan.nextLine().split(" ");
                for (int col = 0; col < elements.length; col++) {
                    M[row][col] = Integer.parseInt(elements[col]);
                }
            }
            System.out.printf("Case #%d: ", i + 1);
            int trace = 0;
            for (int n = 0; n < N; n++) {
                trace += M[n][n];
            }
            System.out.print(trace + " ");
            int R = 0;
            int C = 0;
            for (int n = 0; n < N; n++) {
                if (hasRepeatsInCol(M, n)) {
                    C++;
                }
                if (hasRepeatsInRow(M, n)) {
                    R++;
                }
            }
            System.out.println(R + " " + C);
        }
    }

    private static boolean hasRepeatsInRow(int[][] M, int row) {
        int[] counts = new int[M.length];
        for (int num : M[row]) {
            counts[num - 1]++;
            if (counts[num - 1] > 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasRepeatsInCol(int[][] M, int col) {
        int[] counts = new int[M.length];
        for (int row = 0; row < M.length; row++) {
            int num = M[row][col];
            counts[num - 1]++;
            if (counts[num - 1] > 1) {
                return true;
            }
        }
        return false;
    }
}
