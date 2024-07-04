import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;

        while (testCases-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(str.nextToken());
            int targetY = Integer.parseInt(str.nextToken());

            LinkedList<Point> queue = new LinkedList<>();
            int multiplier = 1;
            queue.add(new Point(0, 0, ""));
            int level = 1;
            queue.add(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE, ""));
            boolean found = false;
            String result = "";

            while (!queue.isEmpty() && level < 30) {
                Point p = queue.poll();

                if (p.x == targetX && p.y == targetY) {
                    found = true;
                    result = p.s;
                    break;
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

            if (found) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
    }

    static class Point {
        int x, y;
        String s;

        Point(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}