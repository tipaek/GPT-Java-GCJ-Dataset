import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        for (int ll = 1; ll <= testCases; ll++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(str.nextToken());
            int targetY = Integer.parseInt(str.nextToken());

            LinkedList<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0, ""));
            queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
            int level = 1;
            int multiplier = 1;
            boolean found = false;
            String result = "";

            while (!queue.isEmpty() && level < 20) {
                Point p = queue.poll();
                if (p.x == targetX && p.y == targetY) {
                    found = true;
                    result = p.path;
                    break;
                }

                if (p.x == Integer.MAX_VALUE) {
                    level++;
                    multiplier *= 2;
                    if (queue.isEmpty() || queue.peek().x == Integer.MAX_VALUE) {
                        break;
                    }
                    queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
                    continue;
                }

                queue.add(new Point(p.x - multiplier, p.y, "W" + p.path));
                queue.add(new Point(p.x + multiplier, p.y, "E" + p.path));
                queue.add(new Point(p.x, p.y - multiplier, "N" + p.path));
                queue.add(new Point(p.x, p.y + multiplier, "S" + p.path));
            }

            if (found) {
                System.out.println("Case #" + ll + ": " + result);
            } else {
                System.out.println("Case #" + ll + ": IMPOSSIBLE");
            }
        }
    }
}

class Point {
    public int x, y;
    public String path;

    public Point(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }
}