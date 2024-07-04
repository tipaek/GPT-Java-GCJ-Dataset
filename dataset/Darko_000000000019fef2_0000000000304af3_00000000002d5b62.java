import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private void work() {
        gen();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if ((x + y) % 2 == 0) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
                continue;
            }

            if (Math.abs(x) > 100 || Math.abs(y) > 100) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
                continue;
            }
            System.out.printf("Case #%d: %s\n", tc, ans[x + 100][y + 100]);
        }
        sc.close();
    }

    private String[][] ans = new String[201][201];
    private String dirs = "NESW";
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    private void gen() {
        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                ans[i + 100][j + 100] = "IMPOSSIBLE";
            }
        }

        Queue<State> q1 = new LinkedList<>();
        Queue<State> nq = new LinkedList<>();
        q1.add(new State(0, 0, ""));
        for (int i = 0, p = 1; i < 10; i++, p *= 2) {
            nq.clear();
            while (!q1.isEmpty()) {
                State s = q1.poll();
                for (int d = 0; d < 4; d++) {
                    int x = s.x + p * dx[d];
                    int y = s.y + p * dy[d];
                    String path = s.path + dirs.charAt(d);
                    if (x >= -100 && x <= 100 && y >= -100 && y <= 100 && ans[x + 100][y + 100].equals("IMPOSSIBLE")) {
                        ans[x + 100][y + 100] = path;
                    }
                    nq.add(new State(x, y, path));
                }
            }
            q1.addAll(nq);
        }
    }

    public static void main(String[] args) {
        new Solution().work();
    }

    class State {
        int x, y;
        String path;

        State(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}
