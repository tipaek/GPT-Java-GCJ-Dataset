import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            int gridSize = Math.max(Math.abs(targetX), Math.abs(targetY)) * 10;
            boolean[][] visited = new boolean[gridSize][gridSize];

            Node startNode = new Node(0, 0);
            visited[gridSize / 2][gridSize / 2] = true;

            List<Node> frontier = new ArrayList<>();
            frontier.add(startNode);

            int power = 0;
            boolean pathFound = false;

            while (!frontier.isEmpty()) {
                List<Node> newFrontier = new ArrayList<>();
                int step = (int) Math.pow(2, power);

                for (Node currentNode : frontier) {
                    Node[] neighbors = {
                        new Node(currentNode.x + step, currentNode.y, currentNode.path + "E"),
                        new Node(currentNode.x - step, currentNode.y, currentNode.path + "W"),
                        new Node(currentNode.x, currentNode.y + step, currentNode.path + "N"),
                        new Node(currentNode.x, currentNode.y - step, currentNode.path + "S")
                    };

                    for (Node neighbor : neighbors) {
                        int adjustedX = neighbor.x + gridSize / 2;
                        int adjustedY = neighbor.y + gridSize / 2;

                        if (adjustedX >= 0 && adjustedX < gridSize && adjustedY >= 0 && adjustedY < gridSize && !visited[adjustedX][adjustedY]) {
                            visited[adjustedX][adjustedY] = true;

                            if (neighbor.x == targetX && neighbor.y == targetY) {
                                System.out.printf("Case #%d: %s%n", caseNumber, neighbor.path);
                                pathFound = true;
                                break;
                            }
                            newFrontier.add(neighbor);
                        }
                    }
                    if (pathFound) break;
                }
                if (pathFound) break;

                frontier = newFrontier;
                power++;
            }

            if (!pathFound) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
            }
        }

        scanner.close();
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