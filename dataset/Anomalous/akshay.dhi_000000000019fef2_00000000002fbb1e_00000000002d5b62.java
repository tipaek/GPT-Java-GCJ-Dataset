import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
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

            while (!queue.isEmpty() && level < 10) {
                Point current = queue.poll();
                if (current.x == targetX && current.y == targetY) {
                    found = true;
                    result = current.path;
                    break;
                }

                if (current.x == Integer.MAX_VALUE) {
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

                queue.add(new Point(current.x - multiplier, current.y, "W" + current.path));
                queue.add(new Point(current.x + multiplier, current.y, "E" + current.path));
                queue.add(new Point(current.x, current.y - multiplier, "N" + current.path));
                queue.add(new Point(current.x, current.y + multiplier, "S" + current.path));
            }

            if (found) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
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