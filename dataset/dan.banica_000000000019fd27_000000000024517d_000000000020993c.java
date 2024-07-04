import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private void run() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int nTests = sc.nextInt();

        int[][] a = new int[100][100];
        for (int test = 0; test < nTests; test++) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += a[i][i];
            }

            int nInvalidRows = 0;
            for (int i = 0; i < n; i++) {
                boolean distinct = true;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < j; k++) {
                        if (a[i][j] == a[i][k]) {
                            distinct = false;
                        }
                    }
                }
                if (!distinct) {
                    nInvalidRows++;
                }
            }

            int nInvalidCols = 0;
            for (int j = 0; j < n; j++) {
                boolean distinct = true;
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < i; k++) {
                        if (a[i][j] == a[k][j]) {
                            distinct = false;
                        }
                    }
                }
                if (!distinct) {
                    nInvalidCols++;
                }
            }

            System.out.println(String.format("%d %d %d",
                    trace, nInvalidRows, nInvalidCols));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.run();
    }
}
