import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int x = in.nextInt(), y = in.nextInt();
            ans = null;
            bfs(y, x);
            System.out.println("Case #" + tc + ": " + (ans != null ? ans : "IMPOSSIBLE"));
        }
    }

    static void bfs(int dstR, int dstC) {
        boolean[][] visited = new boolean[201][201];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, ""));
        markVisited(visited, 0, 0);
        int step = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                Node curr = q.poll();
                int r = curr.r, c = curr.c;
                String path = curr.path;
                if (r == dstR && c == dstC) {
                    ans = path;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = r + DIR[i] * step;
                    int nc = c + DIR[i+1] * step;
                    if (step == 1 && nr == dstR && nc == dstC) continue; // it is not sufficient to pass over it on a jump.
                    if (Math.abs(nr) > 100 || Math.abs(nc) > 100 || visited[nr+100][nc+100]) continue;
                    markVisited(visited, nr, nc);
                    q.offer(new Node(nr, nc, path + DIRC[i]));
                }
            }
            step *= 2;
        }
    }

    static void markVisited(boolean[][] visited, int r, int c) {
        visited[r+100][c+100] = true;
    }

    static class Node {
        int r, c;
        String path;

        public Node(int r, int c, String path) {
            this.r = r;
            this.c = c;
            this.path = path;
        }
    }

    static int[] DIR = new int[]{0, 1, 0, -1, 0};
    static char[] DIRC = new char[]{'E', 'N', 'W', 'S'};
    static String ans = null;
}