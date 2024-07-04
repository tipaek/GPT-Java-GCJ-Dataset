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

    public static boolean inBound(int newX, int newY, int targetX, int targetY) {
        return Math.abs(newX) <= Math.abs(targetX) && Math.abs(newY) <= Math.abs(targetY);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int targetX = sc.nextInt();
            int targetY = sc.nextInt();
            int quadrant = determineQuadrant(targetX, targetY);

            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, ""));
            Node solution = null;

            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                if (current.x > 10007 || current.y > 10007) break;

                if (current.x == targetX && current.y == targetY) {
                    solution = current;
                    break;
                }

                int step = (int) Math.pow(2, current.dir.length());

                if (inBound(current.x + step, current.y, targetX, targetY)) {
                    queue.addLast(new Node(current.x + step, current.y, current.dir + "E"));
                }
                if (inBound(current.x - step, current.y, targetX, targetY)) {
                    queue.addLast(new Node(current.x - step, current.y, current.dir + "W"));
                }
                if (inBound(current.x, current.y + step, targetX, targetY)) {
                    queue.addLast(new Node(current.x, current.y + step, current.dir + "N"));
                }
                if (inBound(current.x, current.y - step, targetX, targetY)) {
                    queue.addLast(new Node(current.x, current.y - step, current.dir + "S"));
                }
            }

            if (solution == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + solution.dir);
            }
        }
    }

    private static int determineQuadrant(int x, int y) {
        if (x >= 0 && y >= 0) return 1;
        if (x <= 0 && y >= 0) return 2;
        if (x <= 0 && y <= 0) return 3;
        return 4;
    }
}