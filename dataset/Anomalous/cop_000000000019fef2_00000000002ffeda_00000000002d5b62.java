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
            int testCases = scanner.nextInt();

            for (int i = 0; i < testCases; i++) {
                long x = scanner.nextLong();
                long y = scanner.nextLong();

                Queue<Node> queue = new LinkedList<>();
                queue.add(Node.createOrGet(0, 0).setSteps(1));
                int k = 1;

                while (k < (x + y) * 10 && !queue.isEmpty()) {
                    int nodesCount = queue.size();

                    for (int j = 0; j < nodesCount; j++) {
                        Node currentNode = queue.poll();

                        processNode(queue, currentNode, currentNode.moveWest(), 'W');
                        processNode(queue, currentNode, currentNode.moveEast(), 'E');
                        processNode(queue, currentNode, currentNode.moveSouth(), 'S');
                        processNode(queue, currentNode, currentNode.moveNorth(), 'N');
                    }

                    Node targetNode = Node.createOrGet(x, y);
                    if (targetNode.getSteps() != Integer.MAX_VALUE) break;
                }

                Node targetNode = Node.createOrGet(x, y);
                String result = targetNode.getPath().isEmpty() ? "IMPOSSIBLE" : targetNode.getPath();
                System.out.printf("Case #%d: %s\n", i + 1, result);
            }
        }
    }

    private static void processNode(Queue<Node> queue, Node currentNode, Node nextNode, char direction) {
        if (nextNode.getSteps() > currentNode.nextStep()) {
            queue.add(nextNode.setSteps(currentNode.nextStep()).setPath(currentNode.getPath() + direction));
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

        public int nextStep() {
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