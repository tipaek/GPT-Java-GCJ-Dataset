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
            
            String result = bfs(targetX, targetY);
            System.out.println("Case #" + ll + ": " + result);
        }
    }

    private static String bfs(int targetX, int targetY) {
        Queue<Point> queue = new LinkedList<>();
        int multiplier = 1;
        queue.add(new Point(0, 0, ""));
        queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
        
        int level = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            if (p.x == targetX && p.y == targetY) {
                return p.s;
            }
            
            if (p.x == Integer.MAX_VALUE) {
                level++;
                multiplier *= 2;
                if (queue.isEmpty()) {
                    break;
                }
                if (queue.peek().x != Integer.MAX_VALUE) {
                    queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
                }
                continue;
            }
            
            if (Math.abs(p.x - targetX) >= multiplier) {
                queue.add(new Point(p.x - multiplier, p.y, "W" + p.s));
                queue.add(new Point(p.x + multiplier, p.y, "E" + p.s));
            }

            if (Math.abs(p.y - targetY) >= multiplier) {
                queue.add(new Point(p.x, p.y - multiplier, "N" + p.s));
                queue.add(new Point(p.x, p.y + multiplier, "S" + p.s));
            }
        }
        return "IMPOSSIBLE";
    }
}

class Point {
    public int x, y;
    public String s;

    public Point(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}