import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

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
                Map<Integer, Integer> map = new HashMap();
                for (int k = 0; k < N; k++) {
                    if (map.containsKey(matrix[j][k])) {
                        r[k] = 1;
                        r[map.get(matrix[j][k])] = 1;
                    } else {
                        map.put(matrix[j][k], k);
                    }

                    if (j == k) {
                        K += matrix[j][k];
                    }
                }

                map = new HashMap<>();
                for (int k = 0; k < N; k++) {
                    if (map.containsKey(matrix[k][j])) {
                        c[k] = 1;
                        c[map.get(matrix[k][j])] = 1;
                    } else {
                        map.put(matrix[j][k], k);
                    }
                }
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
            sb.append("Case #" + (i + 1) + ": " + K + " " + rCnt + " " + cCnt + "\n");
        }
        System.out.println(sb.toString());
    }
}
