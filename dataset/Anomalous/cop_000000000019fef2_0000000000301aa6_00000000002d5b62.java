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

            for (int i = 0; i < totalCases; i++) {
                long targetX = scanner.nextLong();
                long targetY = scanner.nextLong();

                Queue<Node> queue = new LinkedList<>();
                queue.add(Node.getOrCreate(0, 0));
                int steps = 1;

                while (!queue.isEmpty()) {
                    int currentLevelSize = queue.size();

                    for (int j = 0; j < currentLevelSize; j++) {
                        Node currentNode = queue.poll();

                        Node westNode = currentNode.moveWest(steps);
                        if (westNode.isShorterPath(currentNode)) {
                            queue.add(westNode.updatePath(currentNode.getPath() + 'W'));
                        }

                        Node eastNode = currentNode.moveEast(steps);
                        if (eastNode.isShorterPath(currentNode)) {
                            queue.add(eastNode.updatePath(currentNode.getPath() + 'E'));
                        }

                        Node southNode = currentNode.moveSouth(steps);
                        if (southNode.isShorterPath(currentNode)) {
                            queue.add(southNode.updatePath(currentNode.getPath() + 'S'));
                        }

                        Node northNode = currentNode.moveNorth(steps);
                        if (northNode.isShorterPath(currentNode)) {
                            queue.add(northNode.updatePath(currentNode.getPath() + 'N'));
                        }
                    }

                    Node targetNode = Node.getOrCreate(targetX, targetY);
                    if (!targetNode.getPath().isEmpty()) {
                        break;
                    }

                    steps *= 2;
                }

                Node targetNode = Node.getOrCreate(targetX, targetY);
                String result = targetNode.getPath().isEmpty() ? "IMPOSSIBLE" : targetNode.getPath();
                System.out.printf("Case #%d: %s%n", i + 1, result);
            }
        }
    }

    private static final class Node {
        private static final Map<String, Node> NODE_MAP = new HashMap<>();
        private final long x;
        private final long y;
        private String path = "";

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public static Node getOrCreate(long x, long y) {
            return NODE_MAP.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        public boolean isShorterPath(Node other) {
            return path.isEmpty() || path.length() > other.path.length() + 1;
        }

        public Node updatePath(String newPath) {
            this.path = newPath;
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

        public String getPath() {
            return path;
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }
}