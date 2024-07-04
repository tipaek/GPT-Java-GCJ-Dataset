import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.next();
            int[][] g = new int[2001][2001];
            int px = 1000;
            int py = 1000;
            /*
            int[][] g = new int[21][21];
            int px = 10;
            int py = 10;
            */

            List<List<Integer>> tour = new ArrayList<>();
            List<Integer> te = new ArrayList<>();
            te.add(px);
            te.add(py);
            tour.add(te);
            g[py][px] = 1;
            for (int i = 0; i < M.length(); i++) {
                char d = M.charAt(i);
                if (d == 'N') py--;
                if (d == 'S') py++;
                if (d == 'E') px++;
                if (d == 'W') px--;
                g[py][px] = 1;
                te = new ArrayList<>();
                te.add(px);
                te.add(py);
                tour.add(te);
                
            }
            // BFS
            boolean[][] visited = new boolean[2001][2001];
            int myx = 1000-X;
            int myy = 1000+Y;
            /*
            boolean[][] visited = new boolean[21][21];
            int myx = 10-X;
            int myy = 10+Y;
            */

            LinkedList<Pair> q = new LinkedList<>();
            q.offer(new Pair(myx,myy,0));
            int tmp = -1;
            int nearX = -1;
            int nearY = -1;
            while (!q.isEmpty()) {
                Pair now = q.poll();
                if (g[now.y][now.x] == 1) {
                    tmp = now.dist;
                    nearX = now.x;
                    nearY = now.y;
                    break;
                }
                visited[now.y][now.x] = true;;
                for (int v = 0; v < 4; v++) {
                    int nx = now.x+dx[v];
                    int ny = now.y+dy[v];
                    if (nx < 0 || visited[0].length <= nx
                        || ny < 0 || visited.length <= ny) continue;
                    if (visited[ny][nx]) continue;
                    q.add(new Pair(nx,ny,now.dist+1));
                }
            }
            ans.append("Case #"+t+": "); 
            if (tmp == -1) {
                ans.append("IMPOSSIBLE\n");
                continue;
            }
            /*
            ans.append(tmp).append('\n');
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[0].length; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println("## " + myx + ","+myy);
            System.out.println("## " + nearX + ","+nearY);
            */
            int ti = 0;
            for (int i = 0; i < tour.size(); i++) {
                List<Integer> ll = tour.get(i);
                if (ll.get(0) == nearX && ll.get(1) == nearY) {
                    ti = i;
                    break;
                }
            }
            boolean[][] visited2 = new boolean[2001][2001];
            //System.out.println("## tmp:" + tmp + ",ti:"+ti);
            if (tmp <= ti) {
                ans.append(tmp+(ti-tmp+1)/2).append('\n');
            } else {
                boolean success = false;
                for (int i = tmp; i < tour.size(); i++) {
                    int mfx = tour.get(i-(tmp-ti)).get(0);
                    int mfy = tour.get(i-(tmp-ti)).get(1);
                    visited2[mfy][myx] = true;

                    int ffx = tour.get(i).get(0);
                    int ffy = tour.get(i).get(1);
                    if (visited2[ffy][ffx]) {
                        ans.append(i).append('\n');
                        success = true;
                        break;
                    }
                }
                if (!success) ans.append("IMPOSSIBLE\n");
            }

        }
        System.out.print(ans);
    }

    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };

    private static class Pair {
        private final int x;
        private final int y;
        private final int dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

