import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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
            boolean found = false;

            while (!frontier.isEmpty()) {
                List<Node> newFrontier = new ArrayList<>();
                int stepSize = (int) Math.pow(2, power);
                for (Node currentNode : frontier) {
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
                                System.out.println(String.format("Case #%d: %s", caseNumber, neighbor.path));
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
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
            }
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