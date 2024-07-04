import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= n; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            final int gridSize = 1000;
            boolean[][] visited = new boolean[gridSize][gridSize];
            Queue<Node> queue = new LinkedList<>();
            
            Node startNode = new Node(0, 0, "");
            queue.add(startNode);
            visited[gridSize / 2][gridSize / 2] = true;

            boolean found = false;
            int stepPower = 0;

            while (!queue.isEmpty() && !found) {
                int queueSize = queue.size();

                for (int i = 0; i < queueSize; i++) {
                    Node currentNode = queue.poll();
                    Node[] neighbors = new Node[]{
                        new Node(currentNode.x + (int) Math.pow(2, stepPower), currentNode.y, currentNode.path + "E"),
                        new Node(currentNode.x - (int) Math.pow(2, stepPower), currentNode.y, currentNode.path + "W"),
                        new Node(currentNode.x, currentNode.y + (int) Math.pow(2, stepPower), currentNode.path + "N"),
                        new Node(currentNode.x, currentNode.y - (int) Math.pow(2, stepPower), currentNode.path + "S")
                    };

                    for (Node neighbor : neighbors) {
                        int adjustedX = neighbor.x + gridSize / 2;
                        int adjustedY = neighbor.y + gridSize / 2;

                        if (adjustedX < 0 || adjustedX >= gridSize || adjustedY < 0 || adjustedY >= gridSize) continue;

                        if (!visited[adjustedX][adjustedY]) {
                            visited[adjustedX][adjustedY] = true;

                            if (neighbor.x == targetX && neighbor.y == targetY) {
                                System.out.printf("Case #%d: %s%n", caseNumber, neighbor.path);
                                found = true;
                                break;
                            }

                            queue.add(neighbor);
                        }
                    }

                    if (found) break;
                }

                stepPower++;
            }

            if (!found) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
            }
        }

        scanner.close();
    }

    static class Node {
        int x, y;
        String path;

        Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}