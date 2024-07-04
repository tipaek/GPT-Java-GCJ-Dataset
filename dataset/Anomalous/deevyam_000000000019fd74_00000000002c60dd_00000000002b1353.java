import java.util.*;

public class Main {
    static int T, N;
    static long[][] value = new long[505][505];
    static boolean[][] visit = new boolean[505][505];
    static List<Pair> route = new ArrayList<>();
    static int[] mv1 = {-1, -1, 0, 0, 1, 1};
    static int[] mv2 = {-1, 0, -1, 1, 0, 1};
    static int cnt = 1;

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        init();

        while (T-- > 0) {
            N = sc.nextInt();

            for (int i = 0; i < 505; i++) {
                Arrays.fill(visit[i], false);
            }
            route.clear();
            route.add(new Pair(1, 1));

            DFS(1, 1, 1);
        }

        sc.close();
    }

    static void init() {
        int p = 0;
        for (int i = 1; i < 501; i++) {
            value[i][1] = 1;
            value[i][0] = 0;
            value[i][1 + p] = 1;
            value[i][2 + p] = 0;
            p++;
        }
        p = 1;
        for (int i = 2; i < 501; i++) {
            for (int j = 1; j <= i + p; j++) {
                value[i][j] = value[i - 1][j - 1] + value[i - 1][j];
            }
            p++;
        }
    }

    static boolean DFS(int x, int y, long sum) {
        if (sum > N) return false;
        if (visit[x][y]) return false;
        visit[x][y] = true;

        if (sum == N) {
            System.out.println("Case #" + cnt++ + ":");
            for (Pair p : route) {
                System.out.println(p.first + " " + p.second);
            }
            return true;
        }

        for (int i = 0; i < 6; i++) {
            int next_x = x + mv1[i];
            int next_y = y + mv2[i];

            if (next_x <= 0 || next_y <= 0 || next_x >= 501 || next_y >= 501) continue;
            if (next_x < next_y) continue;

            route.add(new Pair(next_x, next_y));
            if (DFS(next_x, next_y, sum + value[next_x][next_y])) return true;
            route.remove(route.size() - 1);
        }
        visit[x][y] = false;
        return false;
    }
}