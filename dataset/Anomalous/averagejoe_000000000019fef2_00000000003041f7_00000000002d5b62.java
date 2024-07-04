import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            int gridSize = 1000;
            boolean[][] visited = new boolean[gridSize][gridSize];

            Node startNode = new Node(0, 0);
            visited[gridSize / 2][gridSize / 2] = true;
            List<Node> currentFrontier = new ArrayList<>();
            currentFrontier.add(startNode);
            int stepPower = 0;
            boolean targetFound = false;

            while (!currentFrontier.isEmpty()) {
                List<Node> nextFrontier = new ArrayList<>();
                int stepSize = (int) Math.pow(2, stepPower);

                for (Node currentNode : currentFrontier) {
                    Node[] neighbors = {
                        new Node(currentNode.x + stepSize, currentNode.y, currentNode.path + "E"),
                        new Node(currentNode.x - stepSize, currentNode.y, currentNode.path + "W"),
                        new Node(currentNode.x, currentNode.y + stepSize, currentNode.path + "N"),
                        new Node(currentNode.x, currentNode.y - stepSize, currentNode.path + "S")
                    };

                    for (Node neighbor : neighbors) {
                        int adjustedX = neighbor.x + gridSize / 2;
                        int adjustedY = neighbor.y + gridSize / 2;

                        if (adjustedX >= gridSize || adjustedY >= gridSize || adjustedX < 0 || adjustedY < 0) {
                            continue;
                        }

                        if (!visited[adjustedX][adjustedY]) {
                            visited[adjustedX][adjustedY] = true;

                            if (neighbor.x == targetX && neighbor.y == targetY) {
                                System.out.printf("Case #%d: %s%n", caseNumber, neighbor.path);
                                targetFound = true;
                            }

                            nextFrontier.add(neighbor);
                        }
                    }
                }

                if (targetFound) {
                    break;
                }

                currentFrontier = nextFrontier;
                stepPower++;
            }

            if (!targetFound) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
            }
        }

        scanner.close();
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