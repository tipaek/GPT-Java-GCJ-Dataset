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
                queue.add(Node.getOrCreate(0, 0));
                int steps = 1;

                while (steps < (x + y) * 2 && !queue.isEmpty()) {
                    int currentQueueSize = queue.size();

                    for (int j = 0; j < currentQueueSize; j++) {
                        Node currentNode = queue.poll();

                        {
                            Node westNode = currentNode.moveWest(steps);
                            if (westNode.isShorterThan(currentNode))
                                queue.add(westNode.withUpdatedPath(currentNode.path + 'W'));
                        }

                        {
                            Node eastNode = currentNode.moveEast(steps);
                            if (eastNode.isShorterThan(currentNode))
                                queue.add(eastNode.withUpdatedPath(currentNode.path + 'E'));
                        }

                        {
                            Node southNode = currentNode.moveSouth(steps);
                            if (southNode.isShorterThan(currentNode))
                                queue.add(southNode.withUpdatedPath(currentNode.path + 'S'));
                        }

                        {
                            Node northNode = currentNode.moveNorth(steps);
                            if (northNode.isShorterThan(currentNode))
                                queue.add(northNode.withUpdatedPath(currentNode.path + 'N'));
                        }
                    }

                    Node targetNode = Node.getOrCreate(x, y);

                    if (!targetNode.path.isEmpty())
                        break;

                    steps *= 2;
                }

                Node targetNode = Node.getOrCreate(x, y);
                String result = targetNode.path.isEmpty() ? "IMPOSSIBLE" : targetNode.path;
                System.out.printf("Case #%d: %s\n", i + 1, result);
            }
        }
    }

    private static final class Node {

        private static final Map<String, Node> NODE_CACHE = new HashMap<>();

        private final long x;
        private final long y;
        private String path = "";

        public static Node getOrCreate(long x, long y) {
            return NODE_CACHE.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean isShorterThan(Node node) {
            return path.isEmpty() || path.length() > node.path.length() + 1;
        }

        public Node withUpdatedPath(String path) {
            this.path = path;
            return this;
        }

        public Node moveEast(int steps) {
            return getOrCreate(x + steps, y);
        }

        public Node moveWest(int steps) {
            return getOrCreate(x - steps, y);
        }

        public Node moveSouth(int steps) {
            return getOrCreate(x, y - steps);
        }

        public Node moveNorth(int steps) {
            return getOrCreate(x, y + steps);
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }
}