import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public class point {

        int x;
        int y;
        int jump;
        String path;

        public point(int a, int b, int j, String p) {
            this.x = a;
            this.y = b;
            this.jump = j;
            this.path = p;
        }
    }

    public void reachTarget(int caseno, int x, int y) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(0, 0, 0, ""));
        while (!queue.isEmpty()) {
            point current = queue.remove();
            if (current.x == x && current.y == y) {
                System.out.format("Case #%d: %s", caseno, current.path);
                System.out.println();
                return;
            }
            if (isInCircle(current.x, current.y, x, y)) {
                //n
                point north = new point(current.x, current.y + (int) Math.pow(2, current.jump), current.jump + 1, current.path.concat("N"));
                queue.add(north);
                //s
                point south = new point(current.x, current.y - (int) Math.pow(2, current.jump), current.jump + 1, current.path.concat("S"));
                queue.add(south);
                //e
                point east = new point(current.x + (int) Math.pow(2, current.jump), current.y, current.jump + 1, current.path.concat("E"));
                queue.add(east);
                //w
                point west = new point(current.x - (int) Math.pow(2, current.jump), current.y, current.jump + 1, current.path.concat("W"));
                queue.add(west);
            }
        }
        System.out.format("Case #%d: %s", caseno, "IMPOSSIBLE");
        System.out.println();
    }

    public boolean isInCircle(int cx, int cy, int x, int y) {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double newradius = Math.sqrt(Math.pow(cx, 2) + Math.pow(cy, 2));
        return newradius < radius;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution v = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            v.reachTarget(t, x, y);
        }
    }
}
