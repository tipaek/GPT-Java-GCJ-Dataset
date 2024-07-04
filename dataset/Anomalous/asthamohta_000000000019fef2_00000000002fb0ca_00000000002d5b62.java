import java.util.*;

public class Solution {

    public static class Node {
        int x, y;
        String dir;

        Node(int x, int y, String dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static boolean inBound(int x1, int y1, int x, int y, int quad) {
        switch (quad) {
            case 1:
                return x1 <= x && y1 <= y;
            case 2:
                return x1 >= x && y1 <= y;
            case 3:
                return x1 >= x && y1 >= y;
            case 4:
                return x1 <= x && y1 >= y;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int quad = getQuadrant(x, y);

            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, ""));
            Node solution = null;

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.x > 10007 || current.y > 10007) break;

                if (current.x == x && current.y == y) {
                    solution = current;
                    break;
                }

                int step = (int) Math.pow(2, current.dir.length());
                addIfInBounds(queue, current.x + step, current.y, current.dir + "E", x, y, quad);
                addIfInBounds(queue, current.x - step, current.y, current.dir + "W", x, y, quad);
                addIfInBounds(queue, current.x, current.y + step, current.dir + "N", x, y, quad);
                addIfInBounds(queue, current.x, current.y - step, current.dir + "S", x, y, quad);
            }

            if (solution == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + solution.dir);
            }
        }

        sc.close();
    }

    private static int getQuadrant(int x, int y) {
        if (x >= 0 && y >= 0) return 1;
        if (x <= 0 && y >= 0) return 2;
        if (x <= 0 && y <= 0) return 3;
        return 4;
    }

    private static void addIfInBounds(LinkedList<Node> queue, int newX, int newY, String newDir, int x, int y, int quad) {
        if (inBound(newX, newY, x, y, quad)) {
            queue.add(new Node(newX, newY, newDir));
        }
    }
}