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

    public static boolean inBound(int x1, int y1, int x, int y) {
        return Math.abs(x1) <= Math.abs(x) + 1 && Math.abs(y1) <= Math.abs(y) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, ""));
            Node solution = null;

            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                if (current.x > 10007 || current.y > 10007) break;

                if (current.x == x && current.y == y) {
                    solution = current;
                    break;
                }

                int step = (int) Math.pow(2, current.dir.length());

                if (inBound(current.x + step, current.y, x, y)) {
                    queue.addLast(new Node(current.x + step, current.y, current.dir + "E"));
                }
                if (inBound(current.x - step, current.y, x, y)) {
                    queue.addLast(new Node(current.x - step, current.y, current.dir + "W"));
                }
                if (inBound(current.x, current.y + step, x, y)) {
                    queue.addLast(new Node(current.x, current.y + step, current.dir + "N"));
                }
                if (inBound(current.x, current.y - step, x, y)) {
                    queue.addLast(new Node(current.x, current.y - step, current.dir + "S"));
                }
            }

            if (solution == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + solution.dir);
            }
        }
        sc.close();
    }
}