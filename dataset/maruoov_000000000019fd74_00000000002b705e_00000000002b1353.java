import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[12][13];
        map[0][0] = 1;

        for (int i = 1; i < 12; i++) {
            for (int j = 0; j <= i; j++) {
                if (j - 1 >= 0) {
                    map[i][j] = map[i-1][j-1] + map[i-1][j];
                } else {
                    map[i][j] = map[i-1][j];
                }
            }
        }


        int T = sc.nextInt();
        int cn = 1;
        while(T > 0) {
            T--;

            long N = sc.nextLong();
            int[][] path = new int[501][2];
            path[0][0] = 1;
            path[0][1] = 1;
            boolean[][] visit = new boolean[12][13];
            visit[0][0] = true;
            visit[0][1] = true;
            List<List<Integer>> res = new ArrayList<>();

            find(map, 0, 0, path, 1, 1,N, res, visit);



            System.out.printf("Case #%d:%n",cn);
            for (int i = 0; i < res.size(); i++) {
                List<Integer> temp = res.get(i);
                System.out.printf("%d %d%n", temp.get(0), temp.get(1));
            }
            cn++;

        }


    }

    public static void find(int[][] map, int curX, int curY, int[][] path, long sum, int cnt,  long N, List<List<Integer>> res, boolean[][] visit) {
        if (cnt > 500 || sum > N || !res.isEmpty()) {
            return;
        }

        if (sum == N) {
            for (int i = 0; i < path.length; i++) {
                if (path[i][0] == 0) break;

                List<Integer> list = new ArrayList<>();
                list.add(path[i][0]);
                list.add(path[i][1]);
                res.add(list);

            }

            return;
        }

        int[] dx = {-1,-1,0,0,1,1};
        int[] dy = {-1,0,-1,1,0,1};

        for (int i = 0; i < 6; i++) {
            int tx = curX + dx[i];
            int ty = curY + dy[i];

            if (tx < 0 || ty < 0 || tx > 12 || ty > 12 || map[tx][ty] == 0 || visit[tx][ty]) continue;

            path[cnt][0] = tx + 1;
            path[cnt][1] = ty + 1;
            visit[tx][ty] = true;

            find(map, tx, ty, path, sum + map[tx][ty], cnt + 1, N, res, visit);

            visit[tx][ty] = false;
            path[cnt][0] = 0;
            path[cnt][1] = 0;
        }


    }
}
