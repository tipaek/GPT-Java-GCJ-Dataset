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
                nodes.add(Node.getOrCreate(0, 0).withSteps(1));
                int k = 1;

                while (k < (x + y) * 10 && !nodes.isEmpty()) {
                    int totalNodes = nodes.size();

                    for (int j = 0; j < totalNodes; j++) {
                        Node node = nodes.poll();

                        {
                            Node west = node.west();
                            if (west.steps > node.nextStep())
                                nodes.add(west.withSteps(node.nextStep()).withPath(node.path + 'W'));
                        }

                        {
                            Node east = node.east();
                            if (east.steps > node.nextStep())
                                nodes.add(east.withSteps(node.nextStep()).withPath(node.path + 'E'));
                        }

                        {
                            Node south = node.south();
                            if (south.steps > node.nextStep())
                                nodes.add(south.withSteps(node.nextStep()).withPath(node.path + 'S'));
                        }

                        {
                            Node north = node.north();
                            if (north.steps > node.nextStep())
                                nodes.add(north.withSteps(node.nextStep()).withPath(node.path + 'N'));
                        }
                    }

                    Node targetNode = Node.getOrCreate(x, y);

                    if (targetNode.steps != Integer.MAX_VALUE)
                        break;
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
        private int steps = Integer.MAX_VALUE;
        private String path = "";

        public static Node getOrCreate(long x, long y) {
            return NODES.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public int nextStep() {
            return steps * 2;
        }

        public Node withSteps(int steps) {
            this.steps = steps;
            return this;
        }

        public Node withPath(String path) {
            this.path = path;
            return this;
        }

        public Node east() {
            return getOrCreate(x + steps, y);
        }

        public Node west() {
            return getOrCreate(x - steps, y);
        }

        public Node south() {
            return getOrCreate(x, y - steps);
        }

        public Node north() {
            return getOrCreate(x, y + steps);
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }

}