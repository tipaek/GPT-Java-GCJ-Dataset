import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int c = 1; c <= n; c++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int maxCoordinate = Math.max(Math.abs(X), Math.abs(Y)) * 10;
            boolean[][] visited = new boolean[maxCoordinate][maxCoordinate];

            Node start = new Node(0, 0);
            visited[maxCoordinate / 2][maxCoordinate / 2] = true;
            Queue<Node> frontier = new LinkedList<>();
            frontier.add(start);
            int power = 0;
            boolean found = false;

            while (!frontier.isEmpty()) {
                Queue<Node> newFrontier = new LinkedList<>();
                int step = (int) Math.pow(2, power);

                for (Node current : frontier) {
                    Node[] neighbors = {
                        new Node(current.x + step, current.y, current.path + "E"),
                        new Node(current.x - step, current.y, current.path + "W"),
                        new Node(current.x, current.y + step, current.path + "N"),
                        new Node(current.x, current.y - step, current.path + "S")
                    };

                    for (Node neighbor : neighbors) {
                        int xIndex = neighbor.x + maxCoordinate / 2;
                        int yIndex = neighbor.y + maxCoordinate / 2;

                        if (xIndex >= maxCoordinate || yIndex >= maxCoordinate || xIndex < 0 || yIndex < 0) {
                            continue;
                        }

                        if (!visited[xIndex][yIndex]) {
                            visited[xIndex][yIndex] = true;

                            if (neighbor.x == X && neighbor.y == Y) {
                                System.out.println(String.format("Case #%d: %s", c, neighbor.path));
                                found = true;
                                break;
                            }

                            newFrontier.add(neighbor);
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (found) {
                    break;
                }

                frontier = newFrontier;
                power++;
            }

            if (!found) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
            }
        }
        sc.close();
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