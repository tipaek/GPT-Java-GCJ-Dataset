import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private void work() {
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            long[][] a = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            long ans = 0;
            boolean[][] removed = new boolean[r][c];
            boolean[][][] noone = new boolean[r][c][4];
            Queue<Integer> toRemove = new LinkedList<>();
            while (true) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (!removed[i][j]) {
                            ans += a[i][j];
                            int cnt = 0;
                            long sum = 0;
                            for (int k = 0; k < 4; k++) {
                                if (!noone[i][j][k]) {
                                    int ii = i + dr[k];
                                    int jj = j + dc[k];
                                    while (ii >= 0 && ii < r && jj >= 0 && jj < c) {
                                        if (!removed[ii][jj]) {
                                            cnt++;
                                            sum += a[ii][jj];
                                            break;
                                        }
                                        ii += dr[k];
                                        jj += dc[k];
                                    }

                                    if (ii < 0 || ii == r || jj < 0 || jj == c) {
                                        noone[i][j][k] = true;
                                    }
                                }
                            }

                            if (cnt > 0) {
                                if (cnt * a[i][j] < sum) {
                                    toRemove.add(i);
                                    toRemove.add(j);
                                }
                            }
                        }
                    }
                }

                if (toRemove.isEmpty()) break;
                while (!toRemove.isEmpty()) {
                    int i = toRemove.poll();
                    int j = toRemove.poll();
                    removed[i][j] = true;
                }
            }

            System.out.printf("Case #%d: %d\n", tc, ans);
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
