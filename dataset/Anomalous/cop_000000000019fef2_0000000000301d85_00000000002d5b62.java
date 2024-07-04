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

            for (int testCase = 1; testCase <= testCases; testCase++) {
                long targetX = scanner.nextLong();
                long targetY = scanner.nextLong();

                Queue<Node> queue = new LinkedList<>();
                queue.add(Node.getOrCreate(0, 0));
                int steps = 1;

                while (steps < (targetX + targetY) * 10 && !queue.isEmpty()) {
                    int nodesCount = queue.size();

                    for (int i = 0; i < nodesCount; i++) {
                        Node currentNode = queue.poll();

                        addNodeIfShorter(queue, currentNode.west(steps), currentNode, 'W');
                        addNodeIfShorter(queue, currentNode.east(steps), currentNode, 'E');
                        addNodeIfShorter(queue, currentNode.south(steps), currentNode, 'S');
                        addNodeIfShorter(queue, currentNode.north(steps), currentNode, 'N');
                    }

                    Node targetNode = Node.getOrCreate(targetX, targetY);
                    if (!targetNode.getPath().isEmpty()) {
                        break;
                    }

                    steps *= 2;
                }

                Node targetNode = Node.getOrCreate(targetX, targetY);
                String result = targetNode.getPath().isEmpty() ? "IMPOSSIBLE" : targetNode.getPath();
                System.out.printf("Case #%d: %s%n", testCase, result);
            }
        }
    }

    private static void addNodeIfShorter(Queue<Node> queue, Node newNode, Node currentNode, char direction) {
        if (newNode.isShorterThan(currentNode)) {
            queue.add(newNode.withPath(currentNode.getPath() + direction));
        }
    }

    private static final class Node {

        private static final Map<String, Node> NODES = new HashMap<>();
        private final long x;
        private final long y;
        private String path = "";

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public static Node getOrCreate(long x, long y) {
            return NODES.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        public boolean isShorterThan(Node other) {
            return path.isEmpty() || path.length() > other.path.length() + 1;
        }

        public Node withPath(String newPath) {
            this.path = newPath;
            return this;
        }

        public String getPath() {
            return path;
        }

        public Node east(int steps) {
            return getOrCreate(x + steps, y);
        }

        public Node west(int steps) {
            return getOrCreate(x - steps, y);
        }

        public Node south(int steps) {
            return getOrCreate(x, y - steps);
        }

        public Node north(int steps) {
            return getOrCreate(x, y + steps);
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }
}