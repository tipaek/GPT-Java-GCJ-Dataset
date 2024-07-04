import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;

        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            LinkedList<Point> queue = new LinkedList<>();
            int multiplier = 1;
            queue.add(new Point(0, 0, ""));
            int level = 1;
            queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
            boolean found = false;
            String result = "";

            while (!queue.isEmpty() && level < 20) {
                Point p = queue.pollFirst();

                if (p.x == targetX && p.y == targetY) {
                    found = true;
                    result = p.path;
                    break;
                }

                if (p.x == Integer.MAX_VALUE) {
                    level++;
                    multiplier *= 2;
                    if (queue.isEmpty()) {
                        break;
                    }
                    if (queue.peekFirst().x != Integer.MAX_VALUE) {
                        queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
                    }
                    continue;
                }

                if (Math.abs(p.x - targetX) >= multiplier) {
                    queue.add(new Point(p.x - multiplier, p.y, "W" + p.path));
                    queue.add(new Point(p.x + multiplier, p.y, "E" + p.path));
                }

                if (Math.abs(p.y - targetY) >= multiplier) {
                    queue.add(new Point(p.x, p.y - multiplier, "N" + p.path));
                    queue.add(new Point(p.x, p.y + multiplier, "S" + p.path));
                }
            }

            if (found) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
    }
}

class Point {
    int x, y;
    String path;

    Point(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }
}