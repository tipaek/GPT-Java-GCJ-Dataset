import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[] path = in.next().toCharArray();

            int curX = x;
            int curY = y;
            int minDistance = Integer.MAX_VALUE;
            for (int steps = 0; steps <= path.length; steps++) {
                // we start from (0,0), cat starts from (x, y)
                // distance from our starting point to current path point
                int dist = Math.abs(curX) + Math.abs(curY);
                if (steps >= dist) {
                    // We may need to stay sometimes
                    int ourPathLength = Math.max(dist, steps);
                    minDistance = Math.min(minDistance, ourPathLength);
                }
                if (steps != path.length) {
                    switch (path[steps]) {
                        case 'N':
                            curY++;
                            break;
                        case 'S':
                            curY--;
                            break;
                        case 'E':
                            curX++;
                            break;
                        case 'W':
                            curX--;
                            break;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %s", i, minDistance == Integer.MAX_VALUE ? "IMPOSSIBLE" : minDistance));
        }
    }
}
