import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            int gridSize = Math.max(Math.abs(targetX), Math.abs(targetY)) * 10;
            boolean[][] visited = new boolean[gridSize][gridSize];

            Node startNode = new Node(0, 0);
            visited[gridSize / 2][gridSize / 2] = true;

            Queue<Node> queue = new LinkedList<>();
            queue.add(startNode);

            int power = 0;
            boolean pathFound = false;

            while (!queue.isEmpty()) {
                Queue<Node> nextQueue = new LinkedList<>();
                int stepSize = (int) Math.pow(2, power);

                while (!queue.isEmpty()) {
                    Node currentNode = queue.poll();
                    Node[] neighbors = new Node[]{
                        new Node(currentNode.x + stepSize, currentNode.y, currentNode.path + "E"),
                        new Node(currentNode.x - stepSize, currentNode.y, currentNode.path + "W"),
                        new Node(currentNode.x, currentNode.y + stepSize, currentNode.path + "N"),
                        new Node(currentNode.x, currentNode.y - stepSize, currentNode.path + "S")
                    };

                    for (Node neighbor : neighbors) {
                        int adjustedX = neighbor.x + gridSize / 2;
                        int adjustedY = neighbor.y + gridSize / 2;

                        if (adjustedX < 0 || adjustedY < 0 || adjustedX >= gridSize || adjustedY >= gridSize) {
                            continue;
                        }

                        if (!visited[adjustedX][adjustedY]) {
                            visited[adjustedX][adjustedY] = true;

                            if (neighbor.x == targetX && neighbor.y == targetY) {
                                System.out.println(String.format("Case #%d: %s", caseNum, neighbor.path));
                                pathFound = true;
                                break;
                            }

                            nextQueue.add(neighbor);
                        }
                    }

                    if (pathFound) {
                        break;
                    }
                }

                if (pathFound) {
                    break;
                }

                queue = nextQueue;
                power++;
            }

            if (!pathFound) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNum));
            }
        }
    }

    static class Node {
        String path;
        int x, y;

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