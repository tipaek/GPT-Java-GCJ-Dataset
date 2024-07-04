import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int c = 1; c <= n; c++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int size = Math.max(Math.abs(X), Math.abs(Y)) * 3;
            boolean[][] visited = new boolean[size][size];

            Node start = new Node(0, 0);
            visited[size / 2][size / 2] = true;
            Queue<Node> frontier = new LinkedList<>();
            frontier.add(start);
            int power = 0;
            boolean found = false;

            while (!frontier.isEmpty()) {
                Queue<Node> newFront = new LinkedList<>();
                int step = (int) Math.pow(2, power);
                while (!frontier.isEmpty()) {
                    Node v = frontier.poll();
                    Node[] neighbors = {
                        new Node(v.x + step, v.y, v.path + "E"),
                        new Node(v.x - step, v.y, v.path + "W"),
                        new Node(v.x, v.y + step, v.path + "N"),
                        new Node(v.x, v.y - step, v.path + "S")
                    };
                    for (Node u : neighbors) {
                        int xin = u.x + size / 2;
                        int yin = u.y + size / 2;
                        if (xin >= size || yin >= size || xin < 0 || yin < 0) continue;
                        if (!visited[xin][yin]) {
                            visited[xin][yin] = true;
                            if (u.x == X && u.y == Y) {
                                System.out.println(String.format("Case #%d: %s", c, u.path));
                                found = true;
                            }
                            newFront.add(u);
                        }
                    }
                }
                if (found) break;
                frontier = newFront;
                power++;
            }
            if (!found) System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
        }
    }

    static class Node {
        String path;
        int x, y;

        Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        Node(int x, int y) {
            this(x, y, "");
        }
    }
}