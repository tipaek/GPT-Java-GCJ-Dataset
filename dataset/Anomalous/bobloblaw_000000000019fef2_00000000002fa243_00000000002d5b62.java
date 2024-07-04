import java.util.*;

public class Solution {

    class Node {
        Position position;
        Node previous;
        char direction;

        public Node(Position position, Node previous, char direction) {
            this.position = position;
            this.previous = previous;
            this.direction = direction;
        }
    }

    class Position {
        long x, y, jumpSize;

        public Position(long x, long y, long jumpSize) {
            this.x = x;
            this.y = y;
            this.jumpSize = jumpSize;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y && jumpSize == position.jumpSize;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, jumpSize);
        }
    }

    public String jump(long goalX, long goalY) {
        Set<Position> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(new Position(0, 0, 1), null, 'X'));
        visited.add(new Position(0, 0, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.position.x == goalX && current.position.y == goalY) {
                return constructPath(current);
            }

            for (Node child : generateChildren(current)) {
                if (!visited.contains(child.position) && isViable(child, goalX, goalY)) {
                    queue.add(child);
                    visited.add(child.position);
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private boolean isViable(Node node, long goalX, long goalY) {
        return (node.position.x - goalX) % node.position.jumpSize == 0
                && (node.position.y - goalY) % node.position.jumpSize == 0;
    }

    private String constructPath(Node node) {
        StringBuilder path = new StringBuilder();
        while (node.previous != null) {
            path.append(node.direction);
            node = node.previous;
        }
        return path.reverse().toString();
    }

    private List<Node> generateChildren(Node current) {
        List<Node> children = new ArrayList<>();
        long jumpSize = current.position.jumpSize;
        long x = current.position.x;
        long y = current.position.y;

        children.add(new Node(new Position(x + jumpSize, y, jumpSize * 2), current, 'E'));
        children.add(new Node(new Position(x - jumpSize, y, jumpSize * 2), current, 'W'));
        children.add(new Node(new Position(x, y + jumpSize, jumpSize * 2), current, 'N'));
        children.add(new Node(new Position(x, y - jumpSize, jumpSize * 2), current, 'S'));

        return children;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            System.out.println(String.format("Case #%d: %s", testCase, solution.jump(x, y)));
        }
    }
}