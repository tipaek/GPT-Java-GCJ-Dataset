import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    private static int count = Integer.MAX_VALUE;

    public static String solve(int[] nums, char[] moves) {
        count = Integer.MAX_VALUE;
        if(nums[0] == 0 && nums[1] == 0) return "0";
        int a = 0, b = 0, c = nums[1], d = nums[0];
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        x1 = Math.min(x1, nums[0]);
        x2 = Math.max(x2, nums[0]);
        y1 = Math.min(y1, nums[1]);
        y2 = Math.max(y2, nums[1]);

        for(char move: moves) {
            if(move == 'S') nums[1]--;
            if(move == 'N') nums[1]++;
            if(move == 'W') nums[0]--;
            if(move == 'E') nums[0]++;
            x1 = Math.min(x1, nums[0]);
            x2 = Math.max(x2, nums[0]);
            y1 = Math.min(y1, nums[1]);
            y2 = Math.max(y2, nums[1]);
        }

        int n = x2 - x1 + 1;
        int m = y2 - y1 + 1;
//        System.out.println("m=" + m + " n=" + n);
        a -= y1; b -= x1; c -= y1; d -= x1;
        int[][] graph = new int[m][n];
        int step = 0;
        graph[c][d] = step;
        for(char move: moves) {
            if(move == 'S') c--;
            if(move == 'N') c++;
            if(move == 'W') d--;
            if(move == 'E') d++;
            step++;
            graph[c][d] = step;
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println(a + " " + b);
        if(graph[a][b] > 0) {
            count = Math.min(count, graph[a][b]);
        }
//        System.out.println("before : " + count);
        bfs(a, b, graph);
        return count == Integer.MAX_VALUE ? "IMPOSSIBLE" : count + "";
    }

    private static int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static void bfs(int a, int b, int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        graph[a][b] = -1;
        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                for(int[] dir: dirs) {
                    int i = cur[0] + dir[0], j = cur[1] + dir[1];
                    if(i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || graph[i][j] < 0) continue;
                    if(graph[i][j] >= step) {
                        count = Math.min(count, graph[i][j]);
//                        System.out.println("step = " + step + " : " + count);
                    }
                    graph[i][j] = -step;
                    queue.add(new int[]{i, j});
                }
            }
//            for (int i = 0; i < graph.length; i++) {
//                for (int j = 0; j < graph[0].length; j++) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println("");
//            }
//            System.out.println("------------");
            step++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/round1c/t1/1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int[] nums = new int[2];
                nums[0] = scanner.nextInt();
                nums[1] = scanner.nextInt();
                String moves = scanner.next();
                System.out.println("Case #" + testNumber + ": " + solve(nums, moves.toCharArray()));
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}