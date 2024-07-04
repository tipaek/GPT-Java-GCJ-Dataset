import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int c = 1; c <= n; c++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            final int SIZE = 100;
            boolean[][] visited = new boolean[SIZE][SIZE];

            Node start = new Node(0, 0);
            visited[SIZE / 2][SIZE / 2] = true;
            Queue<Node> queue = new LinkedList<>();
            queue.add(start);
            int power = 0;
            boolean found = false;

            while (!queue.isEmpty() && !found) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    Node current = queue.poll();
                    Node[] neighbors = {
                        new Node(current.x + (1 << power), current.y, current.path + "E"),
                        new Node(current.x - (1 << power), current.y, current.path + "W"),
                        new Node(current.x, current.y + (1 << power), current.path + "N"),
                        new Node(current.x, current.y - (1 << power), current.path + "S")
                    };

                    for (Node neighbor : neighbors) {
                        int xin = neighbor.x + SIZE / 2;
                        int yin = neighbor.y + SIZE / 2;
                        if (xin >= 0 && xin < SIZE && yin >= 0 && yin < SIZE && !visited[xin][yin]) {
                            visited[xin][yin] = true;
                            if (neighbor.x == X && neighbor.y == Y) {
                                System.out.println(String.format("Case #%d: %s", c, neighbor.path));
                                found = true;
                                break;
                            }
                            queue.add(neighbor);
                        }
                    }
                    if (found) break;
                }
                power++;
            }
            if (!found) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
            }
        }
    }

    static class Node {
        int x, y;
        String path;

        Node(int x, int y) {
            this(x, y, "");
        }

        Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}