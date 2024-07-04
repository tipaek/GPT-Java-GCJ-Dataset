import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static final int LIMIT = 100;
    private static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private static final String[] ways = {"N", "S", "E", "W"};

    private static String solve(int x, int y) {
        int maxStep = (int) (Math.log(LIMIT) / Math.log(2) + 1);
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[2*LIMIT+1][2*LIMIT+1];
        String[][] paths = new String[2*LIMIT+1][2*LIMIT+1];
        for (String[] path : paths) Arrays.fill(path, "");
        queue.offer(new int[]{0, 0});
        visited[LIMIT][LIMIT] = true;
        int step = 0, dist;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist = (int) Math.pow(2, step);
            for (int s = 0; s < size; s++) {
                int[] cell = queue.poll();
                if (cell[0] == x && cell[1] == y) return paths[x+LIMIT][y+LIMIT];
                for (int i = 0; i < 4; i++) {
                    int xx = cell[0] + dirs[i][0] * dist;
                    int yy = cell[1] + dirs[i][1] * dist;
                    if (xx >= -LIMIT && xx <= LIMIT && yy >= -LIMIT && yy <= LIMIT && !visited[xx+LIMIT][yy+LIMIT]) {
                        visited[xx+LIMIT][yy+LIMIT] = true;
                        queue.offer(new int[]{xx, yy});
                        paths[xx+LIMIT][yy+LIMIT] = paths[cell[0]+LIMIT][cell[1]+LIMIT] + ways[i];
                    }
                }
            }
            step++;
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println("Case #" + ks + ": " + solve(x, y));
        }
    }
}