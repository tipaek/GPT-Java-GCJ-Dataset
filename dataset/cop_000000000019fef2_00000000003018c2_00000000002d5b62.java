import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 11.04.2020
 */
public class Solution {

    public static void main(String... args) throws IOException {
        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();

            for (int i = 0; i < total; i++) {
                long x = scan.nextLong();
                long y = scan.nextLong();

                Queue<Node> nodes = new LinkedList<>();
                nodes.add(Node.getOrCreate(0, 0));
                int steps = 1;

                while (steps < (x + y) * 2 && !nodes.isEmpty()) {
                    int totalNodes = nodes.size();

                    for (int j = 0; j < totalNodes; j++) {
                        Node node = nodes.remove();

                        {
                            Node west = node.west(steps);
                            if (west.isShorter(node))
                                nodes.add(west.withPath(node.path + 'W'));
                        }

                        {
                            Node east = node.east(steps);
                            if (east.isShorter(node))
                                nodes.add(east.withPath(node.path + 'E'));
                        }

                        {
                            Node south = node.south(steps);
                            if (south.isShorter(node))
                                nodes.add(south.withPath(node.path + 'S'));
                        }

                        {
                            Node north = node.north(steps);
                            if (north.isShorter(node))
                                nodes.add(north.withPath(node.path + 'N'));
                        }
                    }

                    Node targetNode = Node.getOrCreate(x, y);

                    if (!targetNode.path.isEmpty())
                        break;

                    steps *= 2;
                }

                Node targetNode = Node.getOrCreate(x, y);
                String res = targetNode.path.isEmpty() ? "IMPOSSIBLE" : targetNode.path;
                System.out.format("Case #%d: %s\n", i + 1, res);
            }
        }
    }

    private static final class Node {

        private static final Map<String, Node> NODES = new HashMap<>();

        private final long x;
        private final long y;
        private String path = "";

        public static Node getOrCreate(long x, long y) {
            return NODES.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean isShorter(Node node) {
            return path.isEmpty() || path.length() > node.path.length() + 1;
        }

        public Node withPath(String path) {
            this.path = path;
            return this;
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
