import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int[] r = new int[N];
            int[] c = new int[N];
            int K = 0;

            for (int j = 0; j < N; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (set.contains(matrix[j][k])) {
                        r[j] = 1;
                        break;
                    } else {
                        set.add(matrix[j][k]);
                    }
                }

                set = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (set.contains(matrix[k][j])) {
                        c[j] = 1;
                        break;
                    } else {
                        set.add(matrix[k][j]);
                    }
                }

                K += matrix[j][j];
            }

            int rCnt = 0;
            for (int j : r) {
                if (j == 1)
                    rCnt++;
            }
            int cCnt = 0;
            for (int j : c) {
                if (j == 1)
                    cCnt++;
            }
            System.out.println("Case #" + (i + 1) + ": " + K + " " + rCnt + " " + cCnt);
        }
    }
}
