import java.util.LinkedList;
import java.util.Scanner;

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
                return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 1; t <= test; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int quad = determineQuadrant(x, y);

            LinkedList<Node> list = new LinkedList<>();
            list.add(new Node(0, 0, ""));
            Node solution = null;

            while (!list.isEmpty()) {
                Node current = list.removeFirst();
                if (current.x > 10007 || current.y > 10007)
                    break;

                if (current.x == x && current.y == y) {
                    solution = current;
                    break;
                }

                int step = (int) Math.pow(2, current.dir.length());
                addNodeIfInBounds(list, current.x + step, current.y, x, y, quad, current.dir + "N");
                addNodeIfInBounds(list, current.x - step, current.y, x, y, quad, current.dir + "S");
                addNodeIfInBounds(list, current.x, current.y + step, x, y, quad, current.dir + "E");
                addNodeIfInBounds(list, current.x, current.y - step, x, y, quad, current.dir + "W");
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

    private static void addNodeIfInBounds(LinkedList<Node> list, int newX, int newY, int x, int y, int quad, String newDir) {
        if (inBound(newX, newY, x, y, quad)) {
            list.addLast(new Node(newX, newY, newDir));
        }
    }
}