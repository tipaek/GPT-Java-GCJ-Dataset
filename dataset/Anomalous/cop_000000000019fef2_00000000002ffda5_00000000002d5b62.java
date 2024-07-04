import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();

            for (int caseNum = 1; caseNum <= totalCases; caseNum++) {
                long targetX = scanner.nextLong();
                long targetY = scanner.nextLong();

                Queue<Node> queue = new LinkedList<>();
                queue.add(Node.createOrGet(0, 0).setSteps(1));
                int stepMultiplier = 1;

                while (stepMultiplier < (targetX + targetY) * 2 && !queue.isEmpty()) {
                    int currentLevelSize = queue.size();

                    for (int i = 0; i < currentLevelSize; i++) {
                        Node currentNode = queue.poll();

                        processDirection(queue, currentNode, currentNode.moveWest(), 'W');
                        processDirection(queue, currentNode, currentNode.moveEast(), 'E');
                        processDirection(queue, currentNode, currentNode.moveSouth(), 'S');
                        processDirection(queue, currentNode, currentNode.moveNorth(), 'N');
                    }

                    Node targetNode = Node.createOrGet(targetX, targetY);
                    if (targetNode.getSteps() != Integer.MAX_VALUE) {
                        break;
                    }
                }

                Node targetNode = Node.createOrGet(targetX, targetY);
                String result = targetNode.getPath().isEmpty() ? "IMPOSSIBLE" : targetNode.getPath();
                System.out.printf("Case #%d: %s%n", caseNum, result);
            }
        }
    }

    private static void processDirection(Queue<Node> queue, Node currentNode, Node newNode, char direction) {
        if (newNode.getSteps() > currentNode.calculateNextStep()) {
            queue.add(newNode.setSteps(currentNode.calculateNextStep()).setPath(currentNode.getPath() + direction));
        }
    }

    private static final class Node {

        private static final Map<String, Node> NODES = new HashMap<>();

        private final long x;
        private final long y;
        private int steps = Integer.MAX_VALUE;
        private String path = "";

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public static Node createOrGet(long x, long y) {
            return NODES.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        public int calculateNextStep() {
            return steps * 2;
        }

        public Node setSteps(int steps) {
            this.steps = steps;
            return this;
        }

        public Node setPath(String path) {
            this.path = path;
            return this;
        }

        public Node moveEast() {
            return createOrGet(x + steps, y);
        }

        public Node moveWest() {
            return createOrGet(x - steps, y);
        }

        public Node moveSouth() {
            return createOrGet(x, y - steps);
        }

        public Node moveNorth() {
            return createOrGet(x, y + steps);
        }

        public int getSteps() {
            return steps;
        }

        public String getPath() {
            return path;
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }
}