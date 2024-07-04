import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    Scanner             sc       = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintStream         out      = System.out;

    private void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int step = 0;
        Queue<int[]> queue = new LinkedList();
        Queue<String> steps = new LinkedList();
        queue.offer(new int[]{0, 0});
        steps.offer("");
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // N, S, E, W
        char[] dirStr = new char[]{'N', 'S', 'E', 'W'};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j=0;j<size;j++) {
                int[] tmp = queue.poll();
                String curStep = steps.poll();
                for (int i = 0; i < dirs.length; i++) {
                    int[] dir = dirs[i];
                    int thisStep = 1 << step;
                    int r = tmp[0] + dir[0] * thisStep;
                    int c = tmp[1] + dir[1] * thisStep;
                    if (r == x && c == y) {
                        out.println(curStep + dirStr[i]);
                        return;
                    } else if(r+c > x+y) {
                        out.println("IMPOSSIBLE");
                        return;
                    }else {
                        queue.offer(new int[]{r, c});
                        steps.offer(curStep + dirStr[i]);
                    }
                }
            }
            step++;
        }
        out.println("IMPOSSIBLE");
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            solve();
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }


}
